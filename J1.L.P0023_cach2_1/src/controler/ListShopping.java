/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.text.SimpleDateFormat;
import util.Inputter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import model.Fruit;
import model.Order;

/**
 *
 * @author giaki
 */
public class ListShopping {
    private final Inputter inputter = new Inputter();
    private Hashtable<String, Order> listShopping;

    public ListShopping() {
        listShopping = new Hashtable<>();
    }
    
    public void showOrder(List<Fruit> listFruit){
        System.out.println(new String().format("%s|%s|%s|%s", "Product","Quantity","Price ","Amount"));
        double total = 0;
        for (int i = 0; i <listFruit.size(); i++) {
            Fruit fruit = listFruit.get(i);
            total += fruit.getQuantity()*fruit.getPrice();
            System.out.println(new String().format("%-10s %-6d %.0f$ %6.0f$", 
                    fruit.getName(), 
                    fruit.getQuantity(), 
                    fruit.getPrice(),
                    fruit.getQuantity()*fruit.getPrice()));
        }
        System.out.println(new String().format("Total: %.0f$", total));
    }

    public void display() {
        listShopping.forEach((customer, order) -> {
            System.out.println("Customer: " + customer);
            showOrder(order.getListFruits());
            System.out.println();
        });
    }

    public void shopping(ListFruit listFruit) {
        Order order = new Order();
        while (true) {
            ListFruit listFruit1 = listFruit.display();
            if(listFruit1.isEmpty()) break;
            int indexItem = 0;
            indexItem = inputter.inputInt("Select product: ", 1, listFruit1.size());            Fruit fruit = listFruit1.get(indexItem-1);
            System.out.println("You selected: " + fruit.getName());
            int quantity = inputter.inputInt("Please input quantity: ", 1, fruit.getQuantity());
            boolean check = false;
            for (Fruit fruit1 : order.getListFruits()) {
                if (fruit1.getId() == fruit.getId()) {
                    fruit1.setQuantity(fruit1.getQuantity() + quantity);
                    check = true;
                    break;
                }
            }
            if (!check) {
                order.addFruit(new Fruit(fruit.getId(),fruit.getName(),fruit.getPrice(), quantity, fruit.getOrigin()));
            }
            fruit.setQuantity(fruit.getQuantity() - quantity);
            boolean isOrderNow = inputter.inputYesNo("Do you want order now(Y or N)?: ");
            if (isOrderNow) {
                break;
            }
        }
        showOrder(order.getListFruits());
        if(order.getListFruits().isEmpty()){
            System.out.println("Order empty!");
        } else {
            String customer = inputter.inputString("Input your name: ", "[a-zA-Z ]+");
            order.setCustomer(customer);
            listShopping.put(customer+" - "+listShopping.size(), order);
            System.out.println("Order success!");
        }
    }
}
