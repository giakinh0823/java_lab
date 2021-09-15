/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import model.TaskType;

/**
 *
 * @author giaki
 */
public class ListTaskType extends ArrayList<TaskType>{

    public ListTaskType() {
        this.add(new TaskType("Code"));
        this.add(new TaskType("Test"));
        this.add(new TaskType("Design"));
        this.add(new TaskType("Review"));
    }
    
    public void display(){
        System.out.println(new String().format("%-8s %s", "Id", "Name"));
        for (int i = 0; i < this.size(); i++) {
            System.out.println(new String().format("%-8d %s", this.get(i).getId(), this.get(i).getName()));
        }
    }
    
    public TaskType searchId(int id){
        for (TaskType taskType : this) {
            if(taskType.getId()==id){
                return taskType;
            } 
        }
        return null;
    }
}
