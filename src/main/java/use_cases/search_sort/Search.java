package use_cases.search_sort;

import entities.TempDataStorage;

import java.util.*;

public class Search implements SearchInputBoundary {

    private final SearchOutputBoundary presenter;
    public Search(SearchOutputBoundary presenter) {this.presenter = presenter;}

    /**
     * The Search use case. Once it executes, it tells the presenter to update the information
     * @param serialNumber represents the serial number that will be used as the search condition
     */
    public void searchItem(String serialNumber){
        ArrayList<Object> searchedItem = new ArrayList<>();

        if (TempDataStorage.hasItem(serialNumber)){
            searchedItem.add(true);
            searchedItem.add(TempDataStorage.getItem(serialNumber));
            presenter.prepareSuccess(searchedItem);}
        else {
            searchedItem.add(false);
            presenter.prepareSuccess(searchedItem);}

    }

}
