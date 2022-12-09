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

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

// This test is aimed to test a situation where adding is unsuccessful
public class AddInteractorFailSerialNumTest {
    UpdatePresenter presenter = new UpdatePresenter();

    /**
     * Tests for failure when an incorrect serial number is entered
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
        User.setStatus(true);

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
                fail();
            }

            @Override
            public void prepareFailure(int error) {
                assertEquals(2, item.getPrice());
                assertNotEquals(7, item.getPrice());
            }
        };
        ARRInputBoundary interactor = new use_cases.arr.Add(presenter);

        // Create input data
        ARRInputData input = new ARRInputData("10078", 5);

        // Run the use case
        interactor.changeItemQuantity(input);

    }
}
