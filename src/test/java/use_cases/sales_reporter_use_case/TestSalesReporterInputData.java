package use_cases.sales_reporter_use_case;

import org.junit.After;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import use_cases.sales_report.SalesReporterInputData;

import java.time.LocalDateTime;


public class TestSalesReporterInputData {
    @Before
    public void setUp(){}
    @After
    public void teardown(){}

    @Test
    public void stringToDateTimeTest() {
        LocalDateTime expected = LocalDateTime.of(2022, 12, 5, 10, 0);
        LocalDateTime actual = SalesReporterInputData.stringToDateTime("2022-12-05 10:00");
        assertEquals(expected, actual);
    }
}
