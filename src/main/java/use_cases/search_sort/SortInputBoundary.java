package use_cases.search_sort;

import java.text.ParseException;

public interface SortInputBoundary {

    void executeSort(String[] searchParameters) throws ParseException;

}
