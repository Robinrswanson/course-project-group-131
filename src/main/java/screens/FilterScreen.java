package screens;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class FilterScreen extends JPanel implements ActionListener{

    public static final int VISIBLE_ROWS = 10;
    public static final int SCROLLER_WIDTH = 250;
    public static final int SCROLLER_HEIGHT = 200;
    private JPanel screens;

    /**
     * Constructs a new Filter Screen
     * @param screens the deck of screens instantiated at the beginning of Main
     * @param items the items to display in FilterScreen
     * @param filter the filter used to get the displayed items
     */
    public FilterScreen(JPanel screens, Iterable<FilterScreenInputData> items, String filter) { // it shouldn't directly be dealing with items (use data structure instead)

        this.screens = screens;

        setLayout();
        addTitle(filter);

        DefaultListModel<FilterScreenInputData> listModel = createListModel(items);
        JList<FilterScreenInputData> lst = createJList(listModel);
        addScrollScreen(lst);

        JButton returnToMenu = createMenuButton(screens);
        JButton changeFilter = createFilterButton();
        addBottomButtons(returnToMenu, changeFilter);
    }

    /**
     * Sets the layout to BoxLayout
     */
    private void setLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Adds the "Menu" and "Change Filter" buttons at the bottom of the screen
     * @param returnToMenu the Menu button
     * @param changeFilter the Change Filter button
     */
    private void addBottomButtons(JButton returnToMenu, JButton changeFilter) {
        JPanel bottomButtonPane = new JPanel();
        bottomButtonPane.setLayout(new BoxLayout(bottomButtonPane, BoxLayout.X_AXIS));
        bottomButtonPane.add(changeFilter);
        bottomButtonPane.add(returnToMenu);
        this.add(bottomButtonPane);
    }

    /**
     * Creates the Change Filter button. The action listener is not yet implemented
     * @return returns the button
     */
    private static JButton createFilterButton() {
        JButton changeFilter = new JButton("Add/change Filter");
        changeFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // for the screen where you can set the filter
            }
        });
        return changeFilter;
    }

    /**
     * Creates the Menu Button, which upon click returns the user back to the Main Menu
     * @param screens
     * @return
     */
    private static JButton createMenuButton(JPanel screens) {
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

    /**
     * Creates the scroll screen, which allows the users to view all the filtered items
     * @param lst The JList containing the items to display
     */
    private void addScrollScreen(JList<FilterScreenInputData> lst) {
        JScrollPane listScroller = new JScrollPane(lst);
        listScroller.setPreferredSize(new Dimension(SCROLLER_WIDTH, SCROLLER_HEIGHT));
        this.add(listScroller);
    }

    /**
     * Creates the JList that will be embedded in the Scroll Screen
     * @param listModel the ListModel containing the items to display
     * @return
     */
    private static JList<FilterScreenInputData> createJList(DefaultListModel<FilterScreenInputData> listModel) {
        JList<FilterScreenInputData> lst = new JList<>(listModel);
        lst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lst.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lst.setVisibleRowCount(VISIBLE_ROWS);
        return lst;
    }

    /**
     * Creates a ListModel storing all the items to display
     * @param items an iterable collection of items
     * @return returns the ListModel
     */
    private static DefaultListModel<FilterScreenInputData> createListModel(Iterable<FilterScreenInputData> items) {
        Iterator<FilterScreenInputData> i = items.iterator();
        DefaultListModel<FilterScreenInputData> listModel = new DefaultListModel<>();

        while (i.hasNext()){
            listModel.addElement(i.next());
        }
        return listModel;
    }

    /**
     * Creates the screen title at the top
     * @param filter the filter currently used to obtain the items
     */
    private void addTitle(String filter) {
        JLabel filterTitle = new JLabel(filter);
        JPanel titlePanel = new JPanel();
        titlePanel.add(filterTitle);
        this.add(titlePanel);
    }

    // the bottom two methods will be used to access items in the list when they are clicked -> this will implement
    // parts of Search
    public void actionPerformed(ActionEvent e) {

    }

    public void valueChanged(ListSelectionEvent e){

    }
}

