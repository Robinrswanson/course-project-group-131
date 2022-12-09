package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainEmployeeScreen extends JPanel {

    private static JPanel screens;
    static final int BUTTON_HEIGHT_CONSTANT = 40;
    static final int BUTTON_HEIGHT_WIDTH = 200;


    public MainEmployeeScreen(JPanel screens) {

        this.screens = screens;

        setLayout();

        addTitle();

        /*
        JButton add = createMenuButton(ARRIView.ADD_SCREEN_NAME_CONSTANT);
        JButton returnItem = createMenuButton(ARRIView.RETURN_SCREEN_NAME_CONSTANT);
        JButton remove = createMenuButton(ARRIView.REMOVE_SCREEN_NAME_CONSTANT);
        JButton search = createMenuButton(SearchIView.SEARCH_SCREEN_NAME_CONSTANT);
        JButton searchCat = createMenuButton(SearchCategoryIView.SEARCH_SCREEN_NAME_CONSTANT);
        JButton sort = createMenuButton(SortIView.SORT_SCREEN_NAME_CONSTANT);
        JButton history = createMenuButton(ShowHistoryView.SHOW_HISTORY_NAME_CONSTANT);
        JButton importItem = createMenuButton(ImportIView.IMPORT_SCREEN_NAME_CONSTANT);
        JButton exportItem = createMenuButton(ExportIView.EXPORT_SCREEN_NAME_CONSTANT);
         */
        // createLogOut();

        // JButton update = createMenuButton(UpdateIview.UPDATE_SCREEN_NAME_CONSTANT);
        // JButton salesReport = createMenuButton(SalesReporterView.SALES_REPORT_SCREEN_NAME);

        //packButtons(new JButton[]{add, returnItem});
        //packButtons(new JButton[]{remove, sort});
        //packButtons(new JButton[]{search, searchCat});
        //packButtons(new JButton[]{salesReport, history});
        //packButtons(new JButton[]{importItem, exportItem});
        //packButtons(new JButton[]{logOut, update});
        // packing is just so the orientation is more organized

    }

    public JButton createLogOut() {
        JButton logOut = createMenuButton("Log Out");
        logOut.addActionListener(e -> {
                int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to LogOut", "Log Out", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    System.exit(0);

            }
        });
        return logOut;
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
    public JButton createMenuButton(String text) {
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
    public void packButtons(ArrayList<JButton> buttonList){
        JPanel buttonPanel = new JPanel();
        for (JButton b: buttonList){
            buttonPanel.add(b);
        }
        this.add(buttonPanel);
    }



}

