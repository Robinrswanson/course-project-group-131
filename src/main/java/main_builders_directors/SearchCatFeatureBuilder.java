package main_builders_directors;

import interface_adaptors.search_sort.SearchCategoriesController;
import interface_adaptors.search_sort.SearchCategoryIView;
import interface_adaptors.search_sort.SearchCategoryPresenter;
import screens.SearchCategoryScreen;
import use_cases.search_sort.SearchCatInputBoundary;
import use_cases.search_sort.SearchCatOutputBoundary;
import use_cases.search_sort.SearchCategory;

import javax.swing.*;

public class SearchCatFeatureBuilder  implements FeatureBuilder{

    private SearchCatOutputBoundary searchPresenter;
    private SearchCatInputBoundary searchUseCase;
    private SearchCategoriesController searchController;
    private SearchCategoryIView searchScreen;


    public SearchCatFeatureBuilder()
    {

    }

    /**
     * builds the Presenter by instantiating a new searchPresenter
     */
    @Override
    public void buildPresenter() {
        searchPresenter = new SearchCategoryPresenter();
    }

    /**
     * builds the use case
     */
    @Override
    public void buildUseCase() {
        searchUseCase = new SearchCategory(searchPresenter);
    }

    /**
     * builds the controller
     */
    @Override
    public void buildController() {
        searchController = new SearchCategoriesController(searchUseCase);
    }

    /** builds the screen
     *
     * @param allScreens the JPanel containing all the screens
     */
    @Override
    public void buildScreen(JPanel allScreens) {
        searchScreen = new SearchCategoryScreen(allScreens, searchController);
    }

    /**
     * Sets the screen corresponding to the presenter
     */
    @Override
    public void presenterSetScreen() {
        searchPresenter.setScreen(searchScreen);
    }

    /**
     * returns the screen made by the process above
     */
    @Override
    public JPanel getScreen() {
        return (JPanel) searchScreen;
    }

    @Override
    public String getScreenName() {
        return SearchCategoryIView.SEARCH_SCREEN_NAME_CONSTANT;
    }

}
