import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginGui implements ActionListener{

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel userlabel;
    private static JTextField userText;
    private static JLabel pwlabel;
    private static JPasswordField passwordText;
    private static JLabel success_label;

    private static JButton login_button;



    public LoginGui ()
    {
        frame = new JFrame();
        panel = new JPanel();
        frame.setTitle("Inventory Management Software XXX");
        frame.setSize(500,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        userlabel = new JLabel("Username");
        userlabel.setBounds(10,20,80,25);
        panel.add(userlabel);
        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);
        pwlabel = new JLabel("Password");
        pwlabel.setBounds(10,50,80,25);
        panel.add(pwlabel);
        passwordText = new JPasswordField((20));
        passwordText.setBounds(100,50,165,25);
        passwordText.setEchoChar('*');
        panel.add(passwordText);

        login_button = new JButton("Login");
        login_button.setBounds(10,80,80,25);
        login_button.addActionListener(this);
        panel.add(login_button);

        success_label = new JLabel("");
        success_label.setBounds(10,110,300,25);
        panel.add(success_label);


        frame.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button clicked");
        String username = userText.getText();
        char[] passwordchars = passwordText.getPassword();
        StringBuilder sb = new StringBuilder();
        for(Character c: passwordchars)
        {
            sb.append(c);
        }
        String password = sb.toString();

        userText.setText("");
        passwordText.setText("");
        LoginChecker checker = new LoginChecker(username, password);
        Boolean exists = checker.Check_UserExists(username);
        System.out.println("Username exists:" + exists);
        if(exists)
        {
            Boolean matches = checker.Check_PwMatches(username,password);
            System.out.println("password matches:" + matches);
        }





    }
}
