/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giaki
 */
public class Order {

    private String customer;
    private List<Fruit> listFruits;

    public Order() {
        this.listFruits = new ArrayList<Fruit>();
    }

    public Order(String customer, List<Fruit> listFruits) {
        this.customer = customer;
        this.listFruits = listFruits;
    }

    public void addListFrui(List<Fruit> listFruits) {
        this.listFruits = listFruits;
    }

    public void addFruit(Fruit fruit) {
        listFruits.add(fruit);
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Fruit> getListFruits() {
        return this.listFruits;
    }

    public void setListFruits(List<Fruit> listFruits) {
        this.listFruits = listFruits;
    }
}
