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
        listFruit.display();
        Shopping shopping = new Shopping();
        while (true) {
            int indexItem = 0;
            while (true) {
                indexItem = inputter.inputInt("Select product (0 to exit): ", 0, listFruit.size());
                if (indexItem == 0 || listFruit.get(indexItem - 1).getQuantity() > 0) {
                    break;
                } else {
                    System.out.println("Product is out of stock!");
                }
            }
            if (indexItem == 0) {
                break;
            }
            System.out.println("You selected: " + listFruit.get(indexItem - 1).getName());
            int quantity = inputter.inputInt("Please input quantity: ", 1, listFruit.get(indexItem - 1).getQuantity());
            boolean check = false;
            for (Order order : shopping.getOrders()) {
                if (order.getFruit().getId() == listFruit.get(indexItem - 1).getId()) {
                    order.setQuantity(order.getQuantity() + quantity);
                    check = true;
                    break;
                }
            }
            if (!check) {
                shopping.getOrders().add(new Order(listFruit.get(indexItem - 1), quantity));
            }
            listFruit.get(indexItem - 1).setQuantity(listFruit.get(indexItem - 1).getQuantity() - quantity);
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
                            if (value.getFruit().getId() == this.get(key).getOrders().get(i).getFruit().getId()) {
                                this.get(key).getOrders().get(i).setQuantity(value.getQuantity() + this.get(key).getOrders().get(i).getQuantity());
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
