package use_cases;

import java.time.LocalDate;

public class ManagerFacade extends EmployeeFacade implements ManagerFacadeInterface
{
    public void updatePrice(UpdateDS data, UpdatePresenter)
    {
        UpdateInputBoundary obj = new UpdateUseCase();
        obj.updateItem(data);
    }

    public generateSalesReport(LocalDate start, LocalDate end)
    {
        SalesReporterInterface obj = new SalesReporter(start, end);
        obj.generateReport()
    }

    public
}
