/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import model.Task;
import model.TaskType;
import util.Inputter;

/**
 *
 * @author giaki
 */
public class ListTask extends ArrayList<Task> {

    private final Inputter inputter = new Inputter();
    private final ListTaskType listTaskType = new ListTaskType();

    public Task seachById(int id) {
        for (Task task : this) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    
    public Task addTask() {
        String name = inputter.inputString("Requirement name: ", "[a-zA-Z ]+");
        int typeTask;
        do {          
            listTaskType.display();
            typeTask = inputter.inputInt("Type task (choice id): ", 1);
            if(listTaskType.searchId(typeTask)==null){
                System.out.println("Not found type task!");
            }else{
                break;
            }
        } while (true);
        Date date = inputter.inputDate("Date: ", "MMM-dd-yyyy"); //Sep-dd-yyyy
        double planFrom = inputter.inputDouble("Plan from: ", 8.5, 17.5, 0.5);
        double planTo = inputter.inputDouble("Plan to: ", planFrom, 17.5, 0.5);
        String assignee = inputter.inputString("Assignee: ", "[a-zA-Z ]+");
        String reviewer = inputter.inputString("Reviewer: ", "[a-zA-Z ]+");
        Task task = new Task(typeTask, name, date, planFrom, planTo, assignee, reviewer);
        this.add(task);
        display();
        return task;
    }

    public Task updateTask() {
        display();
        int id;
        Task task = null;
        do {            
            id = inputter.inputInt("Enter id to remove(0 to exit): ", 0);
            if(id == 0) return null;
            task=seachById(id);
            if(task==null){
                System.out.println("Not found id!");
            }else{
                break;
            }
        } while (true);
        String name = inputter.inputString("Requirement name: ", "[a-zA-Z ]+");
        int typeTask;
        do {          
            listTaskType.display();
            typeTask = inputter.inputInt("Type task (choice id): ", 1);
            if(listTaskType.searchId(typeTask)==null){
                System.out.println("Not found type task!");
            }else{
                break;
            }
        } while (true);
        Date date = inputter.inputDate("Date: ", "MMM-dd-yyyy"); //Sep-dd-yyyy
        double planFrom = inputter.inputDouble("Plan from: ", 8.5, 17.5, 0.5);
        double planTo = inputter.inputDouble("Plan to: ", planFrom, 17.5, 0.5);
        String assignee = inputter.inputString("Assignee: ", "[a-zA-Z ]+");
        String reviewer = inputter.inputString("Reviewer: ", "[a-zA-Z ]+");
        task.setName(name);
        task.setTaskTypeID(typeTask);
        task.setDate(date);
        task.setPlanFrom(planFrom);
        task.setPlanTo(planTo);
        task.setAssignee(assignee);
        task.setReviewer(reviewer);
        display();
        return task;
    }

    public void deleteTask() {
        display();
        int id;
        do {            
            id = inputter.inputInt("Enter id to remove(0 to exit): ", 0);
            if(id == 0) return;
            if(seachById(id)==null){
                System.out.println("Not found id!");
            }else{
                break;
            }
        } while (true);
        Iterator<Task> iterator = this.iterator();
        while (iterator.hasNext()) {
            Task next = iterator.next();
            if(next.getId() == id){
                iterator.remove();
            }
        }
        display();
    }

    public void display() {
        System.out.println("---------------------------- Task descending order-----------------------------------");
        System.out.println(new String().format("%-8s %-12s %-15s %-14s %-10s %-12s %-10s", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer"));
        for (Task task : this) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            TaskType taskType = listTaskType.searchId(task.getTaskTypeID());
            System.out.println(
                    new String().format("%-5d %-15s %-12s %-18s %-9.1f %-12s %-10s",
                            task.getId(), 
                            task.getName(), 
                            taskType.getName(), 
                            simpleDateFormat.format(task.getDate()), 
                            task.getPlanTo() - task.getPlanFrom(), 
                            task.getAssignee(), 
                            task.getReviewer()));
        }
    }
}
