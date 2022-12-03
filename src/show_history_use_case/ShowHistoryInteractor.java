package show_history_use_case;


import java.io.IOException;
import java.util.ArrayList;
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
       String[][]resultfortable = new String[result.size()][];
       for (int i= 0;i <result.size(); i ++){
           resultfortable[i]= result.get(i);
       }
       
       ShowHistoryResponseModel input = new ShowHistoryResponseModel(startinput.getStartdate(),startinput.getEnddate(),resultfortable);

       return historypresenter.PrepareSuccessView(input);
    }




}
