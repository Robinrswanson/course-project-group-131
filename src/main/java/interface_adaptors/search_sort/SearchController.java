package interface_adaptors.search_sort;

import use_cases.search_sort.SearchInputBoundary;


public class SearchController {
    private final SearchInputBoundary Search;

    public SearchController(SearchInputBoundary Search) {this.Search = Search;}

    /**
     * The controller packages the data and sends it off to the Search Use Case
     * @param serialNum the serial number of the item
     */
    public void searchItem(String serialNum) {

        Search.searchItem(serialNum);
    }
}
