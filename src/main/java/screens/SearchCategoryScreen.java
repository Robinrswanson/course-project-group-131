package screens;

import interface_adaptors.search_sort.SearchCategoriesController;
import interface_adaptors.search_sort.SearchCategoryIView;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchCategoryScreen extends JPanel implements SearchCategoryIView {
    //TODO ensure that the string is converted into a list and that the user knows the proper format
    private final JTextField categoriesField = new JTextField(80);
    private final JPanel screens;
    private final SearchCategoriesController controller;
    private final JLabel notification = new JLabel("");

    public SearchCategoryScreen(JPanel screens, SearchCategoriesController controller){
        this.screens = screens;
        this.controller = controller;
        setLayout();

        addTitle();
        addTextBoxes();
        addNotification();

        JButton searchCategory = getSearchCategoryButton();
        JButton returnToMenu = getMenuButton();
        addButtons(returnToMenu, searchCategory);
    }
    /**
     * Sets the layout of the screen. Currently, the layout is set to BoxLayout, which stacks added
     * components/panels on top of each other one by one.
     */
    private void setLayout() {this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));}
    /**
     * Sets the layout of the screen. Currently, the layout is set to BoxLayout, which stacks added
     * components/panels on top of each other one by one.
     */
    private void addTitle() {
        JLabel title = new JLabel("Search for Item by Category");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }

    /**
     * Adds the categories text boxes.
     */
    private void addTextBoxes() {
        JLabel categoriesLabel = new JLabel("Enter Categories");

        JPanel textBoxPanel = new JPanel();
        GroupLayout layout = new GroupLayout(textBoxPanel);
        textBoxPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()).
                addComponent(categoriesLabel);
        hGroup.addGroup(layout.createParallelGroup()).
                addComponent(categoriesField);
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                .addComponent(categoriesLabel).addComponent(categoriesField);
        layout.setVerticalGroup(vGroup);
        this.add(textBoxPanel);
    }
    /**
     * Constructs a new button that when pressed, calls on the controller to start the Add Use case.
     * @return the "Search by Category" button
     */
    private JButton getSearchCategoryButton() {
        JButton searchCategory = new JButton("Search by Category");

        searchCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(categoriesField.getText());
                controller.searchCategory(categoriesField.getText().split(","));

            }
        });
    return searchCategory;}

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

    /**
     * Adds the "add" and "menu" button to the screen
     * @param returnToMenu the returnToMenu button created by getMenuButton
     * @param searchCategory the searchCategory button created by getSearchCategoryButton
     */
    private void addButtons(JButton returnToMenu, JButton searchCategory) {
        JPanel buttons = new JPanel();
        buttons.add(searchCategory);
        buttons.add(returnToMenu);
        this.add(buttons);
    }
    private void addNotification() {this.add(notification);}


    /**
     * Changes the value of the notification. Called on by the SearchCategoryPresenter
     * @param message the message to change teh notification to
     */
    @Override
    public void setMessage(String message) {notification.setText(message);}
}
