/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import util.Inputter;
import model.Product;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author giaki
 */
public class ListProduct extends ArrayList<Product> {

    private final Inputter inputter = new Inputter();
    
    public void display(){
        System.out.println(new String().format("|++%s++|++%s++|++%s++|++%s++|++%s++|", "Item","Fruit Name","Origin","Price", "Quantity"));
        for (int i = 0; i <this.size(); i++) {
            System.out.println(new String().format("%5d %15s %12s %6.0f$ %10s",i+1,this.get(i).getName(), this.get(i).getOrigin(), this.get(i).getPrice(), this.get(i).getQuantity()));
        }
    }
    
    public void displayHaveId(){
        System.out.println(new String().format("|++%s++|++%s++|++%s++|++%s++|++%s++|", "Item","id","Fruit Name","Origin","Price", "Quantity"));
        for (int i = 0; i <this.size(); i++) {
            System.out.println(new String().format("%5d %8s %10s %12s %6.0f$ %10s",i+1,this.get(i).getId(),this.get(i).getName(), this.get(i).getOrigin(), this.get(i).getPrice(), this.get(i).getQuantity()));
        }
    }

    public Product searchById(int id) {
        for (Product product : this) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        this.add(product);
        System.out.println("Add product success!");
    }

    public void createProduct() {
        while (true) {
            String name = inputter.inputString("Enter name product: ", "[a-zA-Z0-9 ]+");
            double price = inputter.inputDouble("Enter price: ", 0);
            int quantity = inputter.inputInt("Enter quantity: ", 0);
            String origin = inputter.inputString("Enter origin: ", "[a-zA-Z0-9 ]+");
            Product product = new Product(name, price, quantity, origin);
            this.add(product);
            System.out.println("Create product success!");
            boolean oneMoreTime = inputter.inputYesNo("Continue create product (Y or N)?: ");
            if (!oneMoreTime) {
                display();
                return;
            }
        }
    }

    public void updateProduct() {
        displayHaveId();
        int id = inputter.inputInt("Enter id product: ", 0);
        if (searchById(id) != null) {
            int quantity = inputter.inputInt("Enter quantity: ", 0);
            for (Product product : this) {
                if (product.getId() == id) {
                    product.setQuantity(quantity);
                    break;
                }
            }
            display();
        } else {
            boolean isCreate = inputter.inputYesNo("Not found product! Do you want create new product (Y or N)?: ");
            if (isCreate) {
                createProduct();
            }
        }
    }
    
    public void updateProduct(int id, int quantity) {
        if (searchById(id) != null) {
            for (Product product : this) {
                if (product.getId() == id) {
                    product.setQuantity(quantity);
                    break;
                }
            }
        } else {
            System.out.println("Not found product!");
        }
    }

    public void deleteProduct() {
        int id = inputter.inputInt("Enter id product: ", 0);
        if (searchById(id) != null) {
            for (Iterator<Product> iterator = this.iterator(); iterator.hasNext();) {
                Product next = iterator.next();
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
