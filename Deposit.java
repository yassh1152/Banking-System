package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    JTextField t1;
    JButton b1,b2;

    Deposit(String pin){
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel l1=new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT:");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(460,180,400,35);
        l1.setForeground(new Color(0xFDFCFC));
        l3.add(l1);

        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,18));
        t1.setBackground(new Color(65,125,128));
        t1.setForeground(Color.WHITE);
        t1.setBounds(460,230,320,25);
        l3.add(t1);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);








        setSize(13550,1080);
        setLayout(null);
        setVisible(true);
        setLocation(0,0);

    }


    public void actionPerformed(ActionEvent e) {
        try {
            String amount = t1.getText();
            Date date = new Date();
            if (e.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Deposit");
                }else {
                    Con c = new Con();
                    c.st.executeUpdate("insert into bank values('"+pin+"', '"+date+"','Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pin);

                }
            }else if (e.getSource()==b2){
                setVisible(false);

            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("");
    }
}

