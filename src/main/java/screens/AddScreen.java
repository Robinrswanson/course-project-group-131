package screens;
import interface_adaptors.arr.ARRIView;
import interface_adaptors.arr.AddController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddScreen extends JPanel implements ARRIView {

    private final JTextField serialNumberField = new JTextField(20);
    private final JTextField quantityField = new JTextField(20);

    private final JPanel screens;
    private final JLabel notification = new JLabel("");

    private final AddController controller;

    public AddScreen(JPanel screens, AddController controller){

        this.screens = screens;
        this.controller = controller;

        setLayout();

        addTitle();
        addTextBoxes();

        addNotification();

        JButton add = getAddButton();
        JButton returnToMenu = getMenuButton();
        addButtons(returnToMenu, add);
    }

    /**
     * Sets the layout of the screen. Currently, the layout is set to BoxLayout, which stacks added
     * components/panels on top of each other one by one.
     */
    private void setLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Sets the text on the top of the screen to "Add an Item"
     */
    private void addTitle() {
        JLabel title = new JLabel("Add an Item");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }

    /**
     * Adds the Serial Number and Quantity text boxes.
     */
    private void addTextBoxes() {

        JLabel serialNumberLabel = new JLabel("Enter Serial Number");
        JLabel quantityLabel = new JLabel("Enter Quantity");

        JPanel textBoxPanel = new JPanel();
        GroupLayout layout = new GroupLayout(textBoxPanel);
        textBoxPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(serialNumberLabel).addComponent(quantityLabel));
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(serialNumberField).addComponent(quantityField));
        layout.setHorizontalGroup(hGroup);
        // formats the necessary components to be parallel horizontally

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(serialNumberLabel).addComponent(serialNumberField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(quantityLabel).addComponent(quantityField));
        layout.setVerticalGroup(vGroup);
        // formats the necessary components to be parallel vertically
        // most of this is all formatting to be honest - the backbone can be done quickly with much fewer lines of code

        this.add(textBoxPanel);
    }

    /**
     * Constructs a new button that when pressed, calls on the controller to start the Add Use case.
     * @return the "add" button
     */
    private JButton getAddButton() {

        JButton add = new JButton("Add");

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // controller etc. but for now:
                System.out.println(serialNumberField.getText() + quantityField.getText());
                try{
                    controller.addItem(serialNumberField.getText(), Integer.parseInt(quantityField.getText()));
                } catch (NumberFormatException ex1){
                    setMessage("Please enter a numeric quantity");
                } // this can be removed if deemed not necessary
            }
        });
        return add;
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
                setMessage("");
            }
        });

        return returnToMenu;
    }

    /**
     * Adds the "add" and "menu" button to the screen
     * @param returnToMenu the returnToMenu button created by getMenuButton
     * @param add the add button created by getAddButton
     */
    private void addButtons(JButton returnToMenu, JButton add) {
        JPanel buttons = new JPanel();
        buttons.add(add);
        buttons.add(returnToMenu);
        this.add(buttons);
    }

    /**
     * Adds the notification indicating successful addition of the item
     */
    private void addNotification() {
        this.add(notification);
    }

    /**
     * Changes the value of the notification. Called on by the AddPresenter
     * @param message the message to change the notification to
     */
    public void setMessage(String message){
        notification.setText(message);
    }
}

