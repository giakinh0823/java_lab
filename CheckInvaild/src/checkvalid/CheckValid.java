/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkvalid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author lanh0
 */
public class CheckValid {

    /**
     * @param args the command line arguments
     */
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
    }

    //Text, number, data/time, email
    String checkStr(String mess, String regex) {
        String text;
        do {
            System.out.println(mess);
            text = scanner.nextLine();
            if (text.matches(regex)) {
                break;
            }
            System.out.println("Invalid input, plz reenter by following: '" + regex + "'");
        } while (true);
        return text;
    }
    String AddrEmptyOrNot = checkStr("Enter your address", "[a-zA-Z0-9 ]*");
    String Name = checkStr("Enter your name: ", "[a-zA-Z] +");
    String Phone = checkStr("Enter your phone: ", "(+[0-9]{1,2})?[0-9]{8,11}");
    String Email = checkStr("Enter your email: ", "[a-zA-Z]\\w+@\\w+(\\.[a-zA-Z0-9]+){1,3}");

    int CheckInt(String mess, int min, int max) {
        int num;
        do {
            System.out.println(mess);
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num >= min && num <= max) {
                    break;
                } else {
                    System.out.println("Out of range, plz enter in range (from " + min + " to " + max);
                }
            } catch (Exception e) {
                System.out.println("Invalid input, accept integer number only!");
            }
        } while (true);
        return num;

    }
    int choice = CheckInt("Enter your choice: ", 1, 4);
    int size = CheckInt("Enter a size of array: ", 1, 100);
    int element = CheckInt("Enter an integer: ", Integer.MIN_VALUE, Integer.MAX_VALUE);

    Date CheckDate(String mess, String formate) {
        Date date = new Date();
        SimpleDateFormat SD = new SimpleDateFormat(formate);
        SD.setLenient(false);
        do {
            System.out.println(mess);
            try {
                date = SD.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid date input, plz reenter by following: '" + formate + "'");
            }
        } while (true);
        return date;
    }

    Date date1 = CheckDate("Enter date (dd-MM-yyyy): ", "dd-MM-yyyy"); //08-09-2021;
    Date date2 = CheckDate("Enter date(dd/MM/yyyy)", "dd/MM/yyyy");
    Date date3 = CheckDate("Enter date (MM/dd/yyyy)", "MM/dd/yyyy");
    Date date4 = CheckDate("Enter date {September-dd-yyyy", "MMMM-dd-yyyy");
    Date date5 = CheckDate("Enter date {Sep-dd-yyyy", "MMM-dd-yyyy");
}
