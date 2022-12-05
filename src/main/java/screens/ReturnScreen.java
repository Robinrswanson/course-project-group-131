package screens;
import javax.swing.*;

import interface_adaptors.arr.ReturnController;
import use_cases.arr.ARROutputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnScreen extends AddScreen {

    private ReturnController controller;
    public ReturnScreen(JPanel screens, ReturnController controller)
    {
        super(screens,controller);
        JButton returnItem = getReturnButton();
        JButton returnToMenu = getMenuButton();
        addButtons(returnToMenu, returnItem);
    }

    protected void addTitle()
    {
        JLabel screenTitle = new JLabel("Item Return");
        JPanel titlePanel = new JPanel();
        titlePanel.add(screenTitle);
        this.add(titlePanel);
    }

    protected JButton getReturnButton()
    {
        super.getAddButton();
        JButton returnItem = new JButton("Return");

        returnItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    controller.returnItem(serialNumberField.getText(), Integer.parseInt(quantityField.getText()));
                }
                catch (NumberFormatException exception)
                {
                    JOptionPane.showMessageDialog()
                }
            }
        };
        return returnItem;
    }

    public void itemReturned(int itemCount)
    {
        JOptionPane.showMessageDialog(null, "The item has been Returned \n The new items are: " + itemCount, "Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    public void itemNotReturned()
    {
        JOptionPane.showMessageDialog(null, "The item has not been Returned", "Rejected", JOptionPane.WARNING_MESSAGE);

    }

}
