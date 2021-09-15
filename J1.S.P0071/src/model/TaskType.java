/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author giaki
 */
public class TaskType {
    private static int idTaskType = 0;
    private int id;
    private String name;

    public TaskType(String name) {
        this.id = ++idTaskType;
        this.name = name;
    }

    public static int getIdTaskType() {
        return idTaskType;
    }

    public static void setIdTaskType(int idTaskType) {
        TaskType.idTaskType = idTaskType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
