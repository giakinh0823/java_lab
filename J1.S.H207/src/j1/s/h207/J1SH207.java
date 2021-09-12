/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author giaki
 */
public class J1SH207 {

    /**
     * @param args the command line arguments
     */
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    
    private static int secondHalfLetters(String str){
        int max = (int)str.charAt(0); 
        int min = (int)str.charAt(0);
        for(int i=1; i<str.length(); i++){
            if((int)str.charAt(i)>max){
                max = (int)str.charAt(i);
            }
            if((int)str.charAt(i)<min){
                min = (int)str.charAt(i);  
            }
        }
        int mid = (min+max)/2;
        String regex = "[^"+(char)mid+"-"+(char)max+"-"+
                (""+(char)mid).toUpperCase()+"-"+(""+(char)max).toUpperCase()+"]";
        return str.replaceAll(regex, "").length(); 
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String str = bf.readLine();
        System.out.println(secondHalfLetters(str));
    }
    
}
