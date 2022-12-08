package main_builders_directors;

import interface_adaptors.search_sort.SortController;
import interface_adaptors.search_sort.SortIView;
import interface_adaptors.search_sort.SortPresenter;
import screens.SortScreen;
import use_cases.search_sort.Sort;
import use_cases.search_sort.SortInputBoundary;
import use_cases.search_sort.SortOutputBoundary;

import javax.swing.*;

public class SortFeatureBuilder implements FeatureBuilder{

    private SortOutputBoundary sortPresenter;
    private SortInputBoundary sortUseCase;
    private SortController sortController;
    private SortIView sortScreen;


    public SortFeatureBuilder()
    {

    }

    /**
     * builds the Presenter by instantiating a new sortPresenter
     */
    @Override
    public void buildPresenter() {
        sortPresenter = new SortPresenter();
    }

    /**
     * builds the use case
     */
    @Override
    public void buildUseCase() {
        sortUseCase = new Sort(sortPresenter);
    }

    /**
     * builds the controller
     */
    @Override
    public void buildController() {
        sortController = new SortController(sortUseCase);
    }

    /** builds the screen
     *
     * @param allScreens the JPanel containing all the screens
     */
    @Override
    public void buildScreen(JPanel allScreens) {
        sortScreen = new SortScreen(allScreens, sortController);
    }

    /**
     * Sets the screen corresponding to the presenter
     */
    @Override
    public void presenterSetScreen() {
        sortPresenter.setScreen(sortScreen);
    }

    /**
     * returns the screen made by the process above
     */
    @Override
    public JPanel getScreen() {
        return (JPanel) sortScreen;
    }

    @Override
    public String getScreenName() {
        return SortIView.SORT_SCREEN_NAME_CONSTANT;
    }

}
