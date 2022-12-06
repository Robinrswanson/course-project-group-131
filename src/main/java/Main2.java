import entities.Item;
import entities.TempDataStorage;
import interface_adaptors.show_history.ShowHistoryController;
import interface_adaptors.show_history.ShowHistoryFileDataAccess;
import interface_adaptors.arr.*;
import interface_adaptors.show_history.ShowHistoryView;
import interface_adaptors.update_price.UpdateController;
import interface_adaptors.update_price.UpdateIview;
import interface_adaptors.update_price.UpdatePresenter;
import screens.*;
import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARROutputBoundary;
import use_cases.arr.Add;
import use_cases.show_history_use_case.*;
import use_cases.update_price.UpdatePrice;
import use_cases.update_price.UpdatePriceInputBoundary;
import use_cases.update_price.UpdatePriceOutputBoundary;
import screens.ShowHistoryScreen;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws IOException {

        createTestInventory();
        // creates a test inventory

        JFrame application = new JFrame("Main Screen");

        CardLayout cardLayout = new CardLayout();
        JPanel allScreens = new JPanel(cardLayout);
        // makes the screen that will store ALL the SCREENS

        JPanel mainMenu = new MainEmployeeScreen(allScreens);
        // creates the main menu

        ArrayList<FilterScreenInputData> lst = makeFilterScreenSample();
        JPanel sortScreen = new FilterScreen(allScreens, lst, "Displaying all Items");
        // creates the sort screen, based on the test data in lst

        // addScreen is all about "add quantity" function.
        ARROutputBoundary addPresenter = new AddPresenter();
        ARRInputBoundary addUseCase = new Add(addPresenter);
        AddController addController = new AddController(addUseCase);
        ARRIView addScreen = new AddScreen(allScreens, addController);
        addPresenter.setScreen(addScreen);
        // instantiates the presenter, the use case, the controller AND the screen
        // the reason why this is so much larger than the previous is because mainMenu and sortScreen have limited functionality
        // we will DEFINITELY need factories for this later lmao

        // updateScreen is all about "update price" function.
        UpdatePriceOutputBoundary updatePresenter = new UpdatePresenter();
        UpdatePriceInputBoundary updateUseCase = new UpdatePrice(updatePresenter);
        UpdateController updateController = new UpdateController(updateUseCase);
        UpdateIview updateScreen = new UpdateScreen(allScreens, updateController);
        updatePresenter.setScreen(updateScreen);
        // similar to above
        //ShowHistoryScreen is all about "ShowHistory"function.
        ShowHistoryDsGateway dsGateway = new ShowHistoryFileDataAccess();
        ShowHistoryPresenter presenter = new ShowHistoryResponseFormatter();
        ShowHistoryInputBoundary inputBoundary = new ShowHistoryInteractor(dsGateway,presenter);
        ShowHistoryController controller = new ShowHistoryController(inputBoundary);
        ShowHistoryScreen historyScreen = new ShowHistoryScreen(controller,allScreens);
        presenter.setScreen(historyScreen);

        // creates sales report screen


        // all the screens created so far are added to the allScreens storage
        allScreens.add(mainMenu, "Main");
        allScreens.add(sortScreen, "Display/Filter Items");
        allScreens.add((JPanel) addScreen, ARRIView.ADD_SCREEN_NAME_CONSTANT);
        allScreens.add((JPanel) updateScreen, UpdateIview.UPDATE_SCREEN_NAME_CONSTANT);
        allScreens.add((JPanel) historyScreen, ShowHistoryView.SHOW_HISTORY_NAME_CONSTANT);


        application.add(allScreens);
        cardLayout.show(allScreens, "Main");
        // the first screen that is shown is the main menu

        application.pack();
        application.setVisible(true);
        // the JFrame becomes visible!
    }

    private static void createTestInventory() {

        // very crude... will definitely want to import from an actual file later

        List<String> bananaCategories = new ArrayList<>();
        bananaCategories.add("Fruit");
        // Item banana = new Item("10077", 3.5, 5, bananaCategories, new Date(), "Aisle 5");
        Map<String, Item> map = new HashMap<>();
        // map.put("10077", banana);
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

