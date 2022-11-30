import entities.Item;
import entities.TempDataStorage;
import interface_adaptors.*;
import use_cases.*;
import screens.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws IOException {
        String file = "src\\main\\java\\Database\\Sample Data - Sample Item.csv";
        Map<String, Item> inventory = new HashMap<String, Item>();

        ImportPresenter presenter = new ImportPresenter();
        Import importer = new Import(presenter);
        GatewayReader reader = new GatewayReader(file);
        java.util.List<String[]> data2 = reader.getData();
        ImportDS data = new ImportDS(data2, file);
        data2.remove(0);

        for (String[] row: data2) {
            List<String> lst = new ArrayList<String>();
            Date date = new Date();
            Item item = new Item(row[1], Double.valueOf(row[2]), Integer.valueOf(row[3]), lst, date, "");
            inventory.put(row[0], item);
        }
        TempDataStorage.setTempDataStorage(inventory);

        Collection<Item> datalst = TempDataStorage.getInventory().values();
        for (Item item: datalst
        ) {
            System.out.println(item.getName() + ", " + item.getQuantity());
        }

        System.out.println("-----------------------");

        importer.importDatabase(new GatewayReader(file));
        Collection<Item> datalst2 = TempDataStorage.getInventory().values();
        for (Item item: datalst2
        ) {
            System.out.println(item.getName() + ", " + item.getQuantity());
        }

        ArrayList<FilterScreenDS> lst = makeFilterScreenSample();

        JFrame application = new JFrame("Main Screen");

        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        JPanel screen1 = new MainManagerScreen(screens);
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

        // screen5 is all about "import" function.
        ImportOutputBoundary importPresenter = new ImportPresenter();
        ImportInputBoundary ImportUseCase = new Import(importPresenter);
        ImportController ImportController = new ImportController(ImportUseCase);
        JPanel screen5 = new ImportScreen(screens, ImportController);

        // screen6 is all about "export" function.
        ExportOutputBoundary exportPresenter = new ExportPresenter();
        ExportInputBoundary exportUseCase = new Export(exportPresenter);
        ExportController exportController = new ExportController(exportUseCase);
        JPanel screen6 = new ExportScreen(screens, exportController);

        screens.add(screen1, "Main");
        screens.add(screen2, "Display/Filter Items");
        screens.add(screen3, "Add Items");
        screens.add(screen4, "Update Price");
        screens.add(screen5, "Import");
        screens.add(screen6, "Export");

        application.add(screens);
        cardLayout.show(screens, "Main");

        application.pack();
        application.setVisible(true);
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

