package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField  tfname, taddress, tphone, temail, tsalary, tdesignation, teducation,taadhar;
    JLabel tempid;
    JButton update,back;
    String number;

    UpdateEmployee(String number){
        this.number = number;
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,100,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel(""+number);
        tempid.setBounds(200,100,150,30);
        tempid.setBackground(Color.WHITE);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200,150,150,30);
        tname.setBackground(Color.WHITE);
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(Color.WHITE);
        add(tfname);

        JLabel address = new JLabel("Address");
        address.setBounds(50,200,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,200,150,30);
        taddress.setBackground(Color.WHITE);
        add(taddress);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(600,200,150,30);
        tdob.setFont(new Font("Tahoma", Font.BOLD,20));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(50,250,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(200,250,150,30);
        tsalary.setBackground(Color.WHITE);
        add(tsalary);

        JLabel phone = new JLabel("Phone No.");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(Color.WHITE);
        add(tphone);

        JLabel aadhar = new JLabel("Aadhar No.");
        aadhar.setBounds(50,300,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(200,300,150,30);
        taadhar.setBackground(Color.WHITE);
        add(taadhar);

        JLabel email = new JLabel("Email");
        email.setBounds(400,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(600,300,150,30);
        temail.setBackground(Color.WHITE);
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(50,350,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(200,250,150,30);
        teducation.setBackground(Color.WHITE);
        add(teducation);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(400,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(600,350,150,30);
        tdesignation.setBackground(Color.WHITE);
        add(tdesignation);

        try {
            conn c = new conn();
            String query = "select * from employee where empID = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tempid.setText(resultSet.getString("empID"));
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                taadhar.setText(resultSet.getString("addhar"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                tdesignation.setText(resultSet.getString("designation"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBounds(250,500,150,40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(450,500,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update){
            String fname = tfname.getText();
            String address = taddress.getText();
            String salary = tsalary.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try {
                conn c = new conn();
                String query = "update employee set fname = '"+fname+"',address = '"+address+"',salary = '"+salary+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"',designation ='"+designation+"' where empID = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                new Main_class();


            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new View_Employee();
        }
    }

    public static void main(String[] args) {

        new UpdateEmployee("");
    }
}
