package use_cases.search_sort_use_case;

import entities.Item;
import entities.ItemInterface;
import entities.TempDataStorage;
import interface_adaptors.search_sort.SearchPresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.search_sort.SearchOutputBoundary;

import java.util.*;


public class TestSearch {

    @Test
    void searchedItemNotFound(){
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        Item item = new Item("1","I", 30, 2, category,
                date, "second floor");
        Map<String, ItemInterface> map = new HashMap<String, ItemInterface>();
        map.put("10077", item);
        TempDataStorage.setTempDataStorage(map);
        SearchOutputBoundary presenter = new SearchPresenter();
        ArrayList<Object> tempArray = new ArrayList<>();
        tempArray.add(false);
        tempArray.add(item);
        Assertions.assertEquals(presenter.prepareSuccess(tempArray), "Item was not found");
    }
    @Test
    void searchedItemFound(){
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        Item item = new Item("1","I", 30.0, 2, category,
                date, "second floor");
        Map<String, ItemInterface> map = new HashMap<String, ItemInterface>();
        map.put("10077", item);
        TempDataStorage.setTempDataStorage(map);
        SearchOutputBoundary presenter = new SearchPresenter();
        ArrayList<Object> tempArray = new ArrayList<>();
        tempArray.add(true);
        tempArray.add(item);
        Assertions.assertEquals(presenter.prepareSuccess(tempArray), "Item:" + "I" + ", Cost:" + 30.0 +
                ", Quantity:" + 2 + ", Storage Location:" +
                "second floor");
    }
}
