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
public class FilteredAccount extends Account {
    private double zero;
    private double transactionsCount;
    public FilteredAccount(Client c) {
        super(c);
        zero = 0;
        transactionsCount = 0;
    }
    
    public boolean process(Transaction transaction){ //xử lý giao dịch 
        //nếu giao dịch có giá tiền bằng 0 thì tăng biến zero lên 1 
        //tức giao dịch đó có giá bằng 0 và không xử lý giao dịch đó
        if(transaction.value()==0){ 
            zero++; 
            return false;
        } else if(transaction.value()>0 && transaction.isTransacionStatus()){
            //Ngược lại nếu giao dịch có giá trị lớn hơn 0 
            //và có trạng thái giao dịch bằng true thì tăng biến transactionsCount lên
            transactionsCount++;
            super.process(transaction); //sau đó sẽ xử lý giao dịch
            return true;
        } else return false; //ngược lại trạng thái giao dịch bằng false hoạc value <0 thì không xử lý giao dịch
    }
    
    public double percentFiltered(){ //lấy số phần trăm giao dịch có value lớn hơn 0
        if(transactionsCount == 0){
            return 0.0;
        } else return (transactionsCount/(zero+transactionsCount)*100);
    }

    public double getZero() {
        return zero;
    }

    public void setZero(double zero) {
        this.zero = zero;
    }

    public double getTransactionsCount() {
        return transactionsCount;
    }

    public void setTransactionsCount(double transactionsCount) {
        this.transactionsCount = transactionsCount;
    }
    

}
