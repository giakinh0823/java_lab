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

    public Account(Client client) { //Tạo tài khoản với thông tin từ khách hàng(client)
        this.accountType = client.clientType;
    }

    public boolean process(Transaction transaction){ //xử lý giao dịch
        return transaction.isTransacionStatus(); //Trả về trạng thái giao dịch
    }
    
    public String getclient(){ //trả về kiểu khác hàng
        return accountType;
    }

    public String getAccountType() { //trả về kiểu khác hàng
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
 
}
