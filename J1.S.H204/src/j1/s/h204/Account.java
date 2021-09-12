/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h204;

/**
 *
 * @author giaki
 */
public class Account {

    private String accountType;

    public Account(Client c) {
        this.accountType = c.clientType;
    }

    public boolean process(Transaction t){
        return t.isTransacionStatus();
    }
    
    public String getclient(){
        return accountType;
    }
 
}
