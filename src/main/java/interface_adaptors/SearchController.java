package interface_adaptors;

import entities.Search;

import java.util.ArrayList;

public class SearchController {
    private final entities.Search Search;

    public SearchController(Search Search) {this.Search = Search;}

    /**
     * The controller packages the data and sends it off to the Search Use Case
     * @param serialNum the serial number of the item
     * @return an ArrayList that contains a boolean if it was successful and the item for the View to present.
     */
    public ArrayList<Object> searchItem(String serialNum) {

        return Search.searchItem(serialNum);
    }
}
