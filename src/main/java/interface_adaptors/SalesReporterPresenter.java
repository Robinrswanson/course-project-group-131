package interface_adaptors;

import use_cases.SalesReporter;
import use_cases.SalesReporterInputBoundary;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SalesReporterPresenter {
    private SalesReporterInputBoundary salesReportUseCase;

    public SalesReporterPresenter(SalesReporterInputBoundary useCase){ this.salesReportUseCase = useCase; }

    public ArrayList<String[]> reportData(LocalDateTime startTime, LocalDateTime endTime){
        return salesReportUseCase.generateReport(startTime, endTime);
    }

}
