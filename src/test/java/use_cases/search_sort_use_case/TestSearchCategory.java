package use_cases.search_sort_use_case;

import entities.Item;
import entities.ItemInterface;
import entities.TempDataStorage;
import interface_adaptors.search_sort.SearchCategoryIView;
import interface_adaptors.search_sort.SearchCategoryPresenter;
import interface_adaptors.search_sort.SearchIView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.search_sort.*;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestSearchCategory {

    @Test
    void categoryNotFound(){
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        ItemInterface item = new Item("1","I", 30, 2, category,
                date, "second floor");
        Map<String, ItemInterface> map = new HashMap<String, ItemInterface>();
        map.put("10077", item);
        TempDataStorage.setTempDataStorage(map);

        SearchCatOutputBoundary presenter = new SearchCatOutputBoundary(){

            @Override
            public void setScreen(SearchCategoryIView screen) {
                fail();
            }
            @Override
            public void prepareSuccess(ArrayList<ItemInterface> data) {
                assertEquals(data.size(), 0);

            }
        } ;

        SearchCatInputBoundary interactor = new SearchCategory(presenter);
        interactor.SearchCategories(new String[]{"Veggies"});


    }
    @Test
    void categoryFound(){
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        ItemInterface item = new Item("1","I", 30, 2, category,
                date, "second floor");
        Map<String, ItemInterface> map = new HashMap<String, ItemInterface>();
        map.put("10077", item);
        TempDataStorage.setTempDataStorage(map);

        SearchCatOutputBoundary presenter = new SearchCatOutputBoundary(){

            @Override
            public void setScreen(SearchCategoryIView screen) {
                fail();
            }
            @Override
            public void prepareSuccess(ArrayList<ItemInterface> data) {
                assertEquals(data.size(), 1);

            }
        } ;

        SearchCatInputBoundary interactor = new SearchCategory(presenter);
        interactor.SearchCategories(new String[]{"Fruits"});


    }
}
