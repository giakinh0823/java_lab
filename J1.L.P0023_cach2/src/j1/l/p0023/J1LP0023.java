/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0023;

import util.Menu;
import controler.ListFruit;
import controler.ListShopping;
import java.util.ArrayList;
import model.Fruit;

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
        ListFruit listFruit = new ListFruit();
        ListShopping listShopping = new ListShopping();
        
        // Khởi tạo giá trị để test
        listFruit.add(new Fruit(1,"Apple", 10, 20, "Vietname"));
        listFruit.add(new Fruit(2,"Orange", 7, 25, "Thailand"));
        listFruit.add(new Fruit(3,"Coco", 18, 30, "France"));
        listFruit.add(new Fruit(4,"Grape", 8, 15, "US"));
        listFruit.add(new Fruit(5,"banana", 15, 42, "Japan"));
        
        ArrayList<String> options = new  ArrayList<String>();
        options.add("Create Fruit");
        options.add("Update Fruit");
        options.add("View orders");
        options.add("Shopping (for buyer)");
        options.add("Exit");
        while (true) {            
            int choice = menu.getChoice(options);
            switch(choice){
                case 1:
                    listFruit.createFruit();
                    break;
                case 2:
                    listFruit.updateFruit();
                    break;
                case 3:
                    listShopping.display();
                    break;
                case 4:
                    listShopping.shopping(listFruit);
                    break;
                case 5:
                    break;
            }
            if(choice == 5) break;
        }
    }
    
}
