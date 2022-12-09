package use_cases.show_history_use_case;

import org.junit.jupiter.api.Test;
import screens.ShowHistoryScreen;
import use_cases.show_history_use_case.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestShowHistoryInteractorsuccessview {

    /**
     * Tests for a successfully shown history, when there exists changes in the history
     * @throws IOException
     */
    @Test
    void show() throws IOException {
        ShowHistoryDsGateway dsGateway = new ShowHistoryDsGateway() {

            @Override
            public boolean StartDateValid(LocalDateTime startdate) {
                return true;
            }

            @Override
            public boolean EndDateValid(LocalDateTime enddate) {
                return true;
            }

            @Override
            public List<String[]> readfile(ShowHistoryStartInput startinput) throws IOException {
                String[][] list = new String[][]{{"2022-12-03 06:46:33","Daisy","Add","Apple","1","apple123"}};
                return Arrays.asList(list);
            }
        };
        ShowHistoryPresenter presneter = new ShowHistoryPresenter() {
            @Override
            public void setScreen(ShowHistoryScreen screen) {
                assertTrue(true);
            }

            @Override
            public ShowHistoryResponseModel PrepareSuccessView(ShowHistoryResponseModel finalinput) {
                assertArrayEquals(new String[][]{{"2022-12-03 06:46:33","Daisy","Add","Apple","1","apple123"}},finalinput.gethistorydata());
                assertEquals("",finalinput.geterror());

                return null;
            }

            @Override
            public ShowHistoryResponseModel PrepareFailView(String error) {
                fail("Uase case failure is unexpected");
                return null;
            }
        };
        ShowHistoryInputBoundary inputBoundary = new ShowHistoryInteractor(dsGateway,presneter);
        ShowHistoryStartInput input = new ShowHistoryStartInput("2021-01-01 00:00:00","2023-01-01 00:00:00");
        inputBoundary.show(input);


}}
