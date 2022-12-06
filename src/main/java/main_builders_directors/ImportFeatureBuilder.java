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

        @Override
        public void buildPresenter() {
            importPresenter = new ImportPresenter();
        }

        @Override
        public void buildUseCase() {
            importUseCase = new Import(importPresenter);
        }

        @Override
        public void buildController() {
            importController = new ImportController(importUseCase);
        }

        @Override
        public void buildScreen(JPanel allScreens) {
            importScreen = new ImportScreen(allScreens, importController);
        }

        @Override
        public void presenterSetScreen() {
            importPresenter.setScreen(importScreen);
        }

        @Override
        public JPanel getScreen() {
            return (JPanel) importScreen;
        }

    @Override
    public String getScreenName() {
        return ImportIView.IMPORT_SCREEN_NAME_CONSTANT;
    }

}

