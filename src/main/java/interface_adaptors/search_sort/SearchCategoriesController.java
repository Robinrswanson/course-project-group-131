package interface_adaptors.search_sort;

import use_cases.search_sort.SearchCatInputBoundary;


public class SearchCategoriesController {
    private final SearchCatInputBoundary SearchCat;

    public SearchCategoriesController(SearchCatInputBoundary SearchCategory) {this.SearchCat = SearchCategory;}

    public void searchCategory(String[] categories) {
        SearchCat.SearchCategories(categories);
    }
}
