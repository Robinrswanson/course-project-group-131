import entities.Item;
import entities.ItemInterface;
import entities.TempDataStorage;
import interface_adaptors.inventory_initializer.InitializerController;
import interface_adaptors.login.LoginController;
import interface_adaptors.login.LoginIView;
import interface_adaptors.login.LoginPresenter;
import main_builders_directors.*;
import screens.*;
import use_cases.import_inventory.Import;
import use_cases.initializer.InitializeUseCase;
import use_cases.initializer.InitializerInputBoundary;
import use_cases.login.Login;
import use_cases.login.LoginInputBoundary;
import use_cases.login.LoginOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class Main3 {
    public static void main(String[] args) throws IOException, ParseException {

        createTestInventory();
        // creates a test inventory

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


        JPanel mainMenu = new MainEmployeeScreen(allScreens);
        allScreens.add(mainMenu, "Main");
        // creates the main menu

        InitializerController initializer = new InitializerController();
        initializer.InitializeInventory();

        // ============= CHANGES START HERE ==============:
        List<FeatureBuilder> builders = new ArrayList<>();
        // creates a list of directors to call
        builders.add(new AddFeatureBuilder());
        builders.add(new UpdateFeatureBuilder());
        builders.add(new ExportFeatureBuilder());
        builders.add(new ImportFeatureBuilder());
        builders.add(new HistoryFeatureBuilder());
        builders.add(new SalesReporterFeatureBuilder());
        builders.add(new SortFeatureBuilder());
        builders.add(new SearchCatFeatureBuilder());
        builders.add(new SearchFeatureBuilder());
        builders.add(new ReturnFeatureBuilder());
        builders.add(new RemoveFeatureBuilder());

        // ...
        // for all the different functions, all you have to do is add a new builder here

        FeatureDirector director = new FeatureDirector();

        for (FeatureBuilder builder: builders){
            // polymorphism: each createArchitecture method for each director creates different architecture
            director.setBuilder(builder);
            JPanel screen = director.createFeature(allScreens);
            allScreens.add(screen, builder.getScreenName());
        }
        // ============= CHANGES ARE DONE HERE =================;

        application.add(allScreens);
        cardLayout.show(allScreens, "Login");
        // the first screen that is shown is the main menu

        application.pack();
        application.setVisible(true);
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // the JFrame becomes visible!
    }

    private static void createTestInventory() {

        // very crude... will definitely want to import from an actual file later

        List<String> bananaCategories = new ArrayList<>();
        bananaCategories.add("Fruit");
        Item banana = new Item("10077", "Banana", 3.5, 5, bananaCategories, new Date(), "Aisle 5");
        Map<String, ItemInterface> map = new HashMap<>();
        map.put("10077", banana);
        TempDataStorage.setTempDataStorage(map);
    }

    private static ArrayList<FilterScreenInputData> makeFilterScreenSample() {

        // again... will want to import this data from a file later


        ArrayList<FilterScreenInputData> lst = new ArrayList<>();
        lst.add(new FilterScreenInputData("Pineapples", "274783"));
        lst.add(new FilterScreenInputData("Oranges", "658424"));
        lst.add(new FilterScreenInputData("Coconuts", "585341"));
        lst.add(new FilterScreenInputData("Bananas", "234364"));
        lst.add(new FilterScreenInputData("Apples", "076584"));
        lst.add(new FilterScreenInputData("Grapes", "163854"));
        lst.add(new FilterScreenInputData("Peaches", "957832"));
        lst.add(new FilterScreenInputData("Mangoes", "371234"));
        lst.add(new FilterScreenInputData("Kiwis", "068974"));
        lst.add(new FilterScreenInputData("Apricots", "453123"));
        lst.add(new FilterScreenInputData("Blueberries", "079898"));
        lst.add(new FilterScreenInputData("Strawberries", "333222"));
        lst.add(new FilterScreenInputData("Blackberries", "113244"));
        lst.add(new FilterScreenInputData("Raspberries", "104320"));
        return lst;
    }
}

