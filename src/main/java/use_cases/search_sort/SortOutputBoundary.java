package use_cases.search_sort;

import entities.Item;
import entities.ItemInterface;
import interface_adaptors.search_sort.SortIView;

import java.util.ArrayList;

public interface SortOutputBoundary {
    void setScreen(SortIView screen);

    String prepareSuccess(ArrayList<ItemInterface> data);
}
