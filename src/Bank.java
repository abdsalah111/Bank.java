import javax.swing.*;
import java.util.*;

public class Bank {
    private ArrayList<Balance> BalanceList;

   protected Bank() {
        BalanceList = new ArrayList<Balance>();

    }

    protected Bank(ArrayList<Balance> BalanceList) {
        this.BalanceList = new ArrayList<Balance>();
        this.BalanceList = BalanceList;
    }

    protected void addAccount(double balance,int accountNo) {

        boolean logic=false;
        if(searchAccount(accountNo).equals(accountNo))logic=true;
if(!logic){
            Balance b = new Balance();
            b.set_balance(balance);
            int sizeList = BalanceList.size() + 1;

            int random_number = (int) (Math.random() * 9);
             b.set_date(new Date());
             accountNo = random_number * sizeList * 10 + random_number * sizeList * 100 + random_number * sizeList * 1000;
            b.set_accountNo(accountNo);
            JOptionPane.showMessageDialog(null, "\nyour account number is :"+accountNo+"\nDATE:  "+b.getDate()+"\n(dont forget it)");
            System.out.println(accountNo);
            BalanceList.add(b);}
else if(logic)
{

    JOptionPane.showMessageDialog(null,"The accountNo exist\nTry to register with the account","Error_777",JOptionPane.ERROR_MESSAGE);

    }
   }

    protected Balance searchAccount(int accountNo) {


        for (Balance O : BalanceList) {
            if (BalanceList.get(BalanceList.indexOf(O)).getAccountNo() == accountNo)
                return BalanceList.get(BalanceList.indexOf(O));
        }
        JOptionPane.showMessageDialog(null,"The accountNo does not exist","Error_450",JOptionPane.ERROR_MESSAGE);
        return null;


    }

    protected  void removeAccount() {

        for (Balance O : BalanceList) {
            BalanceList.remove(O);

        }
    }

    protected String tostring() {
        String List_string="";
        for (int i=0;i<BalanceList.size();i++)
            List_string += BalanceList.get(i).tostring();

        return List_string;
    }

    protected  int getBalanceListSize() {
        return BalanceList.size();

    }
}










