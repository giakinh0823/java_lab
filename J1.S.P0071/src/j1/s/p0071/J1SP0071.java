/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

import controler.ListTask;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Task;
import util.Menu;

/**
 *
 * @author giaki
 */
public class J1SP0071 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Menu menu = new Menu();
        ArrayList<String> options = new ArrayList<String>();
        options.add("Add task");
        options.add("Update task");
        options.add("Delete task");
        options.add("Show task");
        options.add("Exit");
        ListTask listTask = new ListTask();
        
        // Khởi tạo giá trị để test
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");
        simpleDateFormat.setLenient(false);
        Date date = simpleDateFormat.parse("Aug-10-2021");
        listTask.add(new Task(1, "Dev Program", date, 9.5, 17.5, "Developer", "Lead Dev"));
        date = simpleDateFormat.parse("Dec-22-2021");
        listTask.add(new Task(3, "Dev Design", date, 8.5, 17.5, "Designer", "Lead Design"));
        date = simpleDateFormat.parse("Sep-29-2021");
        listTask.add(new Task(2, "Dev Test", date, 10.5, 15.5, "Tester", "Lead Test"));
        date = simpleDateFormat.parse("Jun-02-2021");
        listTask.add(new Task(4, "Dev Review", date, 10.5, 12.5, "Reviewer", "Lead Review"));
        
        
        while (true) {
            int choice = menu.getChoice(options);
            switch (choice) {
                case 1:
                    listTask.addTask();
                    break;
                case 2:
                    listTask.updateTask();
                    break;
                case 3:
                    listTask.deleteTask();
                    break;
                case 4:
                    listTask.display();
                    break;
                case 5:
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }

}
