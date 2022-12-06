package screens;
import javax.swing.*;

import interface_adaptors.arr.ReturnController;

public class ReturnScreen extends AddScreen {

    private final ReturnController controller;
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
    @Override
    protected void addTitle()
    {
        JLabel screenTitle = new JLabel("Item Return");
        JPanel titlePanel = new JPanel();
        titlePanel.add(screenTitle);
        this.add(titlePanel);
    }

    protected JButton getReturnButton() {
        JButton returnItem = new JButton("Return");

        returnItem.addActionListener(e -> {
            try {
                controller.returnItem(serialNumberField.getText(), Integer.parseInt(quantityField.getText()));
            }
            catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "You haven't entered a valid quantity");
            }
        });
        return returnItem;
    }



/*
    public void itemReturned(int itemCount)
    {
        JOptionPane.showMessageDialog(null, "The item has been Returned \n The new items are: " + itemCount, "Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    public void itemNotReturned()
    {
        JOptionPane.showMessageDialog(null, "The item has not been Returned", "Rejected", JOptionPane.WARNING_MESSAGE);

    }

 */

}
