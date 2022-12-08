package main_builders_directors;

import interface_adaptors.update_price.UpdateController;
import interface_adaptors.update_price.UpdateIview;
import interface_adaptors.update_price.UpdatePresenter;
import screens.UpdateScreen;
import use_cases.update_price.UpdatePrice;
import use_cases.update_price.UpdatePriceInputBoundary;
import use_cases.update_price.UpdatePriceOutputBoundary;

import javax.swing.*;

public class UpdateFeatureBuilder implements FeatureBuilder{

    UpdatePriceOutputBoundary updatePresenter;
    UpdatePriceInputBoundary updateUseCase;
    UpdateController updateController;
    UpdateIview updateScreen;

    /**
     * Builds the presenter
     */
    @Override
    public void buildPresenter() {
        updatePresenter = new UpdatePresenter();
    }

    /**
     * Builds the use case
     */
    @Override
    public void buildUseCase() {
        updateUseCase = new UpdatePrice(updatePresenter);
    }

    /**
     * Builds the controller
     */
    @Override
    public void buildController() {
        updateController = new UpdateController(updateUseCase);
    }

    /**
     * Builds the screen
     * @param allScreens A JPanel containing all of the screens
     */
    @Override
    public void buildScreen(JPanel allScreens) {
        updateScreen = new UpdateScreen(allScreens, updateController);
    }

    /**
     * Sets the screen of the presenter to ShowHistoryScreen
     */
    @Override
    public void presenterSetScreen() {
        updatePresenter.setScreen(updateScreen);
    }

    /**
     * Returns the screen
     * @return Return the feature's screen
     */
    @Override
    public JPanel getScreen() {
        return (JPanel) updateScreen;
    }

    /**
     * Returns the name of the screen as referenced by the card layout
     * @return the name of the screen
     */
    @Override
    public String getScreenName() {
        return UpdateIview.UPDATE_SCREEN_NAME_CONSTANT;
    }
}
