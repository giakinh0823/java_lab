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
    private boolean transacionStatus; //Trạng thái giao dịch
    private int pennies; //đồng tiền

    public Transaction(boolean transacionStatus, int pennies) { //Khởi tạo tiền và trạng thái giao dịch
        this.transacionStatus = transacionStatus;
        this.pennies = pennies;
    }
    
    public int value (){  // lấy giá trị đồng tiền
        return pennies;
    }

    public boolean isTransacionStatus() { //trạng thái giao dịch 
        return transacionStatus;
    }

    public void setTransacionStatus(boolean transacionStatus) { //set trạng thái giao dịch
        this.transacionStatus = transacionStatus;
    }

    public int getPennies() { //lấy số tiền
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    } 
}
