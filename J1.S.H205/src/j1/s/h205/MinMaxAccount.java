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
public class MinMaxAccount extends BankingAccount {

    private int maxBalance;
    private int minBalance;

    public MinMaxAccount(Startup startup) { //khởi tạo minmaxAccount
        super(startup); //Khởi tạo startup 
        minBalance = getBalance(); //gán min bằng số dư từ tài khoản của startup
        maxBalance = getBalance(); //gắn max bằng số dư từ tài khoản của startup
    }

    public void debit(Debit debit) {
        super.debit(debit); //Thực hiện trả trước 
        updateMinMax(); //cập nhật lại giá trị minmax
    }

    public void credit(Credit c) {
        super.credit(c); //Thực hiện ghi nợ trả sau
        updateMinMax(); //cập nhật lại giá trị minmax
    }

    public void updateMinMax() { //cập  nhật min max
        if (getBalance() > maxBalance) {
            maxBalance = getBalance();
        }
        if (getBalance() < minBalance) {
            minBalance = getBalance();
        }
    }

    public int getMin() { //Lấy giá trị nhỏ nhất của số dư tài khoản
        return minBalance;
    }

    public int getMax() { //Lấy giá trị lớn nhất của số dư tài khoản
        return maxBalance;
    }
}
