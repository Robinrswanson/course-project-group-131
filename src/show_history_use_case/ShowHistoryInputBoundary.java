package show_history_use_case;

import java.io.IOException;

//if we only have one user interface(view), we need to consider this, otherwise ignore
public interface ShowHistoryInputBoundary {
    ShowHistoryResponseModel show(ShowHistoryStartInput startinput) throws IOException;
}
