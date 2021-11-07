/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import util.Inputter;
import model.Fruit;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author giaki
 */
public class ListFruit extends ArrayList<Fruit> {

    private final Inputter inputter = new Inputter();
    
    public ListFruit display(){
        System.out.println(new String().format("|++%s++|++%s++|++%s++|++%s++|++%s++|", "Item","Fruit Name","Origin","Price", "Quantity"));
        ListFruit listFruit = new ListFruit();
        int dem =0;
        for (int i = 0; i <this.size(); i++) {
           if(this.get(i).getQuantity()>0){
               listFruit.add(this.get(i));
               System.out.println(new String().format("%5d %15s %12s %6.0f$ %10s",dem+1,this.get(i).getName(), this.get(i).getOrigin(), this.get(i).getPrice(), this.get(i).getQuantity()));
               dem++;
           }
        }
        return listFruit;
    }
    
    public void displayHaveId(){
        System.out.println(new String().format("|++%s++|++%s++|++%s++|++%s++|++%s++|", "Item","id","Fruit Name","Origin","Price", "Quantity"));
        for (int i = 0; i <this.size(); i++) {
            System.out.println(new String().format("%5d %8s %10s %12s %6.0f$ %10s",i+1,this.get(i).getId(),this.get(i).getName(), this.get(i).getOrigin(), this.get(i).getPrice(), this.get(i).getQuantity()));
        }
    }

    public Fruit searchById(int id) {
        for (Fruit fruit : this) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }
        return null;
    }

    public void addFruit(Fruit fruit) {
        this.add(fruit);
        System.out.println("Add product success!");
    }

    public void createFruit() {
        while (true) {
            String name = inputter.inputString("Enter name product: ", "[a-zA-Z0-9 ]+");
            double price = inputter.inputDouble("Enter price: ", 0);
            int quantity = inputter.inputInt("Enter quantity: ", 0);
            String origin = inputter.inputString("Enter origin: ", "[a-zA-Z0-9 ]+");
            Fruit fruit = new Fruit(name, price, quantity, origin);
            this.add(fruit);
            System.out.println("Create product success!");
            boolean oneMoreTime = inputter.inputYesNo("Continue create product (Y or N)?: ");
            if (!oneMoreTime) {
                display();
                return;
            }
        }
    }

    public void updateFruit() {
        displayHaveId();
        int id = inputter.inputInt("Enter id product: ", 0);
        Fruit fruit=null;
        if ((fruit=searchById(id)) != null) {
            int quantity = inputter.inputInt("Enter quantity: ", 0);
            fruit.setQuantity(fruit.getQuantity()+quantity);
            display();
        } else {
            boolean isCreate = inputter.inputYesNo("Not found product! Do you want create new product (Y or N)?: ");
            if (isCreate) {
                createFruit();
            }
        }
    }
 

    public void deleteFruit() {
        int id = inputter.inputInt("Enter id product: ", 0);
        if (searchById(id) != null) {
            for (Iterator<Fruit> iterator = this.iterator(); iterator.hasNext();) {
                Fruit next = iterator.next();
                if(next.getId() == id){
                    iterator.remove();
                    System.out.println("Remove product success!");
                    break;
                }
            }
        } else {
            System.out.println("Not found product");
        }
    }
}
