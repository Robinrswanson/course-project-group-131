package show_history_use_case;
//outputboundary
public interface ShowHistoryPresenter {
    ShowHistoryFinalInput PrepareSuccessView(ShowHistoryFinalInput finalinput);
    ShowHistoryFinalInput PrepareFailView(String error);
    }

