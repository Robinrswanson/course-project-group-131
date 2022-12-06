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

    @Override
    public void buildPresenter() {
        exportPresenter = new ExportPresenter();
    }

    @Override
    public void buildUseCase() {
        exportUseCase = new Export(exportPresenter);
    }

    @Override
    public void buildController() {
        exportController = new ExportController(exportUseCase);
    }

    @Override
    public void buildScreen(JPanel allScreens) {
        exportScreen = new ExportScreen(allScreens, exportController);
    }

    @Override
    public void presenterSetScreen() {
        exportPresenter.setScreen(exportScreen);
    }

    @Override
    public JPanel getScreen() {
        return (JPanel) exportScreen;
    }

    @Override
    public String getScreenName() {
        return ExportIView.EXPORT_SCREEN_NAME_CONSTANT;
    }
}
