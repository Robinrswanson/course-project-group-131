package use_cases.add;

import interface_adaptors.arr.ARRIView;
import interface_adaptors.update_price.UpdateIview;
import interface_adaptors.update_price.UpdatePresenter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import entities.*;
import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARRInputData;
import use_cases.arr.ARROutputBoundary;

import java.util.*;

// This test is aimed to test the situation where updating price is successfully be done.
public class AddInteractorSuccessfulTest {
    UpdatePresenter presenter = new UpdatePresenter();

    @Test
    void updateItem() {
        // Initialize an item class
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        Item item = new Item("10077","I hate writing test", 30, 2, category,
                date, "second floor");
        Map<String, Item> map = new HashMap<String, Item>();
        map.put("10077", item);
        TempDataStorage.setTempDataStorage(map);
        User.setStatus(true);

        // This creates an anonymous implementing class for the Output Boundary.
        ARROutputBoundary presenter = new ARROutputBoundary() {
            @Override
            public void setScreen(ARRIView screen){
                // This method is just for setting screen. No need to test it.
                assertTrue(true);
            }

            @Override
            public void prepareSuccess(ARRInputData data) {
                // Check that the Output Data and associated changes
                // are correct
                assertEquals(20, item.getPrice());
                assertNotEquals(30, item.getPrice());
            }

            @Override
            public void prepareFailure(int error) {
                assertTrue(true);
            }
        };
        ARRInputBoundary interactor = new use_cases.arr.Add(presenter);

        // Create input data
        ARRInputData input = new ARRInputData("10077", 20);

        // Run the use case
        interactor.changeItemQuantity(input);

    }
}
