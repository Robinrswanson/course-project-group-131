package screens;

import interface_adaptors.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateScreen extends JPanel{
    private final JTextField serialNumText = new JTextField(20);
    private final JTextField priceUpdateText = new JTextField(20);

    private final JLabel notification = new JLabel("");
    private final JPanel screens;
    private final UpdateController controller;

    public UpdateScreen(JPanel screens, UpdateController controller){
        this.screens = screens;
        this.controller = controller;

        setLayout();

        addTitle();
        addTextBoxes();

        addNotification();

        JButton update = getUpdateButton();
        JButton returnToMenu = getMenuButton();
        addButtons(returnToMenu, update);
    }

    /**
     * Sets the layout of the screen.
     */
    private void setLayout(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Sets the text on the top of the screen to "Update the price of an Item".
     */
    private void addTitle(){
        JLabel title = new JLabel("Update the price of an Item");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }

    /**
     * Adds the Serial Number and Price text boxes.
     */
    private void addTextBoxes(){
        JLabel serialNumLabel = new JLabel("Serial Number:");
        JLabel priceUpdateLabel = new JLabel("Updated price:");

        JPanel textBoxPanel = new JPanel();
        GroupLayout layout = new GroupLayout(textBoxPanel);
        textBoxPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(serialNumLabel).addComponent(priceUpdateLabel));
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(serialNumText).addComponent(priceUpdateText));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(serialNumLabel).addComponent(serialNumText));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(priceUpdateLabel).addComponent(priceUpdateText));
        layout.setVerticalGroup(vGroup);

        this.add(textBoxPanel);
    }

    /**
     * Constructs a new button that when pressed, calls on the controller to start the Update
     * Use Case.
     * @return the "update" button
     */
    private JButton getUpdateButton(){
        JButton update = new JButton("Update2");

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // controller etc. but for now:
                System.out.println(serialNumText.getText() + priceUpdateText.getText());
                try{
                    String message = controller.updateItem_price(serialNumText.getText(),
                            Double.parseDouble(priceUpdateText.getText()), true);
                    // true is for now. By default, the person has the right to update price.
                    // This is related to log in system, should return a boolean value.
                } catch (NumberFormatException ex1){
                    setNotification("Please enter a numeric price");
                }
            }
        });
        return update;
    }


    /**
     * Constructs a button that when pressed, returns the user back to the Main Menu (view to view, no adaptors needed)
     * @return the "menu" button
     */
    private JButton getMenuButton() {

        JButton returnToMenu = new JButton("Main Menu");

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

    /**
     * Adds the "update" and "menu" button to the screen
     * @param returnToMenu the returnToMenu button created by getMenuButton
     * @param update the update button created by getUpdateButton
     */
    private void addButtons(JButton returnToMenu, JButton update){
        JPanel buttons = new JPanel();
        buttons.add(update);
        buttons.add(returnToMenu);
        this.add(buttons);
    }

    /**
     * Adds the notification indicating item updating is successful
     */
    private void addNotification(){
        this.add(notification);
    }

    /**
     * Changes the value of the notification
     * @param message the message to change the notification to
     */
    public void setNotification(String message){
        notification.setText(message);
    }
}
