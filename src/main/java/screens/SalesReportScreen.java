package screens;

import interface_adaptors.sales_report.SalesReporterController;
import interface_adaptors.sales_report.SalesReporterView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


public class SalesReportScreen extends JPanel implements SalesReporterView {

    private static final String[] HEADERS =
            {"Item Serial No.", "Item Name", "Price", "Quantity Sold", "Items Returned", "Revenue"};
    private final JTextField startTimeField = new JTextField(20);
    private final JTextField endTimeField = new JTextField(20);

    private JPanel screens;
    private final JLabel notification = new JLabel("");
    private JTable table = new JTable(new DefaultTableModel(new String[][] {}, HEADERS));
    public static final int SCROLLER_WIDTH = 250;
    public static final int SCROLLER_HEIGHT = 200;
    private final SalesReporterController controller;


    /**
     * Constructs a new Sales Report Screen
     * @param screens the deck of screens instantiated at the beginning of Main
     * @param controller the
     */
    public SalesReportScreen(JPanel screens, SalesReporterController controller){
        this.screens = screens;
        this.controller = controller;
        setLayout();

        addTitle();
        addTextBoxes();
        addNotification();
        JButton generateReport = createReportButton();
        JButton returnToMenu = createMenuButton();
        addButtons(generateReport, returnToMenu);
        addTable();
        addScrollScreen(table);
    }

    /**
     * Sets the layout to BoxLayout
     */
    private void setLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    /**
     * Creates the screen title at the top
     */
    private void addTitle() {
        JLabel title = new JLabel("Sales Report");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }
    /**
     * Adds the Start Time and End Time text boxes.
     */
    private void addTextBoxes() {
        JLabel startTime = new JLabel("Enter a Start Time in the format yyyy-MM-dd HH:mm");
        JLabel endTime = new JLabel("Enter an End Time in the format yyyy-MM-dd HH:mm");

        JPanel textBoxPanel = new JPanel();
        GroupLayout layout = new GroupLayout(textBoxPanel);
        textBoxPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(startTime).addComponent(endTime));
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(startTimeField).addComponent(endTimeField));
        layout.setHorizontalGroup(hGroup);
        // formats the necessary components to be parallel horizontally

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(startTime).addComponent(startTimeField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(endTime).addComponent(endTimeField));
        layout.setVerticalGroup(vGroup);
        this.add(textBoxPanel);
    }

    /**
     * Creates the Generate Report button. The action listener is not yet implemented
     * @return returns the button
     */
    private JButton createReportButton() {
        JButton generateReport = new JButton("Generate Report");
        generateReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.reportData(startTimeField.getText(), endTimeField.getText());
                } catch (IOException entryException){
                    setMessage("Report failed to generate");
                }
            }
        });
        return generateReport;
    }

    /**
     * Creates the Menu Button, which upon click returns the user back to the Main Menu
     * @return the button
     */
    private JButton createMenuButton() {
        JButton returnToMenu = new JButton("Main Menu");

        returnToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) screens.getLayout();
                cardLayout.show(screens, "Main");
                setMessage("");
            }
        });
        return returnToMenu;
    }

    /**
     * Adds the "Generate Report" and "Return to Menu" button to the screen
     * @param generateReport the generateReport button created by createReportButton
     * @param returnToMenu the returnToMenu buton created by createMenuButton
     */
    private void addButtons(JButton generateReport, JButton returnToMenu) {
        JPanel buttons = new JPanel();
        buttons.add(generateReport);
        buttons.add(returnToMenu);
        this.add(buttons);
    }

    /**
     * Adds the notification for indicating whether or not generating the report was successful
     */
    private void addNotification() { this.add(notification);}

    /**
     * Changes the value of the notification. Called on by the SalesReporterPresenter
     * @param message the message to change the notification to
     */
    public void setMessage(String message) { notification.setText(message);}

    /**
     * Adds an empty table with the constant HEADERS to the screen
     */
    private void addTable() {this.add(table);}

    /**
     * Changes the value of the table. Called by the SalesReporterPresenter
     * @param data the rows to add to the table
     */
    public void setTable(ArrayList<String[]> data) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (String[] row: data) {
            model.addRow(row);
        }
    }

    /**
     * Creates the scroll screen, allowing users to view all the rows in the sales report
     * @param table The JTable containing all the report data to display
     */
    private void addScrollScreen(JTable table) {
        JScrollPane tableScroller = new JScrollPane();
        tableScroller.setPreferredSize(new Dimension(SCROLLER_WIDTH, SCROLLER_HEIGHT));
        tableScroller.setViewportView(table);
        this.add(tableScroller);
    }

}

