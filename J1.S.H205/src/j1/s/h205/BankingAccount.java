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
public class BankingAccount {
    private int balance;

    public BankingAccount(Startup startup) {
        //Lấy số tiền còn dư trong tài khoản của startup
        this.balance = startup.getBalance(); 
    }
    
    public void debit(Debit debit){ 
        // Dịch vụ trả trước nếu số dư - số tiền cần trả trước thì thực hiện giao dịch
        if(balance - debit.getDebit()>=0){
            balance = balance - debit.getDebit();
        }
    }
    
    public void credit(Credit credit){
        //Dịch vụ trả sau => Ghi nợ và cộng số tiền trả sau vào tài khoản
        balance = balance + credit.getCredit();
    }
    public int getBalance(){
        //Lấy số dư của tài khoản
        return balance;
    }
}
