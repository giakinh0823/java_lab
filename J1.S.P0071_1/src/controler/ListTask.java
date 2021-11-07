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
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.stream.Collectors;
import util.Inputter;

/**
 *
 * @author giaki
 */
public class ListTask extends ArrayList<Task> {

    private final Inputter inputter = new Inputter();
    

    public ListTask() {
    }

    public Task seachById(int id) {
        for (Task task : this) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    
    private String getTaskType(int id){
        switch(id){
            case 1 : 
                return "Code";
            case 2: 
                return "Test";
            case 3 : 
                return "Design";
            case 4 : 
                return "Review";
            default:
                return null;
        }
    }

    private Task inputTask(Task task) {
        String name = inputter.inputString("Requirement name: ", "[a-zA-Z ]+", task);
        int typeTask;
        typeTask = inputter.inputInt("Type task (choice id): ", 1, 4, task);
        Date date = inputter.inputDate("Date(MMM-dd-yyyy): ", "MMM-dd-yyyy", task); //Sep-dd-yyyy
        double planFrom = 8.5;
        double planTo = 8.5;
        if (task==null) {
            planFrom = inputter.inputDouble("Plan from: ", 8.5, 17.5, 0.5, null);
            planTo = inputter.inputDouble("Plan to: ", planFrom, 17.5, 0.5, null);
        } else {
            planFrom = inputter.inputDouble("Plan from: ", 8.5, 17.5, 0.5,task);
            do {
                planTo = inputter.inputDouble("Plan to: ", planFrom == -1 ? task.getPlanFrom() : planFrom, 17.5, 0.5, task);
                if (planTo < planFrom && planFrom != -1) {
                    System.out.println("Please enter planto >= " + planFrom);
                }
            } while (planTo < planFrom);
        }
        String assignee = inputter.inputString("Assignee: ", "[a-zA-Z ]+",task);
        String reviewer = inputter.inputString("Reviewer: ", "[a-zA-Z ]+",task);
        
        if (task != null) {
            if (name != null) task.setName(name);
            if (typeTask != -1) task.setTaskTypeID(typeTask);
            if (date != null) task.setDate(date);
            if(planFrom!=-1) task.setPlanFrom(planFrom);
            if(planTo!=-1) task.setPlanTo(planTo);
            if(assignee!=null) task.setAssignee(assignee);
            if(reviewer!=null) task.setReviewer(reviewer);
            return task;
        } else {
            Task newTask = new Task(typeTask, name, date, planFrom, planTo, assignee, reviewer);
            return newTask;
        }
    }

    public Task addTask() {
        Task task = inputTask(null);
        this.add(task);
        display();
        return task;
    }

    public Task updateTask() {
        display();
        int id = inputter.inputInt("Enter id to update: ", 1);
        Task task = seachById(id);
        if (task == null) {
            System.out.println("Not found id!");
            return null;
        }
        inputTask(task);
        display();
        return task;
    }

    public Task deleteTask() {
        display();
        int id = inputter.inputInt("Enter id to remove: ", 1);
        Task task = seachById(id);
        if (task == null) {
            System.out.println("Not found id!");
            return null;
        }
        this.remove(task);
        display();
        return task;
    }

    public void display() {
        System.out.println("---------------------------- Task descending order-----------------------------------");
        System.out.println(new String().format("%-8s %-12s %-15s %-14s %-10s %-12s %-10s", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer"));
        this.stream().sorted(new Comparator<Task>() {
            @Override
            public int compare(Task t, Task t1) {
                return -(t.getId() - t1.getId());
            }
        }).forEach(task -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String taskType = getTaskType(task.getTaskTypeID());
            System.out.println(
                    new String().format("%-5d %-15s %-12s %-18s %-9.1f %-12s %-10s",
                            task.getId(),
                            task.getName(),
                            taskType,
                            simpleDateFormat.format(task.getDate()),
                            task.getPlanTo() - task.getPlanFrom(),
                            task.getAssignee(),
                            task.getReviewer()));
        });
    }
}
