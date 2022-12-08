package screens;

import javax.swing.*;

public interface SimpleScreenBuilder {

    void setLayout();
    void setTitle(String title);
    void addTextBoxes();
    void addNotification();
    void addBottomButtons();

    //



    JPanel getScreen();


}
