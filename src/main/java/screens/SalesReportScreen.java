package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SalesReportScreen extends JPanel implements ActionListener {
    public static final int VISIBLE_ROWS = 10;
    public static final int SCROLLER_WIDTH = 250;
    public static final int SCROLLER_HEIGHT = 200;
    private JPanel screens;
    /**
     * Constructs a new Sales Report Screen
     * @param screens the deck of screens instantiated at the beginning of Main
     * @param data the rows of data to display in the sales report
     */
    public SalesReportScreen(JPanel screens, ArrayList<String[]> data){

        this.screens = screens;

        setLayout();
        addTitle();
    }

    private void setLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Adds the "Menu" and "Change Date Range" buttons at the bottom of the screen
     * @param returnToMenu the Menu button
     * @param changeDateRange the Change Date Range button
     */
    private void addBottomButtons(JButton returnToMenu, JButton changeDateRange) {
        JPanel bottomButtonPane = new JPanel();
        bottomButtonPane.setLayout(new BoxLayout(bottomButtonPane, BoxLayout.X_AXIS));
        bottomButtonPane.add(changeDateRange);
        bottomButtonPane.add(returnToMenu);
        this.add(bottomButtonPane);
    }
    /**
     * Creates the Change Date Range button. The action listener is not yet implemented
     * @return returns the button
     */
    private static JButton createDateButton() {
        JButton changeDateRange = new JButton("Change Date Range");
        changeDateRange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // screen to change date range
            }
        });
        return changeDateRange;
    }


    /**
     * Creates the Menu Button, which upon click returns the user back to the Main Menu
     * @param screens
     * @return
     */
    private static JButton createMenuButton(JPanel screens){
        JButton returnToMenu = new JButton("Main Menu");
        returnToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) screens.getLayout();
                cardLayout.show(screens, "Main");
            }
        });
        return returnToMenu;
    }

    private static JTable createTable ()




    }
}
