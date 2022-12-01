package history_screens;

import show_history_use_case.ShowHistoryFinalInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ShowHistoryScreen extends JPanel implements ActionListener {
    /**
     * the start date which the employee wants to look at
     */
    JTextField startdate = new JTextField(15);

    /**
     * the end date which the employee wants to look at
     */

    JTextField enddate = new JTextField(15);

    /**
     * Notifications for errors to pop up
     */

    private final JLabel notification = new JLabel("");

    /**
     * The controller
     */
    ShowHistoryController showhistorycontroller;

    /**
     * A window with a title and a JButton.
     */

    public ShowHistoryScreen(ShowHistoryController controller){
        this.showhistorycontroller = controller;

        JLabel title = new JLabel("Choose history date Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        Label startdateinfo = new Label(
                new JLabel("Choose the start date of history that you want to look at"),startdate) ;
        Label enddateinfo = new Label(
                new JLabel("Choose the end date of the history that you want to look at"),enddate);
        JButton showhistory = new JButton("Show History");

        //not sure if need to add this button to a Jpanel. not do here
        showhistory.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(startdateinfo);
        this.add(enddateinfo);
        this.add(showhistory);

    }
    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt){
        //System.out.println("Click " + evt.getActionCommand());
        try{
            ShowHistoryFinalInput output =
                    ShowHistoryController.show(startdate.getText(),enddate.getText());
            if (!Objects.equals(output.geterror(), "")){
                this.setNotification(output.geterror());

            }
            else{ ////show the list of history data in the user interface

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void addNotification(){this.add(notification);}
    public void setNotification(String messasge){notification.setText(messasge);}
}

