package show_history_use_case;
//outputboundary
public interface ShowHistoryPresenter {
    ShowHistoryResponseModel PrepareSuccessView(ShowHistoryResponseModel finalinput);
    ShowHistoryResponseModel PrepareFailView(String error);
    }

