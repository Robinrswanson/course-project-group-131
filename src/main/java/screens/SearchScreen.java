package screens;

import interface_adaptors.search_sort.SearchController;
import interface_adaptors.search_sort.SearchIView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchScreen extends JPanel implements SearchIView {

    private final JTextField serialNumberField = new JTextField(20);

    private final JPanel screens;
    private final SearchController controller;

    private final JLabel notification = new JLabel("");


    public SearchScreen(JPanel screens, SearchController controller){
        this.screens = screens;
        this.controller = controller;
        setLayout();

        addTitle();
        addTextBoxes();
        addNotification();

        JButton search = getSearchButton();
        JButton returnToMenu = getMenuButton();
        addButtons(returnToMenu, search);

    }



    /**
     * Sets the layout of the screen. Currently, the layout is set to BoxLayout, which stacks added
     * components/panels on top of each other one by one.
     */
    private void setLayout() { this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));}

    /**
     * Sets the text on the top of the screen to "Search for Item"
     */
    private void addTitle() {
        JLabel title = new JLabel("Search for Item");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }

    /**
     * Adds the Serial Number text boxes.
     */
    private void addTextBoxes() {
        JLabel serialNumberLabel = new JLabel("Enter Serial Number");

        JPanel textBoxPanel = new JPanel();
        GroupLayout layout = new GroupLayout(textBoxPanel);
        textBoxPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()).
                addComponent(serialNumberLabel);
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(serialNumberField));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(serialNumberLabel).addComponent(serialNumberField));
        layout.setVerticalGroup(vGroup);
        this.add(textBoxPanel);
    }

    /**
     * Constructs a new button that when pressed, calls on the controller to start the Search Use case.
     * @return the "search" button
     */
    private JButton getSearchButton() {
        JButton search = new JButton("Search");

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(serialNumberField.getText());
              controller.searchItem(serialNumberField.getText());
            }
        });
    return search;}

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

        return returnToMenu;}
    private void addButtons(JButton returnToMenu, JButton search){
        JPanel buttons = new JPanel();
        buttons.add(search);
        buttons.add(returnToMenu);
        this.add(buttons);
    }


    /**
     * Adds the notification indicating successful search of the item
     */
    private void addNotification() {this.add(notification);}

    /**
     * Changes the value of the notification. Called on by the SearchPresenter
     * @param message the message to change the notification to
     */
    @Override
    public void setMessage(String message) {notification.setText(message);}
}
