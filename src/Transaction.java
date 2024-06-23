import java.util.*;
import javax.swing.*;


public class Transaction extends Bank {
    private enum transaction {
     Deposit,
        ShowInfo,
        Withdraw

    }

    private
        double amount ;
    private
       int accountNo ;
    private
        Date date ;
    private
        Bank bank ;
    private
        Balance balance ;
    private
        double overlimit ;

    public Transaction(){
        amount=0;
        accountNo=0000;
        overlimit = 0000;


    }
    public Transaction(int accountNo){

        overlimit = balance.getBalance()*(15/100);
        balance= searchAccount(accountNo);

    }
    @Override
   public String tostring() {
        String List_string="";
            List_string += super.searchAccount(accountNo).tostring();
return List_string;

    }

    public void transactOperation(boolean logic,String x){

        System.out.println("input account_NO");
        String number_ac = JOptionPane.showInputDialog("input account_NO");
           accountNo  = Integer.parseInt(number_ac);
      balance =  searchAccount( accountNo);
        overlimit=balance.getBalance()*(15/100);

         transaction transaction_Ob = null;
        date=new Date();

        if(logic) {
             switch (x){
             case "a":
                 transaction_Ob = transaction.valueOf("Deposit");
                 break;
                 case "b":
                 transaction_Ob = transaction.valueOf("Withdraw");
                 break;

                 case "c":
                 transaction_Ob = transaction.valueOf("ShowInfo");
                                                 break;}
         switch(transaction_Ob) {
             case transaction.Deposit:
                 String Deposite = JOptionPane.showInputDialog(date+"\nDeposite");
                 amount = Integer.parseInt(Deposite);
                 if (amount > 0) {
                     double set_balance = balance.getBalance() + amount;
                     searchAccount(accountNo).set_date(date);
                     searchAccount(accountNo).set_balance(set_balance);
                 } else
                     JOptionPane.showMessageDialog(null, "Invalid deposit amount", "Error_101", JOptionPane.ERROR_MESSAGE);

                 break;
             case transaction.Withdraw:

                 String Withdraw = JOptionPane.showInputDialog(date+"\nWithdraw");
                 amount = Integer.parseInt(Withdraw);
                 if (amount > 0 && amount <= overlimit) {
                     double set_balanc = balance.getBalance() - amount;
                     searchAccount(accountNo).set_date(date);
                     searchAccount(accountNo).set_balance(set_balanc);

                 } else if (amount > balance.getBalance())
                     JOptionPane.showMessageDialog(null, "Invalid Withdraw amount > balance", "Error_102", JOptionPane.ERROR_MESSAGE);
                 else if (amount > overlimit)
                     JOptionPane.showMessageDialog(null, " Invalid Withdraw amount > overLimit", "Error_102", JOptionPane.ERROR_MESSAGE);
                 break;
             case transaction.ShowInfo:

                 JOptionPane.showMessageDialog(null, searchAccount(accountNo).tostring(), "Information", JOptionPane.INFORMATION_MESSAGE);

         } }
          else {

            JOptionPane.showMessageDialog(null, searchAccount(accountNo).tostring(), "Information", JOptionPane.INFORMATION_MESSAGE);
        }
         }

}







