/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0023;

import util.Menu;
import controler.ListProduct;
import controler.ListShopping;
import java.util.ArrayList;

/**
 *
 * @author giaki
 */
public class J1LP0023 {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        ListProduct listProduct = new ListProduct();
        ArrayList<String> options = new  ArrayList<String>();
        ListShopping listShopping = new ListShopping();
        options.add("Create Fruit");
        options.add("Update Fruit");
        options.add("View orders");
        options.add("Shopping (for buyer)");
        options.add("Exit");
        while (true) {            
            int choice = menu.getChoice(options);
            switch(choice){
                case 1:
                    listProduct.createProduct();
                    break;
                case 2:
                    listProduct.updateProduct();
                    break;
                case 3:
                    listShopping.display();
                    break;
                case 4:
                    listShopping.shopping(listProduct);
                    break;
                case 5:
                    break;
            }
            if(choice == 5) break;
        }
    }
    
}
