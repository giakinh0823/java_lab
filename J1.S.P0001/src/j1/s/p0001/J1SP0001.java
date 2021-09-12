/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author giaki
 */
public class J1SP0001 {

    /**
     * @param args the command line arguments
     */
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static int[] randomArray(int range) {
        Random random = new Random();
        int arr[] = new int[range];
        for (int i = 0; i < range; i++) {
            arr[i] = random.nextInt(range-1) + 1;
        }
        return arr;
    }

    private static int inputNumber(String message) {
        int number = 0;
        while (true) {
            try {
                System.out.println(message);
                number = Integer.parseInt(bf.readLine());
                if(number <= 0){
                    throw new Exception("Number <= 0");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage()+ " Please enter a number!");
            }
        }
        return number;
    }

    private static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int range = inputNumber("Enter number of array: ");
        int arr[] = randomArray(range);
        System.out.println("Unsorted array: "+Arrays.toString(arr));
        bubbleSort(arr);
        System.out.print("Sorted array: "+Arrays.toString(arr));
    }
}
