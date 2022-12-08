package main_builders_directors;

import interface_adaptors.arr.ARRIView;
import interface_adaptors.arr.AddController;
import interface_adaptors.arr.AddPresenter;
import screens.AddScreen;
import use_cases.arr.ARROutputBoundary;
import use_cases.arr.Add;

import javax.swing.*;

public class AddFeatureBuilder implements FeatureBuilder {

    private ARROutputBoundary addPresenter;
    private Add addUseCase;
    private AddController addController;
    private ARRIView addScreen;


    public AddFeatureBuilder()
    {

    }

    /**
     * builds the Presenter by instantiating a new AddPresenter
     */
    @Override
    public void buildPresenter() {
        addPresenter = new AddPresenter();
    }

    /**
     * builds the use case
     */
    @Override
    public void buildUseCase() {
        addUseCase = new Add(addPresenter);
    }

    /**
     * builds the controller
     */
    @Override
    public void buildController() {
        addController = new AddController(addUseCase);
    }

    /** builds the screen
     *
     * @param allScreens the JPanel containing all the screens
     */
    @Override
    public void buildScreen(JPanel allScreens) {
        addScreen = new AddScreen(allScreens, addController);
    }

    /**
     * Sets the screen corresponding to the presenter
     */
    @Override
    public void presenterSetScreen() {
        addPresenter.setScreen(addScreen);
    }

    /**
     * returns the screen made by the process above
     */
    @Override
    public JPanel getScreen() {
        return (JPanel) addScreen;
    }

    @Override
    public String getScreenName() {
        return ARRIView.ADD_SCREEN_NAME_CONSTANT;
    }

}

