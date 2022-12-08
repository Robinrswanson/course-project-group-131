package use_cases.arr_use_case;

import interface_adaptors.arr.ARRIView;
import interface_adaptors.update_price.UpdatePresenter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import entities.*;
import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARRInputData;
import use_cases.arr.ARROutputBoundary;

import java.util.*;

// This test is aimed to test the situation where updating price is successfully be done.
public class AddInteractorFailureSerialNumberTest {
    UpdatePresenter presenter = new UpdatePresenter();

    @Test
    void changeItemQuantity() {
        // Initialize an item class
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        Item item = new Item("10077","Banana", 30, 2, category,
                date, "second floor");
        Map<String, Item> map = new HashMap<String, Item>();
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
                fail();
            }

            @Override
            public void prepareFailure(int error) {
                assertEquals(2, item.getQuantity());
                assertNotEquals(7, item.getQuantity());
            }
        };
        ARRInputBoundary interactor = new use_cases.arr.Add(presenter);

        // Create input data
        ARRInputData input = new ARRInputData("10078", 5);

        // Run the use case
        interactor.changeItemQuantity(input);

    }
}
