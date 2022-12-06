package main_builders_directors;

import interface_adaptors.show_history.ShowHistoryController;
import interface_adaptors.show_history.ShowHistoryFileDataAccess;
import interface_adaptors.show_history.ShowHistoryView;
import screens.ShowHistoryScreen;
import use_cases.show_history_use_case.*;

import javax.swing.*;
import java.io.IOException;

public class HistoryFeatureBuilder implements FeatureBuilder, GatewayBuilder {

    ShowHistoryDsGateway dsGateway;
    ShowHistoryPresenter presenter;
    ShowHistoryInputBoundary inputBoundary;
    ShowHistoryController controller;
    ShowHistoryScreen historyScreen;

    @Override
    public void buildGateway() throws IOException {
        dsGateway = new ShowHistoryFileDataAccess();
    }

    @Override
    public void buildPresenter() {
        presenter = new ShowHistoryResponseFormatter();
    }

    @Override
    public void buildUseCase() {
        inputBoundary = new ShowHistoryInteractor(dsGateway,presenter);
    }

    @Override
    public void buildController() {
        controller = new ShowHistoryController(inputBoundary);
    }

    @Override
    public void buildScreen(JPanel allScreens) {
        historyScreen = new ShowHistoryScreen(controller,allScreens);
    }

    @Override
    public void presenterSetScreen() {
        presenter.setScreen(historyScreen);
    }

    @Override
    public JPanel getScreen() {
        return historyScreen;
    }

    @Override
    public String getScreenName() {
        return ShowHistoryView.SHOW_HISTORY_NAME_CONSTANT;
    }

}
