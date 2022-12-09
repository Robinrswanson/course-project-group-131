package interface_adaptors.search_sort;

import entities.Item;
import entities.ItemInterface;
import use_cases.search_sort.SortOutputBoundary;

import java.util.ArrayList;

public class SortPresenter implements SortOutputBoundary {
    SortIView screen;
    @Override
    public void setScreen(SortIView screen) {this.screen = screen; }

    @Override
    public String prepareSuccess(ArrayList<ItemInterface> data) {
        ArrayList<String> itemNames = new ArrayList<>();
        for (ItemInterface item: data)
        {itemNames.add(item.getName());}
        return "Items: " + itemNames;
    }
}
