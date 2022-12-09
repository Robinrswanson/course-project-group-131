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

    /**
     * Tests for failure when no item with a matching category is found (when there is one item in the TempDataStorage)
     */
    @Test
    void categoryNotFoundOneTotalItem(){
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

    /**
     * Tests for success when one item is found, and total items is 1
     */
    @Test
    void categoryFoundOneTotalItem(){
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

    /**
     * Tests for success, when multiple items with the category are found
     */
    @Test
    void categoryFoundMultipleItems(){
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        ItemInterface item = new Item("1","I", 30, 2, category,
                date, "second floor");
        ItemInterface item2 = new Item("2","J", 25, 2, category,
                date, "second floor");
        ItemInterface item3 = new Item("3","K", 35, 6, category,
                date, "second floor");
        Map<String, ItemInterface> map = new HashMap<String, ItemInterface>();
        map.put("10077", item);
        map.put("10088", item2);
        map.put("10094", item3);
        TempDataStorage.setTempDataStorage(map);

        SearchCatOutputBoundary presenter = new SearchCatOutputBoundary(){

            @Override
            public void setScreen(SearchCategoryIView screen) {
                fail();
            }
            @Override
            public void prepareSuccess(ArrayList<ItemInterface> data) {
                assertEquals(data.size(), 3);

            }
        } ;

        SearchCatInputBoundary interactor = new SearchCategory(presenter);
        interactor.SearchCategories(new String[]{"Fruits"});

    }

    /**
     * Tests for failure, when no items with the category are found when there are 3 items
     */
    void categoryNotFoundMultipleItems(){
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        ItemInterface item = new Item("1","I", 30, 2, category,
                date, "second floor");
        ItemInterface item2 = new Item("2","J", 25, 2, category,
                date, "second floor");
        ItemInterface item3 = new Item("3","K", 35, 6, category,
                date, "second floor");
        Map<String, ItemInterface> map = new HashMap<String, ItemInterface>();
        map.put("10077", item);
        map.put("10088", item2);
        map.put("10094", item3);
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

    /**
     * Tests for one item being returned, when there are 3 total items.
     */
    void categoryFoundOneOfMultiple(){
        Date date = new Date(2023-01-22);
        List<String> category = Arrays.asList("Fruits");
        List<String> category2 = Arrays.asList("Veggies");
        ItemInterface item = new Item("1","I", 30, 2, category,
                date, "second floor");
        ItemInterface item2 = new Item("2","J", 25, 2, category2,
                date, "second floor");
        ItemInterface item3 = new Item("3","K", 35, 6, category2,
                date, "second floor");
        Map<String, ItemInterface> map = new HashMap<String, ItemInterface>();
        map.put("10077", item);
        map.put("10088", item2);
        map.put("10094", item3);
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
