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
import model.Task;
import model.TaskType;
import util.Inputter;

/**
 *
 * @author giaki
 */
public class ListTask extends ArrayList<Task> {

    private final Inputter inputter = new Inputter();
    ListTaskType listTaskType;

    public ListTask(ListTaskType listTaskType) {
        this.listTaskType = listTaskType;
    }

    public Task seachById(int id) {
        for (Task task : this) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private Task inputTask(Boolean isContructor, Task task) {
        String name = inputter.inputString("Requirement name: ", "[a-zA-Z ]+");
        int typeTask;
        listTaskType.display();
        typeTask = inputter.inputInt("Type task (choice id): ", 1, listTaskType.size());
        Date date = inputter.inputDate("Date(MMM-dd-yyyy): ", "MMM-dd-yyyy"); //Sep-dd-yyyy
        double planFrom = 8.5;
        double planTo = 8.5;
        if (isContructor) {
            planFrom = inputter.inputDouble("Plan from: ", 8.5, 17.5, 0.5);
            planTo = inputter.inputDouble("Plan to: ", planFrom, 17.5, 0.5);
        } else {
            planFrom = inputter.inputDouble("Plan from: ", 8.5, 17.5, 0.5); 
            do{
                planTo = inputter.inputDouble("Plan to: ", planFrom == -1 ? task.getPlanFrom() : planFrom, 17.5, 0.5);
                if(planTo<planFrom && planFrom != -1){
                    System.out.println("Please enter planto > "+planFrom);
                }
            }while(planTo<planFrom && planFrom != -1);
        }
        String assignee = inputter.inputString("Assignee: ", "[a-zA-Z ]+");
        String reviewer = inputter.inputString("Reviewer: ", "[a-zA-Z ]+");
        Task newTask = new Task(typeTask, name, date, planFrom, planTo, assignee, reviewer, isContructor);
        return newTask;
    }

    public Task addTask() {
        Task task = inputTask(true, null);
        this.add(task);
        display();
        return task;
    }

    public Task updateTask() {
        display();
        int id = inputter.inputInt("Enter id to update: ", 1);
        Task task =  seachById(id);
        if (task == null) {
            System.out.println("Not found id!");
            return null;
        }
        Task newTask = inputTask(false, task);
        task.update(newTask);
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
        });
    }
}
