/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0057;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author giaki
 */
public class User {

    private String username;
    private String password;
    private HashPass hashPass = new HashPass();
    
    public User(String username, String password) {
        this.username = username;
        this.password = hashPass.getMD5(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPass.getMD5(password);
    }

    @Override
    public String toString() {
        return username + "|" + password;
    }

}
