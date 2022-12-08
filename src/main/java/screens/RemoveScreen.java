package screens;

import interface_adaptors.arr.RemoveController;
import interface_adaptors.arr.ReturnController;

import javax.swing.*;

public class RemoveScreen extends AddScreen{
    /**
     * A subclass of AddScreens, creates the screen for the user to interact with
     */

    private final RemoveController controller;

    /**
     * @param screens A card layout of all the screens
     * @param controller An object of RemoveController
     *
     */
    public RemoveScreen(JPanel screens, RemoveController controller)
    {
        super(screens);
        this.controller = controller;
        super.setLayout();
        this.addTitle();
        super.addTextBoxes();
        JButton removeItem = getRemoveButton();
        JButton returnToMenu = getMenuButton();
        this.addButtons(returnToMenu, removeItem);
    }

    /**
     * Adds the title to the screen
     */
    @Override
    protected void addTitle()
    {
        JLabel screenTitle = new JLabel("Remove Item");
        JPanel titlePanel = new JPanel();
        titlePanel.add(screenTitle);
        this.add(titlePanel);
    }

    /**
     * Creates and returns a Remove button for the screen
     *
     * @return JButton
     */
    protected JButton getRemoveButton() {
        JButton removeItem = new JButton("Remove");

        removeItem.addActionListener(e -> {
            try {
                controller.removeItem(serialNumberField.getText(), Integer.parseInt(quantityField.getText())); //Valid quantity makes a call to the ReturnController
            }
            catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "You haven't entered a valid quantity"); //shows the message in a dialog box in the returnScreen (this)
            }
        });
        return removeItem;
    }


}