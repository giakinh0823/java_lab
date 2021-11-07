/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import util.Inputter;
import model.Shopping;
import model.Order;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import model.Fruit;

/**
 *
 * @author giaki
 */
public class ListShopping extends Hashtable<String, Shopping> {

    private final Inputter inputter = new Inputter();

    public void display() {
        this.forEach((key, value) -> {
            System.out.println("Customer: " + key);
            value.showOrder();
            System.out.println();
        });
    }

    public void shopping(ListFruit listFruit) {
        Shopping shopping = new Shopping();
        while (true) {
            ListFruit listFruit1 = listFruit.display();
            int indexItem = 0;
            indexItem = inputter.inputInt("Select product (0 to exit): ", 0, listFruit1.size());
            if (indexItem == 0) {
                return;
            }
            Fruit fruit = listFruit.searchById(listFruit1.get(indexItem-1).getId());
            System.out.println("You selected: " + fruit.getName());
            int quantity = inputter.inputInt("Please input quantity: ", 1, fruit.getQuantity());
            boolean check = false;
            for (Order order : shopping.getOrders()) {
                if (order.getFruit().getId() == fruit.getId()) {
                    order.setQuantity(order.getQuantity() + quantity);
                    check = true;
                    break;
                }
            }
            if (!check) {
                shopping.getOrders().add(new Order(fruit, quantity));
            }
            fruit.setQuantity(fruit.getQuantity() - quantity);
            boolean isOrderNow = inputter.inputYesNo("Do you want order now(Y or N)?: ");
            if (isOrderNow) {
                break;
            }
        }
        shopping.showOrder();
        if(shopping.getOrders().isEmpty()){
            System.out.println("Please order product!");
        } else {
            String customer = inputter.inputString("Input your name: ", "[a-zA-Z ]+");
            shopping.setCustomer(customer);
            Enumeration<String> enums = this.keys();
            while (enums.hasMoreElements()) {
                String key = enums.nextElement();
                if (key.equals(shopping.getCustomer())) {
                    for (int j = 0; j < shopping.getOrders().size(); j++) {
                        Order value = shopping.getOrders().get(j);
                        boolean isExit = false;
                        for (int i = 0; i < this.get(key).getOrders().size(); i++) {
                            Order order = this.get(key).getOrders().get(i);
                            if (value.getFruit().getId() == order.getFruit().getId()) {
                                order.setQuantity(value.getQuantity() + order.getQuantity());
                                isExit = true;
                                break;
                            }
                        }
                        if (!isExit) {
                            this.get(key).getOrders().add(value);
                        }
                    }
                    System.out.println("Order success!");
                    return;
                }
            }
            this.put(shopping.getCustomer(), shopping);
            System.out.println("Order success!");
        }
    }
}
