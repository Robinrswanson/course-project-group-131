package interface_adaptors.sales_report;

import use_cases.gateway_interfaces.gatewayReaderInterface;
import use_cases.sales_report.SalesReporterInputBoundary;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SalesReporterController {
    private final SalesReporterInputBoundary salesReportUseCase;
    private final gatewayReaderInterface gatewayReader;
    // I think I need a way to set the filepath here?


    public SalesReporterController(SalesReporterInputBoundary useCase, gatewayReaderInterface reader){
        this.salesReportUseCase = useCase;
        this.gatewayReader = reader;
    }

    /**
     * The controller packages the data and sends it off to the Sales Reporter use case
     * @param startTime the start of the time range for the sales report
     * @param endTime the end of the time range for the sales report
     */
    public void reportData(String startTime, String endTime) throws IOException {
        List<String[]> readerData = gatewayReader.getData();
        salesReportUseCase.generateReport(readerData, startTime, endTime);
    }
}
