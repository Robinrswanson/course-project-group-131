package show_history_use_case;

//THe view
public class ShowHistoryResponseFormatter implements ShowHistoryPresenter{
    @Override

    public ShowHistoryResponseModel PrepareSuccessView(ShowHistoryResponseModel input){
        return input;
    }

    @Override
    public ShowHistoryResponseModel PrepareFailView(String error){
        ShowHistoryResponseModel failinput = new ShowHistoryResponseModel(error);
        return failinput;

    }
}
