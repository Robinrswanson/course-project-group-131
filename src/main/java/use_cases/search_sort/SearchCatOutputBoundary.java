package use_cases.search_sort;

import entities.Item;
import interface_adaptors.search_sort.SearchCategoryIView;
import interface_adaptors.search_sort.SearchIView;

import java.util.ArrayList;

public interface SearchCatOutputBoundary {
    void setScreen(SearchCategoryIView screen);

    void prepareSuccess(ArrayList<Item> data);
}
