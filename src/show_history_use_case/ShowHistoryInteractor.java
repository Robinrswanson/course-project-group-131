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
    public ShowHistoryResponseModel show(ShowHistoryStartInput startinput) throws IOException {
       if (! historyreader.StartDateValid(startinput.getStartdatetime())){
           return historypresenter.PrepareFailView("Date entered is too early");
       }else if(! historyreader.EndDateValid(startinput.getEnddatetime())){
           return historypresenter.PrepareFailView("Date entered is too late");
       }
       List<String[]> result = historyreader.readfile(startinput);
       ShowHistoryResponseModel input = new ShowHistoryResponseModel(startinput.getStartdate(),startinput.getEnddate(),result);

       return historypresenter.PrepareSuccessView(input);
    }




}
