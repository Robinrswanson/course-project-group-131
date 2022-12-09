package use_cases.arr;

import entities.Item;
import entities.ItemInterface;
import entities.TempDataStorage;
import interface_adaptors.arr.RemovePresenter;
import interface_adaptors.arr.ReturnPresenter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import java.util.HashMap;
import java.util.Map;

public class ARRTest {
    @BeforeEach
     void setUpInventory()
    {
        Item example_item_1 = new Item("1", "Ice Cream", 1.00, 10, null, null, "Shelf");
        Item example_item_2 = new Item("2", "iPad", 2.00, 10, null, null, "Shelf");
        Item example_item_3 = new Item("3", "Tomato", 3.00, 10, null, null, "Shelf");
        Item example_item_4 = new Item("4", "Cutting Board", 20.00, 10, null, null, "Shelf");
        Map<String, ItemInterface> sampleMap;
        sampleMap = new HashMap<>();
        sampleMap.put("1", example_item_1);
        sampleMap.put("2", example_item_2);
        sampleMap.put("3", example_item_3);
        sampleMap.put("4", example_item_4);
        TempDataStorage.setTempDataStorage(sampleMap);

    }

    @Test
    public void testValidReturn()
    {
        ARROutputBoundary presenter = new ReturnPresenter();
        ARRInputBoundary returnUseCase = new ReturnUseCase(presenter);
        ARRInputData data = new ARRInputData("4", 5);
        returnUseCase.changeItemQuantity(data);
        int actual = TempDataStorage.getItem("4").getQuantity();
        int expected = 15;
        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void testValidRemove() {
        ARROutputBoundary presenter = new RemovePresenter();
        ARRInputBoundary removeUseCase = new RemoveUseCase(presenter);
        ARRInputData data = new ARRInputData("2", 5);
        removeUseCase.changeItemQuantity(data);
        int actual = TempDataStorage.getItem("2").getQuantity();
        int expected = 5;
        Assertions.assertEquals(actual, expected);

    }


}
