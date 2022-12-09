package use_cases.add;

import entities.Item;
import entities.ItemInterface;
import entities.TempDataStorage;
import entities.User;
import interface_adaptors.arr.ARRIView;
import interface_adaptors.update_price.UpdatePresenter;
import org.junit.jupiter.api.Test;
import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARRInputData;
import use_cases.arr.ARROutputBoundary;
import use_cases.arr.Add;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

// This test is aimed to test the situation where adding items is successfully be done.
public class AddInteractorSuccessfulTest {

    /**
     * Successful test, where user enters a valid serial number and quantity, and the quantity is changed
     */
    @Test
    void addItem() {
        // Initialize an item class
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        ItemInterface item = new Item("10077","I hate writing test", 30, 2, category,
                date, "second floor");
        Map<String, ItemInterface> map = new HashMap<String, ItemInterface>();
        map.put("10077", item);
        TempDataStorage.setTempDataStorage(map);

        // This creates an anonymous implementing class for the Output Boundary.
        ARROutputBoundary presenter = new ARROutputBoundary() {
            @Override
            public void setScreen(ARRIView screen){
                // This method is just for setting screen. No need to test it.
                fail();
            }

            @Override
            public void prepareSuccess(ARRInputData data) {
                // Check that the Output Data and associated changes
                // are correct
                assertEquals(7, item.getQuantity()); // expected 7, got 30
                assertNotEquals(2, item.getQuantity());
            }

            @Override
            public void prepareFailure(int error) {
                fail();
            }
        };
        ARRInputBoundary interactor = new Add(presenter);

        // Create input data
        ARRInputData input = new ARRInputData("10077", 5);

        // Run the use case
        interactor.changeItemQuantity(input);

    }
}
