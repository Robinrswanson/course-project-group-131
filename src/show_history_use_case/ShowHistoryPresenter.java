package show_history_use_case;

public interface ShowHistoryPresenter {
    ShowHistoryFinalInput PrepareSuccessView(ShowHistoryFinalInput finalinput);
    static ShowHistoryFinalInput PrepareFailView(String error);
    }

