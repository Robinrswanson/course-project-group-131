package change_history_use_case;

public interface ChangeHistoryDataGateway {
    ChangeHistoryResponseModel save_history_change(ChangeHistoryRequestModel receive);
}
