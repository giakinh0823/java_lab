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
public class J1SH204 {

    public static void main(String[] args) {
        Client client = new Client("Personnel Account ");
        FilteredAccount filteredAccount = new FilteredAccount(client);
        Transaction firstTransaction = new Transaction(true, 300);  //Khởi tạo giao dịch 1
        Transaction secondTransaction = new Transaction(true, 500); //Khởi tạo giao dịch 2
        Transaction thirdTransaction = new Transaction(true, 0); //Khởi tạo giao dịch 3
        Transaction fourTransaction = new Transaction(true, 600); //Khởi tạo giao dịch 4
        Transaction fiveTransaction = new Transaction(false, 400); //Khởi tạo giao dịch 5

        filteredAccount.process(firstTransaction); //xử lý giao dịch 1
        filteredAccount.process(secondTransaction); //xử lý giao dịch 2
        filteredAccount.process(thirdTransaction); //xử lý giao dịch 3
        filteredAccount.process(fourTransaction); //xử lý giao dịch 4
        filteredAccount.process(fiveTransaction); //xử lý giao dịch 5

        System.out.println("Account Type: " + filteredAccount.getclient());
        System.out.println("First Transaction: " + filteredAccount.process(firstTransaction)); //xử lý giao dịch và in ra trạng thái giao dịch 1
        System.out.println("Second Transaction: " + filteredAccount.process(secondTransaction)); //xử lý giao dịch và in ra trạng thái giao dịch 2
        System.out.println("Third Transaction: " + filteredAccount.process(thirdTransaction)); //xử lý giao dịch và in ra trạng thái giao dịch 3
        System.out.println("Fourd Transaction: " + filteredAccount.process(fourTransaction)); //xử lý giao dịch và in ra trạng thái giao dịch 4
        System.out.println("Fourd Transaction: " + filteredAccount.process(fiveTransaction)); //xử lý giao dịch và in ra trạng thái giao dịch 5

        System.out.printf("Percent Filtered: %.2f%s", filteredAccount.percentFiltered(), "%");
    }
}
