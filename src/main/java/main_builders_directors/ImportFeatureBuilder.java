package main_builders_directors;

import interface_adaptors.import_inventory.ImportController;
import interface_adaptors.import_inventory.ImportIView;
import interface_adaptors.import_inventory.ImportPresenter;
import screens.ImportScreen;
import use_cases.import_inventory.Import;
import use_cases.import_inventory.ImportOutputBoundary;

import javax.swing.*;

public class ImportFeatureBuilder implements FeatureBuilder {

    private ImportOutputBoundary importPresenter;
    private Import importUseCase;
    private ImportController importController;
    private ImportIView importScreen;

    /**
     * Builds the presenter
     */
    @Override
    public void buildPresenter() {
        importPresenter = new ImportPresenter();
    }

    /**
     * Builds the use case
     */
    @Override
    public void buildUseCase() {
        importUseCase = new Import(importPresenter);
    }

    /**
     * Builds the controller
     */
    @Override
    public void buildController() {
        importController = new ImportController(importUseCase);
    }

    /**
     * Builds the screen
     * @param allScreens A JPanel containing all of the screens
     */
    @Override
    public void buildScreen(JPanel allScreens) {
        importScreen = new ImportScreen(allScreens, importController);
    }

    /**
     * Sets the screen of the presenter to importScreen
     */
    @Override
    public void presenterSetScreen() {
        importPresenter.setScreen(importScreen);
    }

    /**
     * Returns the screen
     * @return Return the feature's screen
     */
    @Override
    public JPanel getScreen() {
        return (JPanel) importScreen;
    }

    /**
     * Returns the name of the screen as referenced by the card layout
     * @return the name of the screen
     */
    @Override
    public String getScreenName() {
        return ImportIView.IMPORT_SCREEN_NAME_CONSTANT;
    }

}

