package eu.modris;

import javax.swing.*;

public class RegFormRunner {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setContentPane(new RegForm().reg_form);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }
}
