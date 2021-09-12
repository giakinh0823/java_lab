package j1.s.p0057;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author giaki
 */
public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static int menu() {
        System.out.println("1. Create a new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
        int number = 0;
        while (true) {
            try {
                System.out.print("> Choose: ");
                number = Integer.parseInt(bf.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
        return number;
    }

    public static void main(String[] args) {
        Manage manage = new Manage();
        while (true) {
            int number = menu();
            switch (number) {
                case 1:
                    manage.create();
                    break;
                case 2: 
                    manage.login();
                    break;
                case 3: 
                    break;
                default:
                    break;
            }
            if(number==3){
                break;
            }
        }
    }
}
