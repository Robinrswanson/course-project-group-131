package show_history_use_case;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ShowHistoryDsGateway {
    //these two methods are to check if the dates that user enters are valid
    boolean StartDateValid(String startdate);
    boolean EndDateValid(String enddate);


    //To read from the history file and get the start date and end date of the whole history in the file
    void read(ShowHistoryStartInput startinput) throws IOException;

}
