package interface_adaptors.sales_report;

import interface_adaptors.show_history.ShowHistoryFileDataAccess;
import use_cases.gateway_interfaces.GatewayReaderInterface;
import use_cases.sales_report.SalesReporterInputBoundary;
import use_cases.sales_report.SalesReporterInputData;
import use_cases.show_history_use_case.ShowHistoryDsGateway;
import use_cases.show_history_use_case.ShowHistoryStartInput;

import java.io.IOException;
import java.util.List;

public class SalesReporterController {
    private final SalesReporterInputBoundary salesReportUseCase;
    private final ShowHistoryDsGateway reader;
    private final String FILE_PATH =
            "src/main/java/database/Sample Data - Sample History.csv";


    public SalesReporterController(SalesReporterInputBoundary useCase, ShowHistoryDsGateway reader){
        this.salesReportUseCase = useCase;
        this.reader = reader;
    }

    /**
     * The controller packages the data and sends it off to the Sales Reporter use case
     * @param startTime the start of the time range for the sales report
     * @param endTime the end of the time range for the sales report
     */
    public void reportData(String startTime, String endTime) throws IOException {
        ShowHistoryStartInput startInput = new ShowHistoryStartInput(startTime, endTime);
        List<String[]> readerData = reader.readfile(startInput);
        SalesReporterInputData data = new SalesReporterInputData(readerData, startTime, endTime);
        salesReportUseCase.generateReport(data);
    }
}
