package use_cases.search_sort_use_case;

import entities.Item;
import entities.ItemInterface;
import entities.TempDataStorage;
import interface_adaptors.search_sort.SortPresenter;
import org.junit.jupiter.api.Test;
import use_cases.search_sort.SortOutputBoundary;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TestSort {
    @Test
    void sortItemFound(){
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        Item item = new Item("1","I", 30, 2, category,
                date, "second floor");
        Map<String, ItemInterface> map = new HashMap<String, ItemInterface>();
        map.put("10077", item);
        TempDataStorage.setTempDataStorage(map);
        ArrayList<ItemInterface> tempArray = new ArrayList<>();
        SortOutputBoundary presenter = new SortPresenter();
        assertEquals(presenter.prepareSuccess(tempArray), "Items: " + "[]");
    }
}
