package screens;
import entities.TempDataStorage;
import interface_adaptors.*;
import use_cases.Export;
import use_cases.Import;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImportScreen extends JPanel{

    private final JTextField directoryField = new JTextField(20);

    private final JPanel screens;
    private final JLabel notification = new JLabel("");

    private final ImportController controller;

    public ImportScreen(JPanel screens, ImportController controller){

        this.screens = screens;
        this.controller = controller;

        setLayout();

        addTitle();
        addTextBoxes();

        addNotification();

        JButton add = getAddButton();
        JButton returnToMenu = getMenuButton();
        addButtons(returnToMenu, add);
    }

    /**
     * Sets the layout of the screen. Currently, the layout is set to BoxLayout, which stacks added
     * components/panels on top of each other one by one.
     */
    private void setLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Sets the text on the top of the screen to "Add an Item"
     */
    private void addTitle() {
        JLabel title = new JLabel("Import an Inventory");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }

    /**
     * Adds the Serial Number and Quantity text boxes.
     */
    private void addTextBoxes() {

        JLabel directoryLabel = new JLabel("Enter directory");

        JPanel textBoxPanel = new JPanel();
        GroupLayout layout = new GroupLayout(textBoxPanel);
        textBoxPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        this.add(directoryLabel);
        this.add(directoryField);
    }

    /**
     * Constructs a new button that when pressed, calls on the controller to start the Add Use case.
     * @return the "add" button
     */
    private JButton getAddButton() {

        JButton add = new JButton("Import");

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // controller etc. but for now:
                System.out.println(directoryField.getText());
                try{
                    String message = controller.importDatabase(directoryField.getText());
                    setNotification(message);
                } catch (FileNotFoundException ex1){
                    setNotification("Please enter a valid directory");
                } // this can be removed if deemed not necessary
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        return add;
    }

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
                setNotification("");
            }
        });

        return returnToMenu;
    }

    /**
     * Adds the "add" and "menu" button to the screen
     * @param returnToMenu the returnToMenu button created by getMenuButton
     * @param add the add button created by getAddButton
     */
    private void addButtons(JButton returnToMenu, JButton add) {
        JPanel buttons = new JPanel();
        buttons.add(add);
        buttons.add(returnToMenu);
        this.add(buttons);
    }

    /**
     * Adds the notification indicating successful addition of the item
     */
    private void addNotification() {
        this.add(notification);
    }

    /**
     * Changes the value of the notification
     * @param message the message to change the notification to
     */
    public void setNotification(String message){
        notification.setText(message);
    }
    public static void main(String[] args) {
        TempDataStorage inventory = new TempDataStorage();

        JFrame application = new JFrame("Main Screen");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);

        ImportPresenter presenter = new ImportPresenter();
        Import useCase = new Import(presenter);
        ImportController controller = new ImportController(useCase);
        JPanel screen1 = new JPanel();
        ImportScreen screen = new ImportScreen(screen1, controller);

        screens.add(screen);

        application.add(screens);
        cardLayout.show(screens, "Main");

        application.pack();
        application.setVisible(true);

        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
