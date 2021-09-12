/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author giaki
 */
public class J1SP0020 {

    /**
     * @param args the command line arguments
     */
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static int[] randomArray(int range) {
        Random random = new Random();
        int arr[] = new int[range];
        for (int i = 0; i < range; i++) {
            arr[i] = random.nextInt(range - 1) + 1;
        }
        return arr;
    }

    private static int inputNumber(String message) {
        int number = 0;
        while (true) {
            try {
                System.out.println(message);
                number = Integer.parseInt(bf.readLine());
                if (number <= 0) {
                    throw new Exception("Number <= 0");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage() + " Please enter a number!");
            }
        }
        return number;
    }

    private static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int vt_min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[vt_min]) {
                    vt_min = j;
                }
            }
            if (vt_min != i) {
                int temp = arr[vt_min];
                arr[vt_min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int range = inputNumber("Enter number of array: ");
        int arr[] = randomArray(range);
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.print("Sorted array: " + Arrays.toString(arr));
    }

}
