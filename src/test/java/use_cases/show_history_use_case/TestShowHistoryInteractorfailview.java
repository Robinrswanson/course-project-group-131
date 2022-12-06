package use_cases.show_history_use_case;

import org.junit.jupiter.api.Test;
import screens.ShowHistoryScreen;
import use_cases.show_history_use_case.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestShowHistoryInteractorfailview {
    @Test
    void create() throws IOException {
        ShowHistoryDsGateway dsGateway = new ShowHistoryDsGateway() {

            @Override
            public boolean StartDateValid(LocalDateTime startdate) {
                return false;
            }

            @Override
            public boolean EndDateValid(LocalDateTime enddate) {
                return true;
            }

            @Override
            public List<String[]> readfile(ShowHistoryStartInput startinput) {
                String[][] list = new String[][]{{"2022-12-03 06:46:33,Daisy,Add,Apple,1,apple123"},{"2021-09-03 06:46:33,Emily,Add,pencil,5,pencil123"}};
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
                fail("Use case failure is unexpected");

                return null;
            }

            @Override
            public ShowHistoryResponseModel PrepareFailView(String error) {
                assertEquals("Date entered is too early",error);
                return null;
            }
        };
        ShowHistoryInputBoundary inputBoundary = new ShowHistoryInteractor(dsGateway,presneter);
        ShowHistoryStartInput input = new ShowHistoryStartInput("2021-01-01 00:00:00","2023-01-01 00:00:00");
        inputBoundary.show(input);


    }}

