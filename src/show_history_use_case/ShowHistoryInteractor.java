package show_history_use_case;


import java.io.IOException;
import java.util.List;

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
    public ShowHistoryFinalInput show(ShowHistoryStartInput startinput) throws IOException {
       if (! historyreader.StartDateValid(startinput.getStartdate())){
           return historypresenter.PrepareFailView("Date entered is too early");
       }else if(! historyreader.EndDateValid(startinput.getEnddate())){
           return historypresenter.PrepareFailView("Date entered is too late");
       }
       List<String[]> result = historyreader.readfile(startinput);
       ShowHistoryFinalInput input = new ShowHistoryFinalInput(startinput.getStartdate(),startinput.getEnddate(),result);

       return historypresenter.PrepareSuccessView(input);
    }




}
