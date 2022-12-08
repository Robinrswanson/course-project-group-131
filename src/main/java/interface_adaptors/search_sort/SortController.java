package interface_adaptors.search_sort;

import use_cases.search_sort.SortInputBoundary;

import java.text.ParseException;

public class SortController {
    private final SortInputBoundary Sort;

    public SortController(SortInputBoundary Sort){this.Sort = Sort;}

    public void executeSort(String searchParameters) throws ParseException {
        // TODO have this operate on the list to configure correctly
        //searchParameter is a list of list where the inner list contains a string at index 0 that denotes the type
        // and a value at index 1 to be used for the search
        // and a value at index 2 to be used for the search (higher, lower, or equal)
        // Consider changing the list to a class
        // Could be extended to find ranges by having a class that finds the overlap between higher and lower.
        String[] tempArray = searchParameters.split(",");


        Sort.executeSort(tempArray);}
}
