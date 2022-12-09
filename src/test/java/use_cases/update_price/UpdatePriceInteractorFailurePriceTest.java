
package use_cases.update_price;

import interface_adaptors.update_price.UpdateIview;
import interface_adaptors.update_price.UpdatePresenter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import entities.*;

import java.util.*;

// This test is aimed to test the situation where updating price is not successfully be done
// because the price entered is not valid.
public class UpdatePriceInteractorFailurePriceTest {
    UpdatePresenter presenter = new UpdatePresenter();

    /**
     * Tests for failure when a negative price is entered
     */
    @Test
    void updateItem() {
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
        UpdatePriceOutputBoundary presenter = new UpdatePriceOutputBoundary() {
            @Override
            public void setScreen(UpdateIview screen){
                // This method is just for setting screen. No need to test it.
                assertTrue(true);
            }

            @Override
            public void prepareSuccess(UpdatePriceInputData data) {
                // Check that the Output Data and associated changes
                // are correct
                assertTrue(true);
            }

            @Override
            public void prepareFailure(int error) {
                assertEquals(30, item.getPrice());
                assertNotEquals(-20, item.getPrice());
            }
        };
        UpdatePriceInputBoundary interactor = new use_cases.update_price.UpdatePrice(presenter);

        // Create input data: the price entered here is negative!
        UpdatePriceInputData input = new UpdatePriceInputData("10077", -20);

        // Run the use case
        interactor.updateItem(input);

    }
}

