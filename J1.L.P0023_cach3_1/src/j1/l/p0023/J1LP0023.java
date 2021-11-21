/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0023;

import util.Menu;
import controler.FruitManage;
import controler.ShoppingManage;
import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;

/**
 *
 * @author giaki
 */
public class J1LP0023 {

    /**
     * @param args the command line arguments
     */
    private static final Menu menu = new Menu();
    private static final ArrayList<String> options = new  ArrayList<String>();
    
    private static final ArrayList<Fruit> listFruit = new ArrayList<Fruit>();
    private static final Hashtable<String, ArrayList<Fruit>> listShopping = new Hashtable<>();
    
    private static final FruitManage FRUIT_MANAGE = new FruitManage(listFruit);
    private static final ShoppingManage SHOPPING_MANAGE = new ShoppingManage(listShopping,listFruit);
    
    public static void main(String[] args) {
        // TODO code application logic here

        // Khởi tạo giá trị để test
        listFruit.add(new Fruit(1,"Apple", 10, 20, "Vietname"));
        listFruit.add(new Fruit(2,"Orange", 7, 25, "Thailand"));
        listFruit.add(new Fruit(3,"Coco", 18, 30, "France"));
        listFruit.add(new Fruit(4,"Grape", 8, 15, "US"));
        listFruit.add(new Fruit(5,"banana", 15, 42, "Japan"));
        
        // Các option để chọn
        options.add("Create Fruit");
        options.add("Update Fruit");
        options.add("View orders");
        options.add("Shopping (for buyer)");
        options.add("Exit");
        while (true) {            
            int choice = menu.getChoice(options);
            switch(choice){
                case 1:
                    FRUIT_MANAGE.createFruit();
                    break;
                case 2:
                    FRUIT_MANAGE.updateFruit();
                    break;
                case 3:
                    SHOPPING_MANAGE.display();
                    break;
                case 4:
                    SHOPPING_MANAGE.shopping();
                    break;
                case 5:
                    break;
            }
            if(choice == 5) break;
        }
    }
    
}
