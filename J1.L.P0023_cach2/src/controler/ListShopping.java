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

/**
 *
 * @author giaki
 */
public class ListShopping extends Hashtable<String, ArrayList<Fruit>> {

    private final Inputter inputter = new Inputter();
    
    public void showOrder(ArrayList<Fruit> orders){
        System.out.println(new String().format("%s|%s|%s|%s", "Product","Quantity","Price ","Amount"));
        double total = 0;
        for (int i = 0; i <orders.size(); i++) {
            total += orders.get(i).getQuantity()*orders.get(i).getPrice();
            System.out.println(new String().format("%-10s %-6d %.0f$ %6.0f$", 
                    orders.get(i).getName(), 
                    orders.get(i).getQuantity(), 
                    orders.get(i).getPrice(),
                    orders.get(i).getQuantity()*orders.get(i).getPrice()));
        }
        System.out.println(new String().format("Total: %.0f$", total));
    }

    public void display() {
        this.forEach((key, value) -> {
            String name = key.trim().split("-",2)[1].trim();
            System.out.println("Customer: " + name);
            showOrder(value);
            System.out.println();
        });
    }

    public void shopping(ListFruit listFruit) {
        ArrayList<Fruit> orders = new ArrayList<>();
        while (true) {
            ListFruit listFruit1 = listFruit.display();
            int indexItem = 0;
            indexItem = inputter.inputInt("Select product (0 to exit): ", 0, listFruit1.size());
            if (indexItem == 0) {
                return;
            }
            Fruit fruit = listFruit1.get(indexItem-1);
            System.out.println("You selected: " + fruit.getName());
            int quantity = inputter.inputInt("Please input quantity: ", 1, fruit.getQuantity());
            boolean check = false;
            for (Fruit order : orders) {
                if (order.getId() == fruit.getId()) {
                    order.setQuantity(order.getQuantity() + quantity);
                    check = true;
                    break;
                }
            }
            if (!check) {
                orders.add(new Fruit(fruit.getId(),fruit.getName(),fruit.getPrice(), quantity, fruit.getOrigin()));
            }
            fruit.setQuantity(fruit.getQuantity() - quantity);
            boolean isOrderNow = inputter.inputYesNo("Do you want order now(Y or N)?: ");
            if (isOrderNow) {
                break;
            }
        }
        showOrder(orders);
        if(orders.isEmpty()){
            System.out.println("Please order product!");
        } else {
            String customer = inputter.inputString("Input your name: ", "[a-zA-Z ]+");
            this.put(this.size()+"-"+customer, orders);
            System.out.println("Order success!");
        }
    }
}
