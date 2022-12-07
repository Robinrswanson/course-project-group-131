import entities.Item;
import entities.TempDataStorage;
import interface_adaptors.inventory_initializer.InitializerController;
import main_builders_directors.*;
import screens.*;
import use_cases.import_inventory.Import;
import use_cases.initializer.InitializeUseCase;
import use_cases.initializer.InitializerInputBoundary;

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

        JPanel login_screen = new LoginScreen(allScreens);
        allScreens.add(login_screen,"Login");

        String userName = ((LoginScreen) login_screen).getUserName();

        JPanel mainMenu = new MainEmployeeScreen(allScreens);
        allScreens.add(mainMenu, "Main");
        // creates the main menu

        InitializerInputBoundary initializeUseCase = new InitializeUseCase();
        InitializerController initializer = new InitializerController();

        initializer.InitializeInventory();

        // ============= CHANGES START HERE ==============:
        List<FeatureBuilder> builders = new ArrayList<>();
        // creates a list of directors to call
        builders.add(new AddFeatureBuilder(userName));
        builders.add(new UpdateFeatureBuilder());
        builders.add(new ExportFeatureBuilder());
        builders.add(new ImportFeatureBuilder());
        builders.add(new HistoryFeatureBuilder());
        builders.add(new ReturnFeatureBuilder(userName));
        builders.add(new RemoveFeatureBuilder(userName));
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
        Map<String, Item> map = new HashMap<>();
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

