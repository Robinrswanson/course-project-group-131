package screens;

import interface_adaptors.show_history.ShowHistoryController;
import interface_adaptors.show_history.ShowHistoryView;
import use_cases.show_history_use_case.ShowHistoryResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ShowHistoryScreen extends JPanel implements ShowHistoryView {
    /**
     * the start date which the employee wants to look at
     */
    JTextField startdate = new JTextField(15);

    /**
     * the end date which the employee wants to look at
     */
    private String[][] tdata;

    JTextField enddate = new JTextField(15);

    /**
     * Notifications for errors to pop up
     */

    private final JLabel notification = new JLabel("");

    /**
     * The controller
     */
    private final ShowHistoryController controller;
    private final JPanel screens;

    /**
     * A window with a title and a JButton.
     */

    public ShowHistoryScreen(ShowHistoryController controller, JPanel screens) {
        this.screens = screens;
        //tony's screen method
        setLayout();
        addTitle();
        addTextBoxes();
        addNotification();
        JButton add = getShowHistoryButton();
        JButton returnToMenu = getMenuButton();
        addButtons(returnToMenu, add);
        this.controller = controller;
    }


    //set the lay out
    private void setLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    //Set the the text on the top of the screen
    private void addTitle() {

        JLabel title = new JLabel("Choose history date Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }

    ///Add the jtable for the history data
    //private void addTable(String[][] tdata){

    //};

    ///Add the startdate and enddate textbox
    private void addTextBoxes() {
        Label startdateinfo = new Label(
                new JLabel("Enter the start date of history that you want to look at(yyyy-mm-dd HH:mm:ss)"), startdate);
        Label enddateinfo = new Label(
                new JLabel("Choose the end date of the history that you want to look at(yyyy-mm-dd HH:mm:ss)"), enddate);
        JPanel textBoxPanel = new JPanel();
        GroupLayout layout = new GroupLayout(textBoxPanel);
        textBoxPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().addComponent(startdateinfo).addComponent(enddateinfo));
        hGroup.addGroup(layout.createParallelGroup().addComponent(startdate).addComponent(enddate));
        layout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(startdateinfo).addComponent(startdate));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(enddateinfo).addComponent(enddate));
        layout.setVerticalGroup(vGroup);
        this.add(textBoxPanel);
    }

    private JButton getShowHistoryButton() {
        JButton showhistorybutton = new JButton("Show History");

        //not sure if need to add this button to a Jpanel. not do here
        showhistorybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Click " + evt.getActionCommand());
                try {
                    ShowHistoryResponseModel output =
                            controller.show(startdate.getText(), enddate.getText());
                    if (!Objects.equals(output.geterror(), "")) {
                        setNotification(output.geterror());

                    }
                    ////use jtable to show the list of history data in the user interface
                    else {
                        new ShowHistoryResultScreen(output.gethistorydata());
                        //should we start the streen?


                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        });
        return showhistorybutton;
    }

    private JButton getMenuButton() {
        JButton returnToMenu = new JButton("Main menu");

        returnToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) screens.getLayout();
                cardLayout.show(screens, "Main");
                setNotification("");
            }
        });
        return returnToMenu;
    }

    //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    //this.add(title);
    //this.add(startdateinfo);
    //this.add(enddateinfo);
    //this.add(showhistory);
    //


    ////add add and menu button to the screen
    private void addButtons(JButton returnToMenu, JButton showhistory) {
        JPanel buttons = new JPanel();
        buttons.add(showhistory);
        buttons.add(returnToMenu);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    //public void actionPerformed(ActionEvent evt){
    //System.out.println("Click " + evt.getActionCommand());
    //try{
    //ShowHistoryResponseModel output =
    // ShowHistoryController.show(startdate.getText(),enddate.getText());
    //if (!Objects.equals(output.geterror(), "")){
    // this.setNotification(output.geterror());

    //}
    ////use jtable to show the list of history data in the user interface
    //else{
    //output.gethistorydata();

    //}

    //} catch (Exception e) {
    // throw new RuntimeException(e);
    //}
    //}
    private void addNotification() {
        this.add(notification);
    }

    public void setNotification(String messasge) {
        notification.setText(messasge);
    }

    //Driver method
}

/// String[][] test = new String[][]{{"2021-12-03 06:46:33","Daisy","Add","Apple","1","apple123"}};
//                ShowHistoryResponseModel output = new ShowHistoryResponseModel("2021-01-01 00:00:00","2022-01-01 00:00:00",test);
//                return output;



