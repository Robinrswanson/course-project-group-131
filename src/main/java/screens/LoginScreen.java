package screens;

import interface_adaptors.login.LoginController;
import interface_adaptors.login.LoginIView;
import use_cases.login.Login;
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


public class LoginScreen extends JPanel implements ActionListener, LoginIView {


    private static JPanel panel;
    private static JLabel userlabel;
    private static JLabel pwlabel;
    private static JLabel notification_label;
    private static JTextField usertextField;
    private static JPasswordField passwordField;
    private static JButton button;
    private static JLabel picLabel;
    private static LoginController controller;

    public LoginScreen(JPanel screens, LoginController controller) throws IOException {

        this.panel = screens;
        this.controller = controller;

        this.setLayout(null);

        setPicture();

        setPasswordLabel();
        setUserNameLabel();

        setUsernameField();
        setPasswordField();

        setButton();

        setNotification();

    }

    private void setNotification() {
        notification_label = new JLabel("");
        notification_label.setBounds(150,185,165,25);
        this.add(notification_label);
    }

    private void setButton() {
        button = new JButton("Login");
        button.setBounds(160, 210, 80, 25);
        button.addActionListener(this);
        this.add(button);
    }

    private void setPasswordField() {
        passwordField = new JPasswordField();
        passwordField.setBounds(140, 160, 165, 25);
        this.add(passwordField);
    }

    private void setUsernameField() {
        usertextField = new JTextField(20);
        usertextField.setBounds(140, 120, 165, 25);
        this.add(usertextField);
    }

    private void setUserNameLabel() {
        userlabel = new JLabel("Username");
        userlabel.setBounds(60, 120, 80, 25);
        this.add(userlabel);
    }

    private void setPasswordLabel() {
        pwlabel = new JLabel("Password");
        pwlabel.setBounds(60, 160, 80, 25);
        this.add(pwlabel);
    }

    private void setPicture() throws IOException {
        BufferedImage myPicture = ImageIO.read(new File("src/main/java/database/Inventory Icon.png"));
        picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(160,10,100,96);
        this.add(picLabel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //What happens when you click the button. The method pares the input test in the two text fields, and
        // calls the usecase "LoginCheckUserExists" and its method "CheckExists" to
        // determine 1.
        //If the username exists, 2. if the password matches 3. If the user is a manager or employee. and returns
        //this result as a boolean list. If password matches and username exists, a new Employee screen is created.
        controller.checkUserExists(usertextField.getText(), passwordField.getPassword());

            //Stores Is_Manager and username in static variables of LoginOutPutDS class

//            LoginOutPutDS ds2 = new LoginOutPutDS();
//            System.out.println(ds2.Get_Is_Manager());
//            System.out.println(ds2.Get_username());
    }

    public void displayPasswordFail() {
        notification_label.setForeground(Color.RED);
        notification_label.setText("Password does not match");
    }

    public void displayUsernameFail() {
        notification_label.setForeground(Color.RED);
        notification_label.setText("Username not found");
    }

    public void changeToMainScreen() {
        CardLayout cardLayout = (CardLayout) panel.getLayout();
        cardLayout.show(panel, "Main");
    }


}

