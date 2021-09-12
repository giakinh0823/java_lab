/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h211;

import java.util.Arrays;

/**
 *
 * @author giaki
 */

public class J1SH211 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int arr[] = new int[]{5, 2, 2, -5, -1, 3, 2, 4, 1, 1, 1, 0, 2, 17};
        ArrayIntList list = new ArrayIntList(arr, arr.length);
        System.out.println(Arrays.toString(list.getElementData()));
        try {
            list.fromCounts();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(list.getElementData()));
    }
    
}
