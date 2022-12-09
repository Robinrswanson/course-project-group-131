package screens;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class SortScreen extends JPanel implements SortIView {
    private final JTextField parametersField = new JTextField(80);

    private final JPanel screens;

    private final SortController controller;

    private final JLabel notification = new JLabel("");

    public SortScreen(JPanel screens, SortController controller){
        this.screens = screens;
        this.controller = controller;
        setLayout();

        addTitle();
        addTextBoxes();
        addNotification();

        JButton sort = getSortButton();
        JButton returnToMenu = getMenuButton();
        addButtons(returnToMenu, sort);
    }
    /**
     * Sets the layout of the screen. Currently, the layout is set to BoxLayout, which stacks added
     * components/panels on top of each other one by one.
     */
    private void setLayout() {this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));}

    /**
     * Sets the text on the top of the screen to "Sort for Item"
     */
    private void addTitle() {
        JLabel title = new JLabel("Sort for Item");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }

    /**
     * Adds the Parameter text boxes
     */
    private void addTextBoxes() {
        JLabel parametersLabel = new JLabel("Enter Parameters");

        JPanel textBoxPanel = new JPanel();
        GroupLayout layout = new GroupLayout(textBoxPanel);
        textBoxPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()).
                addComponent(parametersLabel);
        hGroup.addGroup(layout.createParallelGroup()).
                addComponent(parametersField);
        layout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                .addComponent(parametersLabel).addComponent(parametersField);
        layout.setVerticalGroup(vGroup);
        this.add(textBoxPanel);
    }
    /**
     * Constructs a new button that when pressed, calls on the controller to start the Sort Use case.
     * @return the "Sort Items" button
     */
    private JButton getSortButton() {
        JButton sort = new JButton("Sort Items");

        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(parametersField.getText());
                try {
                    controller.executeSort(parametersField.getText());
                } catch (ParseException ex) {
                    setMessage("Invalid sort parameters");
                }

            }
        });
        return sort;}
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
     * @param sort the sort button created by getAddButton
     */
    private void addButtons(JButton returnToMenu, JButton sort) {
        JPanel buttons = new JPanel();
        buttons.add(sort);
        buttons.add(returnToMenu);
        this.add(buttons);
    }
    private void addNotification() {this.add(notification);}
    @Override
    public void setMessage(String message) {notification.setText(message);

    }

}
