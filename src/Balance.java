import java.util.*;

public class Balance extends Bank {
    private
        double balance;
    private
         int accountNo;
    private
         Date date;
    protected void Balance(){
         balance=0;
         accountNo=0000;
         date =new Date(2023,10,7,05,30,00);

     }
    protected void Balance(double b,int a,Date d ) {
        balance=b;
        accountNo=a;
        date=d;
    }
    protected void set_balance(double balance){
        this.balance=balance;
    }
    protected void set_accountNo(int accountNo){
        this.accountNo=accountNo;
    }
    protected  void set_date(Date date){
        this.date=new Date();
    }

    protected double getBalance() {
        return balance;
    }

    protected Date getDate() {
        return date;
    }


    protected int getAccountNo() {
        return accountNo;
    }

    @Override
    protected String tostring() {
       return "accountNo =  \t " + accountNo+"  \tbalance =\t   " + balance+"   \tdate = \t   " + date+" overlimit =   "+balance*(.15)+"\n";
   }
    protected enum transaction{ Withdraw
   ,Deposite
    ,ShowInfo
     }




}
