package use_cases.show_history_use_case;

import screens.ShowHistoryScreen;

//THe view
public class ShowHistoryResponseFormatter implements ShowHistoryPresenter{
    ShowHistoryScreen screen;
    public void setScreen(ShowHistoryScreen screen){
        this.screen = screen;
    }
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
