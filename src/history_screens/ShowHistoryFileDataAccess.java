//This class is for the valid date check
package history_screens;

import show_history_use_case.ShowHistoryStartInput;
import show_history_use_case.ShowHistoryDsGateway;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
//import gateway.gatewayreader(Robin's gateway reader)

import java.io.*;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class ShowHistoryFileDataAccess implements ShowHistoryDsGateway {

    public static ArrayList<String> lines;
    public static BufferedReader reader;
    //here I want to import Robin's gateway reader method but this method is not in the main yet.
    //public ShowHistoryFileDataAccess(){
        //GatewayReader reader = new GatewayReader(D://history.csv);
        //historyfile =

    //for now I use a buffer reader to do this.

    public ShowHistoryFileDataAccess() throws IOException {
        reader = new BufferedReader(new FileReader("history.csv"));
    }
    public void read() throws IOException {
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
        reader.close();
    }

    //Return true if stringdate a is bigger than stringdate b
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
            String filestartdate = lines.get(0).substring(16);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime filestartdatetime = LocalDateTime.parse(filestartdate,format);
            return CompareDatea(startdate, filestartdatetime);

        }

    }
    @Override
    public boolean EndDateValid(LocalDateTime enddate){
        if (lines == null){
            return false;
        }else{
            String fileenddate = lines.get(lines.size()-1).substring(0,16);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime fileenddatetime = LocalDateTime.parse(fileenddate,format);
            return CompareDateb(fileenddatetime,enddate);

        }

    }
    @Override
    public List<String[]> readfile(ShowHistoryStartInput startinput) throws IOException {
        //import the gatewayreader or
        gatewayReader reader = new gatewayReader(history_path);
        List<String[]> rows = reader.getData();
        List<String[]> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (String[] row: rows){
            LocalDateTime dateTime = LocalDateTime.parse(row[0],formatter);
            if (startinput.getStartdatetime().compareTo(dateTime) <=0 && startinput.getEnddatetime().compareTo(dateTime) >=0){
                result.add(row);
            }
        }
        return rows;

    }

}
