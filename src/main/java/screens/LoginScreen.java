package screens;

import use_cases.login.LoginCheckUserExists;
import use_cases.login.LoginOutPutDS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class LoginScreen extends JPanel implements ActionListener {


    private static JPanel panel;
    private static JLabel userlabel;
    private static JLabel pwlabel;
    private static JLabel notification_label;
    private static JTextField usertextField;
    private static JPasswordField passwordField;
    private static JButton button;
    private static JLabel picLabel;



    public LoginScreen(JPanel screens) throws IOException {


        panel = screens;
        this.setLayout(null);
        pwlabel = new JLabel("Password");
        userlabel = new JLabel("Username");
        notification_label = new JLabel("");
        notification_label.setBounds(150,185,165,25);

        JPanel panel2 = new JPanel();

        pwlabel.setBounds(60, 160, 80, 25);
        userlabel.setBounds(60, 120, 80, 25);
        usertextField = new JTextField(20);
        usertextField.setBounds(140, 120, 165, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(140, 160, 165, 25);
        button = new JButton("Login");
        button.setBounds(160, 210, 80, 25);
        button.addActionListener(this);

        BufferedImage myPicture = ImageIO.read(new File("src/main/java/database/Inventory Icon.png"));
        picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(160,10,100,96);

        this.add(picLabel);
        this.add(pwlabel);
        this.add(userlabel);
        this.add(usertextField);
        this.add(passwordField);
        this.add(button);
        this.add(notification_label);



    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //What happens when you click the button. The method pares the input test in the two text fields, and
        // calls the usecase "LoginCheckUserExists" and its method "CheckExists" to
        // determine 1.
        //If the username exists, 2. if the password matches 3. If the user is a manager or employee. and returns
        //this result as a boolean list. If password matches and username exists, a new Employee screen is created.
        String username = usertextField.getText();
        char[] password = passwordField.getPassword();
        StringBuilder pwBuilder = new StringBuilder();
        for (char i : password) {
            pwBuilder.append(i);
        }

        String pwFinal = pwBuilder.toString();
        LoginCheckUserExists check = new LoginCheckUserExists(username, pwFinal);
        List<Boolean> Bool_List = check.CheckExists(check.username, check.password);


        if (Bool_List.size() == 1) {
            notification_label.setForeground(Color.RED);
            notification_label.setText("Username not found");
        } else if (Bool_List.size() == 2) {
            notification_label.setForeground(Color.RED);
            notification_label.setText("Password does not match");

        } else if (Bool_List.size() == 3) {

            //Stores Is_Manager and username in static variables of LoginOutPutDS class

            LoginOutPutDS ds = new LoginOutPutDS();
            ds.Set_Is_Manager(Bool_List.get(2));
            ds.Set_username(username);

//            LoginOutPutDS ds2 = new LoginOutPutDS();
//            System.out.println(ds2.Get_Is_Manager());
//            System.out.println(ds2.Get_username());
            CardLayout cardLayout = (CardLayout) panel.getLayout();
            cardLayout.show(panel, "Main");






        }

    }
}

