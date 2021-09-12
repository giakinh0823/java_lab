/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h208;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author giaki
 */
public class J1SH208 {

    /**
     * @param args the command line arguments
     */
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static int inputNumber(String message) {
        int number;
        do {
            try {
                System.out.print(message);
                number = Integer.parseInt(bf.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a number!");
            }

        } while (true);
        return number;
    }

    private static int swapDigitPairs(int number){
        int result = 0;
        int unit = 1;
        while(number > 0){
            int num1 = number % 10; //234 = 2
            number /= 10;     //0
            if(number == 0){
                result += unit * num1;  
                break;
            }
            int num2 = number % 10; 
            number /= 10; 
            result += unit * 10 * num1 + unit * num2; 
                      //40 + 3 =43
            unit *= 100;       
        }
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int number = inputNumber("");
        System.out.println(swapDigitPairs(number));
    }

}
