package screens;

import interface_adaptors.arr.ARRIView;
import interface_adaptors.update_price.UpdateIview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainEmployeeScreen extends JPanel {

    private static JPanel screens;
    static final int BUTTON_HEIGHT_CONSTANT = 40;
    static final int BUTTON_HEIGHT_WIDTH = 200;

    public MainEmployeeScreen(JPanel screens) {

        this.screens = screens;

        setLayout();
        addTitle();

        // I'm fairly sure this violates the open-closed principle, any suggestions on how to improve this would be much appreciated
        JButton add = createMenuButton(ARRIView.ADD_SCREEN_NAME_CONSTANT);
        JButton returnItem = createMenuButton("Return Items");
        JButton remove = createMenuButton("Remove Items");
        JButton search = createMenuButton("Search For Items");
        JButton filter = createMenuButton("Display/Filter Items");
        JButton history = createMenuButton("Show History");
        JButton logOut = createMenuButton("Log Out");
        JButton update = createMenuButton(UpdateIview.UPDATE_SCREEN_NAME_CONSTANT);

        packButtons(new JButton[]{add, returnItem});
        packButtons(new JButton[]{remove, search});
        packButtons(new JButton[]{filter, history});
        packButtons(new JButton[]{logOut, update});
        // packing is just so the orientation is more organized

    }

    /**
     * Sets the layout of the screen. For now, Box Layout is used to stack the components on top of each other
     */
    private void setLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Sets the title of the main screen.
     */
    private void addTitle() {
        JLabel title = new JLabel("EMPLOYEE ACTIONS", SwingConstants.CENTER);
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }

    /**
     * Creates a new menu button
     * @param text This text will act both as the label for the button and the identifier for the screen that will be
     *             accessed when the button is pressed
     * @return the button
     */
    private static JButton createMenuButton(String text) {
        JButton button = new JButton(text);

        button.setPreferredSize(new Dimension(BUTTON_HEIGHT_WIDTH, BUTTON_HEIGHT_CONSTANT));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) screens.getLayout();
                cardLayout.show(screens, text);
                // except for log out, which should be separate
            }
        });
        return button;
    }

    /**
     * Purely for formatting purposes
     * @param buttonList A list of buttons
     */
    private void packButtons(JButton[] buttonList){
        JPanel buttonPanel = new JPanel();
        for (JButton b: buttonList){
            buttonPanel.add(b);
        }
        this.add(buttonPanel);
    }

}

