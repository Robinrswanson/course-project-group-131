package screens;
import javax.swing.*;

import interface_adaptors.arr.ReturnController;

import java.awt.*;

public class ReturnScreen extends AddScreen {
    /**
     * A subclass of AddScreens, creates the screen for the use to interact with
     */

    private final ReturnController controller;

    /**
     * @param screens A card layout of all the screens
     * @param controller An object of ReturnController
     *
     */
    public ReturnScreen(JPanel screens, ReturnController controller)
    {
        super(screens);
        this.controller = controller;
        super.setLayout();
        this.addTitle();
        super.addTextBoxes();
        JButton returnItem = getReturnButton();
        JButton returnToMenu = getMenuButton();
        this.addButtons(returnToMenu, returnItem);
    }

    /**
     * Adds the title to the screen
     */
    @Override
    protected void addTitle()
    {
        JLabel screenTitle = new JLabel("Item Return");
        JPanel titlePanel = new JPanel();
        titlePanel.add(screenTitle);
        this.add(titlePanel);
    }

    /**
     * Creates and returns a Return button for the screen
     *
     * @return JButton
     */
    protected JButton getReturnButton() {
        JButton returnItem = new JButton("Return");

        returnItem.addActionListener(e -> {
            try {
                controller.returnItem(serialNumberField.getText(), Integer.parseInt(quantityField.getText())); //Valid quantity makes a call to the ReturnController
            }
            catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "You haven't entered a valid quantity"); //shows the message in a dialog box in the returnScreen (this)
            }
        });
        return returnItem;
    }

}
