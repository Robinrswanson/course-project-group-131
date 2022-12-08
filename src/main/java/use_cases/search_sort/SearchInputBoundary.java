package use_cases.search_sort;

import java.util.ArrayList;

public interface SearchInputBoundary {
    /**
     * Searches for the item using the given serial number, with the serial number represented as a Sting
     * @param serialNumber represents the serial number that will be used as the search condition
     */
    void searchItem(String serialNumber);
}
