package history_use_case;


import history_screens.ShowHistoryScreen;

//Use case layer
public class ShowHistoryInteractor implements ShowHistoryInputBoundary{
    final ShowHistoryGatewayReader historyreader;
    final ShowHistoryPresenter historypresenter;

    public ShowHistoryInteractor(ShowHistoryGatewayReader reader,
                                 ShowHistoryPresenter presenter){
        this.historyreader = reader;
        this.historypresenter = presenter;
    }
    @Override
    public ShowHistoryFinalInput show(ShowHistoryStartInput startinput){
        ShowHistoryFinalInput a = new ShowHistoryFinalInput();
        return a;
    }


}
