/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h205;

/**
 *
 * @author giaki
 */
public class Startup { 
    private int balance; //số dư của startup

    public Startup(int balance) { //Khởi tạo startup
        this.balance = balance;
    }

    public int getBalance() { //Lấy số dư trong tài khoản của startup
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    
}
