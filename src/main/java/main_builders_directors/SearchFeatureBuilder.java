package main_builders_directors;

import interface_adaptors.Search.SearchIView;
import interface_adaptors.Search.searchController;
import interface_adaptors.Search.searchPresenter;
import interface_adaptors.search_sort.SearchController;
import interface_adaptors.search_sort.SearchIView;
import interface_adaptors.search_sort.SearchPresenter;
import screens.SearchScreen;
import screens.searchScreen;
import use_cases.Search.SearchOutputBoundary;
import use_cases.Search.search;
import use_cases.search_sort.Search;
import use_cases.search_sort.SearchInputBoundary;
import use_cases.search_sort.SearchOutputBoundary;

import javax.swing.*;

public class SearchFeatureBuilder implements FeatureBuilder {

    private SearchOutputBoundary searchPresenter;
    private SearchInputBoundary searchUseCase;
    private SearchController searchController;
    private SearchIView searchScreen;


    public SearchFeatureBuilder()
    {

    }

    /**
     * builds the Presenter by instantiating a new searchPresenter
     */
    @Override
    public void buildPresenter() {
        searchPresenter = new SearchPresenter();
    }

    /**
     * builds the use case
     */
    @Override
    public void buildUseCase() {
        searchUseCase = new Search(searchPresenter);
    }

    /**
     * builds the controller
     */
    @Override
    public void buildController() {
        searchController = new SearchController(searchUseCase);
    }

    /** builds the screen
     *
     * @param allScreens the JPanel containing all the screens
     */
    @Override
    public void buildScreen(JPanel allScreens) {
        searchScreen = new SearchScreen(allScreens, searchController);
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
        return SearchIView.SEARCH_SCREEN_NAME_CONSTANT;
    }

}

