/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h206;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author giaki
 */
public class J1SH206 {

    /**
     * @param args the command line arguments
     */
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static int inputNumber(String message) {
        int number;
        do {
            try {
                System.out.print(message);
                number = Integer.parseInt(bf.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a number!");
            }

        } while (true);
        return number;
    }

    private static void printSquare(int min, int max) {
        for (int i = min; i <= max; i++) {
            for (int j = i; j <= max; j++) {
                System.out.print(j);
            }
            for (int j = min; j < i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void printSquare2(int min, int max) {
        String str = "";
        for (int i = min; i <= max; i++) {
            int value = Math.abs(i);
            str += value;
        }
        int numMin = Integer.parseInt(str.charAt(0) + "");
        int vtMin = 0;
        int numMax = Integer.parseInt(str.charAt(0) + "");
        int vtMax = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            int value = Integer.parseInt(str.charAt(i) + "");  
            if (value > numMax) {
                numMax = value;
                vtMax = i;    
            } else if (value == numMax) {
                int p = vtMax + 1;
                int q = i + 1;
                int valueAfterMax1 = Integer.parseInt(str.charAt(p) + "");
                int valueAfterMax2 = Integer.parseInt(str.charAt(q) + "");
                while (valueAfterMax1 == valueAfterMax2) {
                    if(q==i) break;
                    if (p < str.length()-1) {
                        p++;
                    } else {
                        p = 0;
                    }
                    if (q < str.length()-1) {
                        q++;
                    } else {
                        q = 0;
                    }
                    valueAfterMax1 = Integer.parseInt(str.charAt(p) + "");
                    valueAfterMax2 = Integer.parseInt(str.charAt(q) + "");
                }
                if (valueAfterMax1 < valueAfterMax2) {
                    numMax = value;
                    vtMax = i;
                }
            }

            if (value < numMin) {
                numMin = value;
                vtMin = i;
            } else if (value == numMin) {
                int p = vtMin + 1;
                int q = i + 1;
                int valueAfterMin1 = Integer.parseInt(str.charAt(p) + "");
                int valueAfterMin2 = Integer.parseInt(str.charAt(q) + "");
                while (valueAfterMin1 == valueAfterMin2 && p < str.length() - 1 && q < str.length() - 1) {
                    p++;
                    q++;
                    valueAfterMin1 = Integer.parseInt(str.charAt(p) + "");
                    valueAfterMin2 = Integer.parseInt(str.charAt(q) + "");
                }
                if (valueAfterMin1 > valueAfterMin2) {
                    numMin = value;
                    vtMin = i;
                }
            }
        }
        String strMin = str.substring(vtMin) + str.substring(0, vtMin);
        String strMax = str.substring(vtMax) + str.substring(0, vtMax);
        if (min >= 0) {
            System.out.println(strMin);
            for (int i = 0; i < strMin.length(); i++) {
                strMin = strMin.substring(1) + strMin.substring(0, 1);
                System.out.println(strMin);
                if (strMin.equals(strMax)) {
                    break;
                }
            }
        } else {
            System.out.println("-"+strMax);
            for (int i = 0; i < strMax.length(); i++) {
                strMax = strMax.substring(1) + strMax.substring(0, 1);
                System.out.println("-" + strMax);
                if (strMax.equals(strMin)) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int min = 0;
        int max = 0;
        do {
            min = inputNumber("Min = ");
            max = inputNumber("Max = ");
            if (min > max) {
                System.out.println("Min < Max");
            }
        } while (min > max);
        printSquare2(min, max);
    }

}
