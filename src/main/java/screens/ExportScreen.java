package screens;

import entities.TempDataStorage;
import interface_adaptors.ExportController;
import interface_adaptors.ExportPresenter;
import use_cases.Export;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExportScreen extends JPanel{

    private final JTextField serialNumberField = new JTextField(20);
    private final JTextField quantityField = new JTextField(20);
    private final JPanel screens;
    private final JLabel notification = new JLabel("");

    private final ExportController controller;
    public ExportScreen(JPanel screens, ExportController controller) {
        this.screens = screens;
        this.controller = controller;

        setLayout();

        addTitle();

        addNotification();

        JButton export = getAddButton();
        JButton returnToMenu = getMenuButton();
        addButtons(returnToMenu, export);
    }
    private void setLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void addTitle(){
        JLabel title = new JLabel("Export Inventory");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }

    /**
     * Constructs a new button that when pressed, calls on the controller to start the Add Use case.
     * @return the "add" button
     */
    private JButton getAddButton() {

        JButton export = new JButton("Export");

        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(serialNumberField.getText() + quantityField.getText());
                    String message = controller.export();
                    setNotification(message);
                }
        });
        return export;
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

    private void addButtons(JButton returnToMenu, JButton export) {
        JPanel buttons = new JPanel();
        buttons.add(export);
        buttons.add(returnToMenu);
        this.add(buttons);
    }

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

        Export useCase = new Export();
        ExportController controller = new ExportController(useCase);
        JPanel screen1 = new JPanel();
        ExportScreen screen = new ExportScreen(screen1, controller);

        screens.add(screen);

        application.add(screens);
        cardLayout.show(screens, "Main");

        application.pack();
        application.setVisible(true);

        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
