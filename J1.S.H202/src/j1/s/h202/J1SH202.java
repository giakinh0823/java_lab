/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author giaki
 */
public class J1SH202 {
    /**
     * @param args the command line arguments
     */
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static void printReverse(String str) {
        for (int i = str.length()-1; i >=0; i-- ) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        String str = bufferedReader.readLine();
        if(!str.isEmpty()){
            printReverse(str);
        }
    }    
}
