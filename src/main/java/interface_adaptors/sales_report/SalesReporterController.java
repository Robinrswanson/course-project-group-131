package interface_adaptors.sales_report;

import use_cases.gateway_interfaces.GatewayReaderInterface;
import use_cases.sales_report.SalesReporterInputBoundary;
import use_cases.sales_report.SalesReporterInputData;

import java.io.IOException;
import java.util.List;

public class SalesReporterController {
    private final SalesReporterInputBoundary salesReportUseCase;
    private final GatewayReaderInterface reader;
    private final String FILE_PATH =
            "src/main/java/database/Sample Data - Sample History.csv";


    public SalesReporterController(SalesReporterInputBoundary useCase, GatewayReaderInterface reader){
        this.salesReportUseCase = useCase;
        this.reader = reader;
        reader.setFilePath(FILE_PATH);
    }

    /**
     * The controller packages the data and sends it off to the Sales Reporter use case
     * @param startTime the start of the time range for the sales report
     * @param endTime the end of the time range for the sales report
     */
    public void reportData(String startTime, String endTime) throws IOException {
        List<String[]> readerData = reader.getData();
        SalesReporterInputData data = new SalesReporterInputData(readerData, startTime, endTime);
        salesReportUseCase.generateReport(data);
    }
}
