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

    /**
     * Builds the gateway
     * @throws IOException
     */
    @Override
    public void buildGateway() throws IOException {
        dsGateway = new ShowHistoryFileDataAccess();
    }

    /**
     * Builds the presenter
     */
    @Override
    public void buildPresenter() {
        presenter = new ShowHistoryResponseFormatter();
    }

    /**
     * Builds the use case
     */
    @Override
    public void buildUseCase() {
        inputBoundary = new ShowHistoryInteractor(dsGateway,presenter);
    }

    /**
     * Builds the controller
     */
    @Override
    public void buildController() {
        controller = new ShowHistoryController(inputBoundary);
    }

    /**
     * Builds the screen
     * @param allScreens A JPanel containing all of the screens
     */
    @Override
    public void buildScreen(JPanel allScreens) {
        historyScreen = new ShowHistoryScreen(controller,allScreens);
    }

    /**
     * Sets the screen of the presenter to ShowHistoryScreen
     */
    @Override
    public void presenterSetScreen() {
        presenter.setScreen(historyScreen);
    }

    /**
     * Returns the screen
     * @return Return the feature's screen
     */
    @Override
    public JPanel getScreen() {
        return historyScreen;
    }

    /**
     * Returns the name of the screen as referenced by the card layout
     * @return the name of the screen
     */
    @Override
    public String getScreenName() {
        return ShowHistoryView.SHOW_HISTORY_NAME_CONSTANT;
    }

}
