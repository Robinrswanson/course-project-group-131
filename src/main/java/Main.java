import interface_adaptors.inventory_initializer.InitializerController;
import interface_adaptors.login.LoginController;
import interface_adaptors.login.LoginIView;
import interface_adaptors.login.LoginPresenter;
import main_builders_directors.*;
import screens.*;
import use_cases.login.Login;
import use_cases.login.LoginInputBoundary;
import use_cases.login.LoginOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class Main {

    public static final int COLUMN_FORMATTER = 2;

    public static void main(String[] args) throws IOException, ParseException {


        JFrame application = new JFrame("Main Screen");

        CardLayout cardLayout = new CardLayout();
        JPanel allScreens = new JPanel(cardLayout);
        // makes the screen that will store ALL the SCREENS

        LoginOutputBoundary loginPresenter = new LoginPresenter();
        LoginInputBoundary login = new Login(loginPresenter);
        LoginController loginController = new LoginController(login);
        LoginIView login_screen = new LoginScreen(allScreens, loginController);
        loginPresenter.setScreen(login_screen);
        allScreens.add((JPanel) login_screen,"Login");


        MainEmployeeScreen mainMenu = new MainEmployeeScreen(allScreens);
        allScreens.add(mainMenu, "Main");
        // creates the main menu

        InitializerController initializer = new InitializerController();
        initializer.InitializeInventory();

        // ============= CHANGES START HERE ==============:
        List<FeatureBuilder> builders = new ArrayList<>();
        // creates a list of directors to call
        builders.add(new AddFeatureBuilder());
        builders.add(new ReturnFeatureBuilder());
        builders.add(new RemoveFeatureBuilder());
        builders.add(new SearchFeatureBuilder());
        builders.add(new SearchCatFeatureBuilder());
        builders.add(new ImportFeatureBuilder());
        builders.add(new ExportFeatureBuilder());
        builders.add(new UpdateFeatureBuilder());
        builders.add(new HistoryFeatureBuilder());
        builders.add(new SalesReporterFeatureBuilder());

        // ...
        // for all the different functions, all you have to do is add a new builder here

        FeatureDirector director = new FeatureDirector();

        int featureCount = 0;
        ArrayList<JButton> buttonList = new ArrayList<>();
        for (FeatureBuilder builder: builders){
            // polymorphism: each createArchitecture method for each director creates different architecture
            director.setBuilder(builder);
            JPanel screen = director.createFeature(allScreens);
            allScreens.add(screen, builder.getScreenName());

            buttonList.add(mainMenu.createMenuButton(builder.getScreenName()));
            featureCount += 1;
            if ((featureCount % COLUMN_FORMATTER) == 0){
                mainMenu.packButtons(buttonList);
                buttonList = new ArrayList<>();
            }
        }
        buttonList.add(mainMenu.createLogOut());
        mainMenu.packButtons(buttonList);


        // ============= CHANGES ARE DONE HERE =================;

        application.add(allScreens);
        cardLayout.show(allScreens, "Login");
        // the first screen that is shown is the main menu

        application.pack();
        application.setVisible(true);
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // the JFrame becomes visible!
    }
}

