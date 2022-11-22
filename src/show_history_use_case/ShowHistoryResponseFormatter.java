package show_history_use_case;
import show_history_use_case.ShowHistoryPresenter;
import show_history_use_case.ShowHistoryFinalInput;

//THe view
public class ShowHistoryResponseFormatter implements ShowHistoryPresenter{
    @Override

    public ShowHistoryFinalInput PrepareSuccessView(ShowHistoryFinalInput input){
        return input;
    }

    @Override
    public ShowHistoryFinalInput PrepareFailView(String error){
        ShowHistoryFinalInput failinput = new ShowHistoryFinalInput(error);
        return failinput;

    }
}
