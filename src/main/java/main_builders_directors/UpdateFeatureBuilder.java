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

    @Override
    public void buildPresenter() {
        updatePresenter = new UpdatePresenter();
    }

    @Override
    public void buildUseCase() {
        updateUseCase = new UpdatePrice(updatePresenter);
    }

    @Override
    public void buildController() {
        updateController = new UpdateController(updateUseCase);
    }

    @Override
    public void buildScreen(JPanel allScreens) {
        updateScreen = new UpdateScreen(allScreens, updateController);
    }

    @Override
    public void presenterSetScreen() {
        updatePresenter.setScreen(updateScreen);
    }

    @Override
    public JPanel getScreen() {
        return (JPanel) updateScreen;
    }

    @Override
    public String getScreenName() {
        return UpdateIview.UPDATE_SCREEN_NAME_CONSTANT;
    }
}
