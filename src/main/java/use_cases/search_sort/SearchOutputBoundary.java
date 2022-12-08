package use_cases.search_sort;

import entities.Item;
import interface_adaptors.search_sort.SearchIView;

import java.util.ArrayList;
import java.util.List;

public interface SearchOutputBoundary {

    void setScreen(SearchIView screen);

    String prepareSuccess(ArrayList<Object> data); // display the item if successful

}
