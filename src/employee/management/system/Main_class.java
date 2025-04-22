package employee.management.system;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class(){
        JLabel heading  = new JLabel("Employee Management Syatem");
        heading.setBounds(340,150,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(350,270,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AddEmployee();
                    setVisible(false);
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(550,270,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new View_Employee();
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        add(view);

        JButton remove = new JButton("Remove Employee");
        remove.setBounds(450,350,150,40);
        remove.setForeground(Color.WHITE);
        remove.setBackground(Color.BLACK);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new RemoveEmployee();
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        add(remove);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);



        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Main_class();
    }
}
