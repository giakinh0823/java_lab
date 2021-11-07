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

    public Task seachById(int id) {
        for (Task task : this) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private String getTaskType(int id) {
        switch (id) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
            default:
                return null;
        }
    }

    public Task addTask() {
        String name = inputter.inputString("Requirement name: ", "[a-zA-Z ]+", false);
        int typeTask;
        typeTask = inputter.inputInt("Type task (choice id): ", 1, 4, false);
        Date date = inputter.inputDate("Date(MMM-dd-yyyy): ", "MMM-dd-yyyy", false); //Sep-dd-yyyy
        double planFrom = inputter.inputDouble("Plan from: ", 8.5, 17.5, 0.5, false);
        double planTo = inputter.inputDouble("Plan to: ", planFrom, 17.5, 0.5, false);
        String assignee = inputter.inputString("Assignee: ", "[a-zA-Z ]+", false);
        String reviewer = inputter.inputString("Reviewer: ", "[a-zA-Z ]+", false);
        Task task = new Task(typeTask, name, date, planFrom, planTo, assignee, reviewer);
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
        String name = inputter.inputString("Requirement name: ", "[a-zA-Z ]+", true);
        if (name != null) task.setName(name);
        int taskType = inputter.inputInt("Type task (choice id): ", 1, 4, true);
        if (taskType != Integer.MIN_VALUE) task.setTaskTypeID(taskType);
        Date date = inputter.inputDate("Date(MMM-dd-yyyy): ", "MMM-dd-yyyy", true); //Sep-dd-yyyy
        if(date!=null) task.setDate(date);
        double planFrom = inputter.inputDouble("Plan from: ", 8.5, 17.5, 0.5, true);
        if (planFrom != Double.MIN_VALUE) task.setPlanFrom(planFrom);  
        double planTo = 0;
        do {
            planTo = inputter.inputDouble("Plan to: ", task.getPlanFrom(), 17.5, 0.5, true);
            if (planTo < planFrom) {
                System.out.println("Planto >= Planfrom " + task.getPlanFrom());
            }
        } while (planTo < planFrom);
        if (planTo != Double.MIN_VALUE) task.setPlanTo(planTo);
        String assignee = inputter.inputString("Assignee: ", "[a-zA-Z ]+", true);
        if (assignee != null) task.setAssignee(assignee);
        String reviewer = inputter.inputString("Reviewer: ", "[a-zA-Z ]+", true);
        if (reviewer != null) task.setReviewer(reviewer);
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
        this.stream()
                .sorted((t1, t2) -> -(t1.getId() - t2.getId()))
                .forEach(task -> {
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





























// public Task updateTask() {
//        display();
//        int id = inputter.inputInt("Enter id to update: ", 1);
//        Task task = seachById(id);
//        if (task == null) {
//            System.out.println("Not found id!");
//            return null;
//        }
//        String name = inputter.inputString("Requirement name: ", "[a-zA-Z ]+", true);
//        int taskType = inputter.inputInt("Type task (choice id): ", 1, 4, true);
//        Date date = inputter.inputDate("Date(MMM-dd-yyyy): ", "MMM-dd-yyyy", true); //Sep-dd-yyyy
//        double planFrom = inputter.inputDouble("Plan from: ", 8.5, 17.5, 0.5, true);
//        double planTo = 0;
//        do {
//            planTo = inputter.inputDouble("Plan to: ", planFrom!=Double.MIN_VALUE ? planFrom : task.getPlanFrom(), 17.5, 0.5, true);
//            if (planTo < planFrom) {
//                System.out.println("Planto >= Planfrom " + task.getPlanFrom());
//            }
//        } while (planTo < planFrom);
//        String assignee = inputter.inputString("Assignee: ", "[a-zA-Z ]+", true);
//        String reviewer = inputter.inputString("Reviewer: ", "[a-zA-Z ]+", true);
//        
//        if (name != null) task.setName(name);
//        if (taskType != Integer.MIN_VALUE) task.setTaskTypeID(taskType);
//        if(date!=null) task.setDate(date);
//        if (planFrom != Double.MIN_VALUE) task.setPlanFrom(planFrom);
//        if (planTo != Double.MIN_VALUE) task.setPlanTo(planTo);
//        if (assignee != null) task.setAssignee(assignee);
//        if (reviewer != null) task.setReviewer(reviewer);
//        display();
//        return task;
//    }