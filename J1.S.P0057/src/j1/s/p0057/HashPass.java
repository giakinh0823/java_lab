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
public class HashPass {

   private static String covertByToHex(byte[] data) {
        BigInteger number = new BigInteger(1, data);
        String hashText = number.toString(16); // chuỗi thành cơ số 16
        while (hashText.length() < 32) { 
            hashText = "0" + hashText; //32 bit
        }
        return hashText;
    }

    protected static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            return covertByToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
