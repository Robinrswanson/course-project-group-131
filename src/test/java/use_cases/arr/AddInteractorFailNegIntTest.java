package use_cases.arr;

import entities.Item;
import entities.ItemInterface;
import entities.TempDataStorage;
import entities.User;
import interface_adaptors.arr.ARRIView;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

// This test is aimed to test the situation where adding items fails because a negative integer was entered.
public class AddInteractorFailNegIntTest {

    /**
     * Tests for failure when a negative integer is entered in by the user.
     * Add is very similar to return, so return does not need to be tested more
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
                assertEquals(2, item.getQuantity()); // got 30
                assertNotEquals(0, item.getQuantity());
            }
        };
        ARRInputBoundary interactor = new use_cases.arr.Add(presenter);

        // Create input data
        ARRInputData input = new ARRInputData("10078", -2);

        // Run the use case
        interactor.changeItemQuantity(input);

    }
}
