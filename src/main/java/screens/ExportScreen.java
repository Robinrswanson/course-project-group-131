package screens;

import interface_adaptors.export_inventory.ExportController;
import interface_adaptors.export_inventory.ExportIView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExportScreen extends JPanel implements ExportIView {

    private final JTextField serialNumberField = new JTextField(20);
    private final JTextField quantityField = new JTextField(20);
    private final JPanel screens;
    private final JLabel notification = new JLabel("");

    private final ExportController controller;
    public ExportScreen(JPanel screens, ExportController controller) {
        this.screens = screens;
        this.controller = controller;

        setLayout();

        addTitle();

        addNotification();

        JButton export = getAddButton();
        JButton returnToMenu = getMenuButton();
        addButtons(returnToMenu, export);
    }

    /**
     * Sets the layout of the screen.
     */
    private void setLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Adds title to the screen.
     */

    private void addTitle(){
        JLabel title = new JLabel("Export Inventory");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }

    /**
     * Constructs a new button that when pressed, calls on the controller to start the export case.
     * @return the "Export" button
     */
    private JButton getAddButton() {

        JButton export = new JButton("Export");

        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(serialNumberField.getText() + quantityField.getText());
                    controller.export();
                }
        });
        return export;
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
     * Adds buttons to the screen.
     * @param returnToMenu a JButton that when interacted with returns the user to their respective menu screen.
     * @param export a JButton that when pressed allows a user to export the inventory.
     */

    private void addButtons(JButton returnToMenu, JButton export) {
        JPanel buttons = new JPanel();
        buttons.add(export);
        buttons.add(returnToMenu);
        this.add(buttons);
    }

    /**
     * Updates the screen to display a notification.
     */

    private void addNotification() {
        this.add(notification);
    }

    @Override
    /**
     * Changes the value of the notification
     * @param message the message to change the notification to
     */
    public void setMessage(String message){
        notification.setText(message);
    }
    }