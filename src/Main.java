import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//Abdalrheem salah
//12116165

class GUI extends JFrame implements ActionListener {
    Transaction b=new Transaction();

        JButton button;
        JButton button2;
        JButton button3;
        JButton button4;
        JButton button5;
        JButton button6;

    JLabel label1;

        Choice choice;

        JLabel label;

public GUI() {

        button = new JButton("addAccount");
        button2 = new JButton("searchAccount");
        button3 = new JButton("removeAccount");
        button4 = new JButton("transactOperation");
        button5 = new JButton("view Information");
        button6 = new JButton("Exit");
label1=new JLabel();
    choice = new Choice();

       choice.add("");
       choice.add("Deposit");
       choice.add("Withdraw");
       choice.add("ShowInfo");

        choice.setVisible(false);

        button.setBounds(100, 50, 140, 40);
        button2.setBounds(100, 100, 140, 40);
        button3.setBounds(100, 150, 140, 40);
        button4.setBounds(100, 200, 140, 40);
        button5.setBounds(100, 250, 140, 40);
        button6.setBounds(100, 300, 140, 40);
        label1.setBounds(200,400,300,50);

    choice.setBounds(250,210, 100,40);


        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
    label1.setText("student: Abdalrheem Salah" +" \n  id :12116165");





    add(button);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
         add(choice);
         add(label1);

    Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        setIconImage(icon);
    Container c = getContentPane();
    JLabel label = new JLabel();
    label.setIcon(new ImageIcon("image.jpg"));
    Dimension size = label.getPreferredSize();
    label.setBounds(0,0, 670, 502);

    c.add(label);

//getContentPane().setBackground(Color.BLACK);
        setTitle("Bank");
        setSize(670,502 );
        setLayout(null);
        setVisible(true);
        }



    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==button){
            String balance = JOptionPane.showInputDialog("input balance");
            double balance_d = Double.parseDouble(balance);
            String number_ac = JOptionPane.showInputDialog("input_new_accountNo");
            int   accountNo  = Integer.parseInt(number_ac);
            b.addAccount(balance_d,accountNo);
        }
        if(source==button2) {
            String ac_no = JOptionPane.showInputDialog("input Account number to Search:");
            int acaont_num = Integer.parseInt(ac_no);
            JOptionPane.showMessageDialog(null, b.searchAccount(acaont_num).tostring(), "Information", JOptionPane.INFORMATION_MESSAGE);
        }

        if(source==button3){
            b.removeAccount();
            b.tostring();


        }
        if(source==button4){
            choice.setVisible(true);
String a=choice.getSelectedItem();
            if(a.equals("Deposit"))
            { b.transactOperation(true,"a");}
            else if(a.equals("Withdraw"))
            {b.transactOperation(true,"b");}
            else if (a.equals("ShowInfo"))
            {b.transactOperation(true,"c");}
         }
        if (source == button5) {
            b.transactOperation(false,"c");
        }
    if(source==button6){
       setVisible(false);
        dispose();


    }}

    void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
           if(source.equals("Deposit"))
           { b.transactOperation(true,"a");}
          else if(source.equals("Withdraw"))
            {b.transactOperation(true,"b");}
         else if (source.equals("ShowInfo"))
         {b.transactOperation(true,"c");}

        }
    }

public class Main {
    public static void main(String[] args) {
Date date= new Date();
        Transaction b=new Transaction();
        System.out.println("Default format: " + date);
        new GUI();




        Scanner input=new Scanner(System.in);
        boolean y=true;
        while (y){

            System.out.println("input the number\n 1_addAccount\n2_searchAccount\n3_removeAccount\n4_transactOperation\n5_view Account Information\n6_Exit");

           String x= input.next();
            switch (x) {

                case "1": {
                    String number_ac = JOptionPane.showInputDialog("input_new_accountNo");
                    int   accountNo  = Integer.parseInt(number_ac);
                    String balance = JOptionPane.showInputDialog("input balance");
                    double balance_d = Double.parseDouble(balance);
                    b.addAccount(balance_d,accountNo);
                    break;
                }
                case "2": {
                    String ac_no = JOptionPane.showInputDialog("input Account number to Search:");
                    int acaont_num = Integer.parseInt(ac_no);
                    JOptionPane.showMessageDialog(null, b.searchAccount(acaont_num).tostring(), "Information", JOptionPane.INFORMATION_MESSAGE);

                    System.out.println(b.searchAccount(acaont_num).tostring());

                    break;
                }
                case "3": {
                    b.removeAccount();
                    b.tostring();
                    break;
                }
                case "4": {
                    System.out.println(" input the char :\na.Deposit\nb.Withdraw\n c.ShowInfo" );
                    String str_choose=input.nextLine();

                    b.transactOperation(true,str_choose);
                    break;
                }
                case "5": {
                    b.transactOperation(false,"c");
                    break;
                }

                case "6": {
                    y = false;
                    break;
                }
                default: {
                    System.out.println("please input the correct number");
                    x = input.nextLine();
                }
            }

        }

    }
}
