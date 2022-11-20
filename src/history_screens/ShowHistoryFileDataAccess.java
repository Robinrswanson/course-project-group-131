//This class is for the valid date check
package history_screens;

import show_history_use_case.ShowHistoryStartInput;
import show_history_use_case.ShowHistoryDsGateway;
//import gateway.gatewayreader(Robin's gateway reader)

import java.io.*;
import java.nio.file.Path;
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
        reader = new BufferedReader(new FileReader("history"));
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
    public static boolean CompareDateString(String a, String b){
        for (int i = 0; i<8; i++){
            if (Integer.parseInt(a.substring(i))>
                    Integer.parseInt(b.substring(i))){
                return true;
                }else if(Integer.parseInt(a.substring(i))<
                        Integer.parseInt(b.substring(i))){
                    return false;
                }
            }
        return true;
        }

    @Override
    public boolean StartDateValid(String startdate){
        if (lines == null){
            return false;
        }else{
            String filestartdate = lines.get(0).substring(0,8);
            return CompareDateString(startdate, filestartdate);

        }

    }
    @Override
    public boolean EndDateValid(String enddate){
        if (lines == null){
            return false;
        }else{
            String fileenddate = lines.get(lines.size()-1).substring(0,8);
            return CompareDateString(fileenddate,enddate);

        }

    }
    @Override
    public void read(ShowHistoryStartInput startinput) throws IOException {
        this.read();}

}
