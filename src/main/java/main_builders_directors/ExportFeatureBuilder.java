package main_builders_directors;

import interface_adaptors.export_inventory.ExportController;
import interface_adaptors.export_inventory.ExportIView;
import interface_adaptors.export_inventory.ExportPresenter;
import interface_adaptors.import_inventory.ImportController;
import interface_adaptors.import_inventory.ImportIView;
import interface_adaptors.import_inventory.ImportPresenter;
import screens.ExportScreen;
import screens.ImportScreen;
import use_cases.export_inventory.Export;
import use_cases.export_inventory.ExportOutputBoundary;
import use_cases.import_inventory.Import;

import javax.swing.*;

public class ExportFeatureBuilder implements FeatureBuilder{

    private ExportOutputBoundary exportPresenter;
    private Export exportUseCase;
    private ExportController exportController;
    private ExportIView exportScreen;

    /**
     * Builds the presenter
     */
    @Override
    public void buildPresenter() {
        exportPresenter = new ExportPresenter();
    }

    /**
     * Builds the use case
     */
    @Override
    public void buildUseCase() {
        exportUseCase = new Export(exportPresenter);
    }

    /**
     * Builds the controller
     */
    @Override
    public void buildController() {
        exportController = new ExportController(exportUseCase);
    }

    /**
     * Builds the screen
     * @param allScreens
     */
    @Override
    public void buildScreen(JPanel allScreens) {
        exportScreen = new ExportScreen(allScreens, exportController);
    }

    /**
     * Sets the presenter's screen to exportScreen
     */
    @Override
    public void presenterSetScreen() {
        exportPresenter.setScreen(exportScreen);
    }

    /**
     * Returns the created screen
     * @return
     */
    @Override
    public JPanel getScreen() {
        return (JPanel) exportScreen;
    }

    /**
     * Returns the name of the screen, as referenced by the card layout
     * @return
     */
    @Override
    public String getScreenName() {
        return ExportIView.EXPORT_SCREEN_NAME_CONSTANT;
    }
}
