package use_cases.search_sort_use_case;

import entities.Item;
import entities.ItemInterface;
import entities.TempDataStorage;
import interface_adaptors.search_sort.SearchIView;
import interface_adaptors.search_sort.SearchPresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.search_sort.Search;
import use_cases.search_sort.SearchInputBoundary;
import use_cases.search_sort.SearchOutputBoundary;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class TestSearch {

    @Test
    void searchedItemNotFound(){
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        ItemInterface item = new Item("1","I", 30, 2, category,
                date, "second floor");
        Map<String, ItemInterface> map = new HashMap<>();
        map.put("10077", item);
        TempDataStorage.setTempDataStorage(map);

        SearchOutputBoundary presenter = new SearchOutputBoundary(){

            @Override
            public void setScreen(SearchIView screen) {
                fail();
            }

            @Override
            public void prepareSuccess(ArrayList<Object> data) {
                assertEquals(data.get(0), false);
            }
        } ;

        SearchInputBoundary interactor = new Search(presenter);
        interactor.searchItem("10078");

    }
    @Test
    void searchedItemFound(){
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        ItemInterface item = new Item("1","I", 30, 2, category,
                date, "second floor");
        Map<String, ItemInterface> map = new HashMap<>();
        map.put("10077", item);
        TempDataStorage.setTempDataStorage(map);

        SearchOutputBoundary presenter = new SearchOutputBoundary(){

            @Override
            public void setScreen(SearchIView screen) {
                fail();
            }

            @Override
            public void prepareSuccess(ArrayList<Object> data) {
                assertEquals(data.get(1), map.get("10077"));
            }
        } ;

        SearchInputBoundary interactor = new Search(presenter);
        interactor.searchItem("10077");

    }
}
