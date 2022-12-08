package main_builders_directors;

import interface_adaptors.gateway.GatewayReader;
import interface_adaptors.sales_report.SalesReporterController;
import interface_adaptors.sales_report.SalesReporterPresenter;
import interface_adaptors.sales_report.SalesReporterView;
import interface_adaptors.show_history.ShowHistoryFileDataAccess;
import screens.SalesReportScreen;
import use_cases.gateway_interfaces.GatewayReaderInterface;
import use_cases.sales_report.SalesReporter;
import use_cases.sales_report.SalesReporterInputBoundary;
import use_cases.sales_report.SalesReporterOutputBoundary;
import use_cases.show_history_use_case.ShowHistoryDsGateway;

import javax.swing.*;
import java.io.IOException;

public class SalesReporterFeatureBuilder implements FeatureBuilder, GatewayBuilder, ReaderBuilder {

    SalesReporterController controller;
    SalesReporterInputBoundary inputBoundary;
    SalesReporterOutputBoundary presenter;
    SalesReporterView salesReportScreen;
    ShowHistoryDsGateway historyGateway;

    GatewayReaderInterface reader;
    private final String FILE_PATH =
            "src/main/java/database/Sample Data - Sample History.csv";

    @Override
    public void buildGateway() throws IOException {
        historyGateway = new ShowHistoryFileDataAccess();
    }
    public void buildReader() {
        reader = new GatewayReader(FILE_PATH);
    }
    @Override
    public void buildPresenter() { presenter = new SalesReporterPresenter();}

    @Override
    public void buildUseCase() { inputBoundary = new SalesReporter(presenter, historyGateway);}

    /**
     * Builds the controller
     */
    @Override
    public void buildController() { controller = new SalesReporterController(inputBoundary, reader);}

    /**
     * Builds the screen
     * @param allScreens A JPanel containing all of the screens
     */
    @Override
    public void buildScreen(JPanel allScreens) {
        salesReportScreen = new SalesReportScreen(allScreens, controller);
    }


    /**
     * Sets the screen of the presenter to ShowHistoryScreen
     */
    @Override
    public void presenterSetScreen() {
        presenter.setScreen(salesReportScreen);
    }

    /**
     * Returns the screen
     * @return Return the feature's screen
     */
    @Override
    public JPanel getScreen() {
        return (JPanel) salesReportScreen;
    }
    /**
     * Returns the name of the screen as referenced by the card layout
     * @return the name of the screen
     */
    @Override
    public String getScreenName() { return SalesReporterView.SALES_REPORT_SCREEN_NAME;}
}
