package j1.s.p0057;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author giaki
 */
public class Manage {

    private final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    File file = new File("D:\\FPT UNIVERSITY\\STUDY\\KY 3\\JAVA LAB\\Assigments\\J1.S.P0057\\src\\j1\\s\\p0057\\user.dat");

    private void creatFile() {
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("Error create file!");
        }
    }

    private void addUserTofile(User user) {
        if (!file.exists()) {
            creatFile();
        }
        try {
            FileWriter fileWritter = new FileWriter(file, true);
            // làm bộ đệm giúp viết các ký tự nhanh hơn
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(user.toString());
            bufferWritter.newLine();
            bufferWritter.close();
            fileWritter.close();
        } catch (IOException ex) {
            System.out.println("Error write file!");
        }
    }

    private boolean readUsernameFromFile(String username) {
        if (!file.exists()) {
            creatFile();
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.split("\\|")[0].equalsIgnoreCase(username)) {
                    return true;
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private User readUserFromFile(String username, String password) {
        if (!file.exists()) {
            creatFile();
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                String data[] = line.split("\\|");
                String _username = data[0];
                String _password = data[1];
                HashPass hashPass = new HashPass();
                password = hashPass.getMD5(password);
                if (_username.equalsIgnoreCase(username) && _password.equals(password)) {
                    User user = new User(username, password);
                    return user;
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private boolean checkUsernameCreate(String username) throws Exception {
        if (!username.matches("\\S{5,}")) {
            throw new Exception("Username at least 5 characters and, no space");
        } else if (readUsernameFromFile(username)) {
            throw new Exception("Username is exit!");
        }
        return true;
    }

    private boolean checkUsernameLogin(String username) throws Exception {
        if (!username.matches("\\S{5,}")) {
            throw new Exception("Username at least 5 characters and, no space");
        } else if (!readUsernameFromFile(username)) {
            throw new Exception("Username dosn't exit!");
        }
        return true;
    }

    private boolean checkPassword(String password) throws Exception {
        if (!password.matches("\\S{6,}")) {
            throw new Exception("Password at least 6 characters and, no space");
        }
        return true;
    }

    private String[] inputData(boolean isCreate) {
        String username = null;
        while (true) {
            try {
                System.out.print("Enter username: ");
                username = bf.readLine();
                if (isCreate) {
                    checkUsernameCreate(username);
                } else {
                    checkUsernameLogin(username);
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String password = null;
        while (true) {
            try {
                System.out.print("Enter password: ");
                password = bf.readLine();
                checkPassword(password);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new String[]{username, password};
    }

    public void create() {
        String data[] = inputData(true);
        User user = new User(data[0], data[1]);
        addUserTofile(user);
        System.out.println("Create successful!");
    }

    public void login() {
        String data[] = inputData(false);
        User user = readUserFromFile(data[0], data[1]);
        if (user != null) {
            System.out.println("Login success!");
        }else{
            System.out.println("Login fail! Password wrong!");
        }
    }
}
