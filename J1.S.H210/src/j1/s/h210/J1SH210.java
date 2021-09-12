/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h210;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giaki
 */
public class J1SH210 {

    /**
     * @param args the command line arguments
     */
        
    private static ArrayList<String> loadData(String filename){
        ArrayList<String> data = new ArrayList<String>();
        try {
           FileReader fr = new FileReader(filename);
           BufferedReader bf = new BufferedReader(fr);
           String line=bf.readLine();
           while(line!=null){
               data.add(line);
               line = bf.readLine();
           }
        } catch (FileNotFoundException ex) {
            System.out.println("File doesn't exits!.");
        } catch (IOException ex) {
            System.out.println("Lỗi xảy ra " + ex.getMessage());
        }
        return data;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> data = loadData("D:\\FPT UNIVERSITY\\STUDY\\KY 3\\JAVA LAB\\Assigments\\J1.S.H210\\src\\j1\\s\\h210\\J1SH210.txt");
        for (int i = 0; i < data.size()-1; i=i+2) {
            String temp = data.get(i);
            data.set(i, data.get(i+1));
            data.set(i+1, temp);
        }
        data.forEach(System.out::println);
    }
    
}
