/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h209;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author giaki
 */
public class J1SH209 {

    /**
     * @param args the command line arguments
     */
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static Hashtable<String, Integer> initData = new Hashtable<String, Integer>();
    private static final String filename = "D:\\FPT UNIVERSITY\\STUDY\\KY 3\\JAVA LAB\\Assigments\\J1.S.H209\\src\\j1\\s\\h209\\J1SH209.txt";

    private static void initValue() {
        initData.put("pennies", 1);
        initData.put("nickels", 5);
        initData.put("dimes", 10);
        initData.put("quarters", 25);
    }

    private static String inputString(String message) {
        String str = "";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bf = new BufferedReader(fr);
            String line = bf.readLine();
            while (line != null) {
                str+=line;
                line = bf.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File doesn't exits!.");
        } catch (IOException ex) {
            System.out.println("Lỗi xảy ra " + ex.getMessage());
        }
        return str;
    }

    private static double countCoins(String str) {
        String listString[] = str.toLowerCase().split("\\s+");
        Hashtable<String, Integer> data = new Hashtable<String, Integer>();
        for (int i = 0; i < listString.length - 1; i++) {
            try {
                int value = Integer.parseInt(listString[i]);
                String key = listString[i + 1];
                if (data.containsKey(key)) {
                    value += data.get(key);
                }
                data.put(key, value);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double total = 0;
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            total += initData.get(key) * value;
        }
        return total / 100;
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        initValue();
        String str = inputString("");
        System.out.println(countCoins(str));
    }

}
