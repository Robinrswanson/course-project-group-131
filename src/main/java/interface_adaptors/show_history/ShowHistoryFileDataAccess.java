//This class is for the valid date check
package interface_adaptors.show_history;

import interface_adaptors.gateway.*;

import use_cases.show_history_use_case.ShowHistoryDsGateway;
import use_cases.show_history_use_case.ShowHistoryStartInput;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ShowHistoryFileDataAccess implements ShowHistoryDsGateway {

    public List<String[]> lines;
    public GatewayReader1 reader;
    //here I want to import Robin's gateway reader method but this method is not in the main yet.
    //public ShowHistoryFileDataAccess(){
        //GatewayReader reader = new GatewayReader(D://history.csv);
        //historyfile =

    //for now I use a buffer reader to do this.

    //Return true if stringdate a is bigger than stringdate b
    public ShowHistoryFileDataAccess() throws IOException {

        String path = "src/main/java/historydatabase/history.csv";
    reader = new GatewayReader1(path);
    lines = reader.getData();}

    public ShowHistoryFileDataAccess(GatewayReader1 reader2) throws IOException {
        reader = reader2;
        lines = reader.getData();
    }
    public boolean CompareDatea(LocalDateTime a, LocalDateTime b){
        return a.compareTo(b) >= 0;
        }

   public boolean CompareDateb(LocalDateTime a, LocalDateTime b){
        return a.compareTo(b)<= 0;
   }

    @Override
    public boolean StartDateValid(LocalDateTime startdate){
        if (lines == null){
            return false;
        }else{
            String filestartdate = lines.get(0)[0];
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime filestartdatetime = LocalDateTime.parse(filestartdate,format);
            return CompareDatea(startdate, filestartdatetime);

        }

    }
    @Override
    public boolean EndDateValid(LocalDateTime enddate){
        if (lines == null){
            return false;
        }else{
            String fileenddate = lines.get(lines.size()-1)[0];
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime fileenddatetime = LocalDateTime.parse(fileenddate,format);
            return CompareDateb(enddate,fileenddatetime);

        }

    }
    @Override
    public List<String[]> readfile(ShowHistoryStartInput startinput) throws IOException {
        //import the gatewayreader or
        List<String[]> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (String[] row: lines){
            LocalDateTime dateTime = LocalDateTime.parse(row[0],formatter);
            if (startinput.getStartdatetime().compareTo(dateTime) <=0 && startinput.getEnddatetime().compareTo(dateTime) >=0){
                result.add(row);
            }
        }
        return result;

    }

}
