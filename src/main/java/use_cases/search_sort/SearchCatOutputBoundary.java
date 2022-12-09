package use_cases.search_sort;

import entities.ItemInterface;
import interface_adaptors.search_sort.SearchCategoryIView;

import java.util.ArrayList;

public interface SearchCatOutputBoundary {
    void setScreen(SearchCategoryIView screen);

    void prepareSuccess(ArrayList<ItemInterface> data);
}
