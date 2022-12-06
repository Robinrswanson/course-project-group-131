package use_cases.show_history_use_case;

import screens.ShowHistoryScreen;

//outputboundary
public interface ShowHistoryPresenter {

    public void setScreen(ShowHistoryScreen screen);
    ShowHistoryResponseModel PrepareSuccessView(ShowHistoryResponseModel finalinput);
    ShowHistoryResponseModel PrepareFailView(String error);
    }

