/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giaki
 */
public class Inputter {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int inputInt(String message) {
        int number = 0;
        do {
            try {
                System.out.print(message);
                number = Integer.parseInt(bufferedReader.readLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number!");
            } catch (IOException ex) {
                System.out.println("Something error!");
            }
        } while (true);
        return number;
    }

    public int inputInt(String message, int min) {
        int number = 0;
        do {
            try {
                System.out.print(message);
                number = Integer.parseInt(bufferedReader.readLine().trim());
                if (number < min) {
                    System.out.println("Please input number => " + min);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number!");
            } catch (IOException ex) {
                System.out.println("Something error!");
            }
        } while (true);
        return number;
    }

    public int inputInt(String message, int min, int max) {
        if (min > max) {
            int z = min;
            min = max;
            max = z;
        }
        int number = 0;
        do {
            try {
                System.out.print(message);
                number = Integer.parseInt(bufferedReader.readLine().trim());
                if (number < min || number > max) {
                    System.out.println("Please input number (" + min + "->" + max + ")");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number!");
            } catch (IOException ex) {
                System.out.println("Something error!");
            }
        } while (true);
        return number;
    }
    
    public int inputInt(String message, int min, int max,boolean isShopping) {
        if (min > max) {
            int z = min;
            min = max;
            max = z;
        }
        int number = 0;
        do {
            try {
                System.out.print(message);
                String input = bufferedReader.readLine().trim();
                if(input.equalsIgnoreCase("nope") && isShopping){
                    return Integer.MIN_VALUE;
                }
                number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.out.println("Please input number (" + min + "->" + max + ")");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number!");
            } catch (IOException ex) {
                System.out.println("Something error!");
            }
        } while (true);
        return number;
    }
    

    public double inputDouble(String message) {
        double number = 0;
        do {
            try {
                System.out.print(message);
                number = Double.parseDouble(bufferedReader.readLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number!");
            } catch (IOException ex) {
                System.out.println("Something error!");
            }
        } while (true);
        return number;
    }

    public double inputDouble(String message, double min) {
        double number = 0;
        do {
            try {
                System.out.print(message);
                number = Double.parseDouble(bufferedReader.readLine().trim());
                if (number < min) {
                    System.out.println("Please input number >=" + min);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number!");
            } catch (IOException ex) {
                System.out.println("Something error!");
            }
        } while (true);
        return number;
    }

    public double inputDouble(String message, double min, double max) {
        if (min > max) {
            double z = min;
            min = max;
            max = min;
        }
        double number = 0;
        do {
            try {
                System.out.print(message);
                number = Double.parseDouble(bufferedReader.readLine().trim());
                if (number < min || number > max) {
                    System.out.println("Please input number (" + min + "->" + max + ")");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number!");
            } catch (IOException ex) {
                System.out.println("Something error!");
            }
        } while (true);
        return number;
    }

    public String inputString(String message) {
        String str = null;
        do {
            System.out.print(message);
            try {
                str = bufferedReader.readLine().trim();
            } catch (IOException ex) {
                System.out.println("Something error!");
            }
            if (str.isEmpty() || str == null) {
                System.out.println("Please input not empty!");
            }
        } while (str.isEmpty() || str == null);

        return str;
    }

    public String inputString(String message, String regex) {
        String str = null;
        do {
            System.out.print(message);
            try {
                str = bufferedReader.readLine().trim();
                if (!str.matches(regex)) {
                    System.out.println("Please follow " + regex);
                }
            } catch (IOException ex) {
                System.out.println("Something error!");
            }
            if (str.isEmpty() || str == null) {
                System.out.println("Please input not empty!");
            }
        } while (str.isEmpty() || str == null || !str.matches(regex));

        return str;
    }
    
    public String inputString(String message, String regex, boolean isShopping) {
        String str = null;
        do {
            System.out.print(message);
            try {
                str = bufferedReader.readLine().trim();
                if(str.equalsIgnoreCase("nope") && isShopping){
                    return null;
                }
                if (!str.matches(regex)) {
                    System.out.println("Please follow " + regex);
                }
            } catch (IOException ex) {
                System.out.println("Something error!");
            }
            if (str.isEmpty() || str == null) {
                System.out.println("Please input not empty!");
            }
        } while (str.isEmpty() || str == null || !str.matches(regex));

        return str;
    }

    public String inputStringNoSpace(String message) {
        String str = null;
        do {
            System.out.print(message);
            try {
                str = bufferedReader.readLine().trim();
            } catch (IOException ex) {
                System.out.println("Something error!");
            }
            if (str.indexOf(" ") != -1) {
                System.out.println("Please input not space!");
                continue;
            }
            if (str.isEmpty() || str == null) {
                System.out.println("Please input not empty!");
            }
        } while (str.isEmpty() || str == null || str.indexOf(" ") != -1);

        return str;
    }

    public boolean inputBoolean(String message) {
        boolean bool;
        do {
            try {
                System.out.print(message);
                bool = Boolean.parseBoolean(bufferedReader.readLine().trim());
                break;
            } catch (Exception e) {
                System.out.println("Please input true or false!");
            }
        } while (true);
        return bool;
    }

    public boolean inputYesNo(String message) {
        String str = null;
        do {
            try {
                System.out.print(message);
                str = bufferedReader.readLine().trim();
                if (!str.toLowerCase().equals("y") && !str.toLowerCase().equals("n")) {
                    System.out.println("Please enter y or n!");
                }
            } catch (IOException ex) {
                System.out.println("Something error");
            }
        } while (!str.toLowerCase().equals("y") && !str.toLowerCase().equals("n"));
        return str.toLowerCase().equals("y") ? true : false;
    }
}
