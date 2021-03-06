/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author giaki
 */
public class Task {

    private static int idTask = 0;
    private int id;
    private int taskTypeID;
    private String name;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task() {
        this.id = ++idTask;
    }

    public Task(int taskTypeID, String name, Date date, double planFrom, double planTo, String assignee, String reviewer, Boolean isContructor) {
        if (isContructor) {
            this.id = ++idTask;
        }
        this.taskTypeID = taskTypeID;
        this.name = name;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public void update(Task task) {
        if (task.getTaskTypeID() != 0) {
            this.taskTypeID = task.getTaskTypeID();
        }
        if (task.getName() != null) {
            this.name = task.getName();
        }
        if (task.getDate() != null) {
            this.date = task.getDate();
        }
        if(task.getPlanFrom()!=-1){
            this.planFrom = task.getPlanFrom();
        }
        if(task.getPlanTo()!=-1){
            this.planTo = task.getPlanTo();
        }
        if (task.getAssignee() != null) {
            this.assignee = task.getAssignee();
        }
        if (task.getReviewer() != null) {
            this.reviewer = task.getReviewer();
        }
    }

    public static int getIdTask() {
        return idTask;
    }

    public static void setIdTask(int idTask) {
        Task.idTask = idTask;
    }

    public int getId() {
        return id;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

}
