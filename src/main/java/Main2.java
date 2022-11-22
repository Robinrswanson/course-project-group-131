import interface_adaptors.*;
import use_cases.*;
import screens.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {

        ArrayList<FilterScreenDS> lst = makeFilterScreenSample();

        JFrame application = new JFrame("Main Screen");

        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        JPanel screen1 = new MainEmployeeScreen(screens);
        JPanel screen2 = new FilterScreen(screens, lst, "Displaying all Items");

        // screen3 is all about "add quantity" function.
        AddOutputBoundary addPresenter = new AddPresenter();
        AddInputBoundary addUseCase = new AddUseCase(addPresenter);
        AddController addController = new AddController(addUseCase);
        JPanel screen3 = new AddScreen(screens, addController);


        // screen4 is all about "update price" function.
        UpdateOutputBoundary updatePresenter = new UpdatePresenter();
        UpdateInputBoundary updateUseCase = new UpdateUseCase(updatePresenter);
        UpdateController updateController = new UpdateController(updateUseCase);
        JPanel screen4 = new UpdateScreen(screens, updateController);

        screens.add(screen1, "Main");
        screens.add(screen2, "Display/Filter Items");
        screens.add(screen3, "Add Items");
        screens.add(screen4, "Update Price");

        application.add(screens);
        cardLayout.show(screens, "Main");

        application.pack();
        application.setVisible(true);
    }

    private static ArrayList<FilterScreenDS> makeFilterScreenSample() {
        ArrayList<FilterScreenDS> lst = new ArrayList<>();
        lst.add(new FilterScreenDS("Pineapples", "274783"));
        lst.add(new FilterScreenDS("Oranges", "658424"));
        lst.add(new FilterScreenDS("Coconuts", "585341"));
        lst.add(new FilterScreenDS("Bananas", "234364"));
        lst.add(new FilterScreenDS("Apples", "076584"));
        lst.add(new FilterScreenDS("Grapes", "163854"));
        lst.add(new FilterScreenDS("Peaches", "957832"));
        lst.add(new FilterScreenDS("Mangoes", "371234"));
        lst.add(new FilterScreenDS("Kiwis", "068974"));
        lst.add(new FilterScreenDS("Apricots", "453123"));
        lst.add(new FilterScreenDS("Blueberries", "079898"));
        lst.add(new FilterScreenDS("Strawberries", "333222"));
        lst.add(new FilterScreenDS("Blackberries", "113244"));
        lst.add(new FilterScreenDS("Raspberries", "104320"));
        return lst;
    }
}

