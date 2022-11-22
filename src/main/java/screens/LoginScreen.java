package screens;

import use_cases.LoginCheckUserExists;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class LoginScreen implements ActionListener {


    private static JPanel panel;
    private static JLabel userlabel;
    private static JLabel pwlabel;
    private static JTextField usertextField;
    private static JPasswordField passwordField;
    private static JButton button;


    public LoginScreen()  {
        JFrame frame = new JFrame();
        panel = new JPanel();
        frame.setTitle("Inventory Management Software XXX");
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        pwlabel = new JLabel("Password");
        userlabel = new JLabel("Username");
        pwlabel.setBounds(10,60,80,25);
        userlabel.setBounds(10,20,80,25);
        usertextField = new JTextField(20);
        usertextField.setBounds(100,20,165,25);
        passwordField = new JPasswordField();
        passwordField.setBounds(100,60,165,25);
        button = new JButton("Login");
        button.setBounds(100,100,80,25);
        button.addActionListener(new LoginScreen());
        panel.add(pwlabel);
        panel.add(userlabel);
        panel.add(usertextField);
        panel.add(passwordField);
        panel.add(button);
        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usertextField.getText();
        char[] password = passwordField.getPassword();
        StringBuilder pwBuilder = new StringBuilder();
        for(char i: password)
        {
            pwBuilder.append(i);
        }

        String pwFinal = pwBuilder.toString();
        LoginCheckUserExists check = new LoginCheckUserExists(username, pwFinal);
        List<Boolean> Bool_List = check.CheckExists(check.username, check.password);
        if(Bool_List.size()==1)
        {
            System.out.print("Username not found");
        } else if (Bool_List.size()==2) {
            System.out.print("Password does not match");

        } else if (Bool_List.size()==3 && Bool_List.get(2)){
            System.out.println("Login Successful: Status: Manager");

        } else if (Bool_List.size()==3 && !Bool_List.get(2)){
            System.out.println("Login Successful: Status: Employee");

        }





    }
}
