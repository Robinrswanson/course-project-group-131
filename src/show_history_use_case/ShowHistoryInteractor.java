package show_history_use_case;


//Use case layer
public class ShowHistoryInteractor implements ShowHistoryInputBoundary{
    final ShowHistoryDsGateway historyreader;
    final ShowHistoryPresenter historypresenter;

    public ShowHistoryInteractor(ShowHistoryDsGateway reader,
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
