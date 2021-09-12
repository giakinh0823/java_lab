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
public class J1SH205 {

    public static void main(String[] args) {
        Startup startup = new Startup(1000);
        Credit credit1 = new Credit(3000);
        Debit debit1 = new Debit(1500);
        Credit credit2 = new Credit(4000);
        Debit debit2 = new Debit(3000);
        Credit credit3 = new Credit(2500);
        Debit debit3 = new Debit(1000);

        MinMaxAccount minMaxAccount = new MinMaxAccount(startup);
        
        minMaxAccount.credit(credit1);
        minMaxAccount.debit(debit1);
        minMaxAccount.credit(credit2);
        minMaxAccount.debit(debit2);
        minMaxAccount.credit(credit3);
        minMaxAccount.debit(debit3);

        System.out.println("Minimum: $" + minMaxAccount.getMin());
        System.out.println("Maximum: $" + minMaxAccount.getMax());
        System.out.println("Currend Balance: $" + minMaxAccount.getBalance());
    }
}
