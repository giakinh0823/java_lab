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
        Transaction firstTransaction = new Transaction(true, 100);
        Transaction secondTransaction = new Transaction(true, 0);
        Transaction thirdTransaction = new Transaction(false,300);
        Transaction fourTransaction = new Transaction(true, 300);
        
        filteredAccount.process(firstTransaction);
        filteredAccount.process(secondTransaction);
        filteredAccount.process(thirdTransaction);
        filteredAccount.process(fourTransaction);
        
        System.out.println("Account Type: " + filteredAccount.getclient());
        System.out.println("First Transaction: "+filteredAccount.process(firstTransaction));
        System.out.println("Second Transaction: "+filteredAccount.process(secondTransaction));
        System.out.println("Third Transaction: "+filteredAccount.process(thirdTransaction));
        System.out.println("FourdTransaction: "+filteredAccount.process(fourTransaction));
        
        System.out.printf("Percent Filtered: %.2f%s"
               ,filteredAccount.percentFiltered(), "%");
    }
}
