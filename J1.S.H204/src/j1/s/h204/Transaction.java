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
public class Transaction {
    private boolean transacionStatus;
    private int pennies;

    public Transaction(boolean transacionStatus, int pennies) {
        this.transacionStatus = transacionStatus;
        this.pennies = pennies;
        if(transacionStatus ){
            value();
        }
    }
    public int value (){
        return pennies*100;
    }

    public boolean isTransacionStatus() {
        return transacionStatus;
    }

    public void setTransacionStatus(boolean transacionStatus) {
        this.transacionStatus = transacionStatus;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    } 
}
