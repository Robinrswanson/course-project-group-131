package interface_adaptors.search_sort;

import entities.Item;
import use_cases.search_sort.SortOutputBoundary;

import java.util.ArrayList;

public class SortPresenter implements SortOutputBoundary {
    SortIView screen;
    @Override
    public void setScreen(SortIView screen) {this.screen = screen; }

    @Override
    public String prepareSuccess(ArrayList<Item> data) {
        ArrayList<String> itemNames = new ArrayList<>();
        for (Item item: data)
        {itemNames.add(item.getName());}
        return "Items: " + itemNames;
    }
}
