/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import util.Inputter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giaki
 */
public class Menu {

    private static Inputter inputter = new Inputter();
    
    public int getChoice(ArrayList<String> options) {
        int i = 1;
        for (String option : options) {
            System.out.println(i + ". " + option);
            i++;
        }
        int number = inputter.inputInt("Choose 1 -> " + options.size() + ": ", 1,options.size());
        return number;
    }

    public int getChoice(Object[] options) {
        int i = 1;
        for (Object option : options) {
            System.out.println(i + ". " + option.toString());
            i++;
        }
        int number = inputter.inputInt("Choose 1 -> " + options.length + ": ", 1,options.length);
        return number;
    }
}
