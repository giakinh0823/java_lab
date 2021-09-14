/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Order;
import java.util.ArrayList;

/**
 *
 * @author giaki
 */
public class Shopping {
    private String customer;
    private ArrayList<Order> orders = new ArrayList<>();

    public Shopping() {
    }

    public Shopping(String customer, ArrayList<Order> orders) {
        this.customer = customer;
        this.orders = orders;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    
    public void showOrder(){
        System.out.println(new String().format("%s|%s|%s|%s", "Product","Quantity","Price ","Amount"));
        double total = 0;
        for (int i = 0; i <orders.size(); i++) {
            total += orders.get(i).getQuantity()*orders.get(i).getFruit().getPrice();
            System.out.println(new String().format("%5s %5d %8.0f$ %8.0f$", 
                    orders.get(i).getFruit().getName(), 
                    orders.get(i).getQuantity(), 
                    orders.get(i).getFruit().getPrice(),
                    orders.get(i).getQuantity()*orders.get(i).getFruit().getPrice()));
        }
        System.out.println(new String().format("Total: %.0f$", total));
    }
   
 
}
