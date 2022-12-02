package interface_adaptors.sales_report;

import use_cases.sales_report.SalesReporterInputBoundary;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SalesReporterPresenter {
    private SalesReporterInputBoundary salesReportUseCase;
    private GatewayReaderInterface gatewayReader;

    public SalesReporterPresenter(SalesReporterInputBoundary useCase, GatewayReaderInterface reader){
        this.salesReportUseCase = useCase;
        this.gatewayReader = reader;
    }

    public ArrayList<String[]> reportData(LocalDateTime startTime, LocalDateTime endTime){
        return salesReportUseCase.generateReport(startTime, endTime);
    }

}
