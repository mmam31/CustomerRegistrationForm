package eu.modris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegForm {
    private JPanel JPanel;
    JPanel reg_form;
    private JLabel title;
    private JTextField name;
    private JTextField lastName;
    private JTextField phoneNumber;
    private JTextField email;
    private JTextField adrese;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JLabel success;
    private JLabel error;

    String DB = "jdbc:mysql://localhost:3306/customers";
    String USER = "root";
    String PASS = "Karameles1!";

    public RegForm() {
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try (
                        Connection connection = DriverManager.getConnection(DB, USER, PASS);
                ) {
                    String name_text = name.getText();
                    String lastName_text = lastName.getText();
                    String phoneNumber_text = phoneNumber.getText();
                    String email_text = email.getText();
                    String adrese_text = adrese.getText();


                    PreparedStatement statement = connection.prepareStatement("INSERT INTO customer_data (name, lastName, phoneNumber, email, adress) VALUES ('" + name_text + "', '" + lastName_text + "', '" + phoneNumber_text + "', '" + email_text + "', '" + adrese_text + "')");

                    statement.executeUpdate();
                    connection.close();
                    success.setText("Dati ir ievadīti!");
                }catch (SQLException a){
                    error.setText("Dati nav ievadīti! " + a.getMessage());
                }


                        {

                }
            }
        });
    }
}

