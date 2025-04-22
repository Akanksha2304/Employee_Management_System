package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.jar.JarEntry;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEMPID;
    JButton delete,back;
    RemoveEmployee(){

        JLabel lable = new JLabel("Employee ID");
        lable.setBounds(50,50,100,30);
        lable.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lable);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,100,30);
        add(choiceEMPID);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEMPID.add(resultSet.getString("empID"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        labelname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelname);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,100,30);
        add(textName);

        JLabel lablephone = new JLabel("Phone");
        lablephone.setBounds(50,150,100,30);
        lablephone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lablephone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200,150,100,30);
        add(textPhone);

        JLabel lableEmail = new JLabel("Email");
        lableEmail.setBounds(50,200,100,30);
        lableEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lableEmail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200,200,100,30);
        add(textEmail);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empID = '"+choiceEMPID.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where empID = '"+choiceEMPID.getSelectedItem()+"'");
                    while (resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }

        });

        delete = new JButton("Delete");
        delete.setBounds(50,260,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(200,260,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,50,200,200);
        add(img);



        setSize(600,400);
        setLayout(null);
        setLocation(300,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete){
            try {
                conn c = new conn();
                String query = "delete from employee where empID = '"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee deleted Successfully");

                new Main_class();
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
