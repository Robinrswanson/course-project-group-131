package use_cases.show_history_use_case;

import java.io.IOException;


public interface ShowHistoryInputBoundary {
    ShowHistoryResponseModel show(ShowHistoryStartInput startinput) throws IOException;
}
