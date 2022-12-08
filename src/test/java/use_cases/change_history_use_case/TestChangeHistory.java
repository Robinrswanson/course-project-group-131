package use_cases.change_history_use_case;

import entities.Item;
import interface_adaptors.gateway.GatewayReader;
import use_cases.arr.ARRInputData;
import use_cases.change_history_use_case.ChangeHistory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import use_cases.gateway_interfaces.*;
import java.util.Calendar;
import java.util.Date;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

//This test is for testing the changehistory usecase
/*
public class TestChangeHistory {
    @Test
    void create() throws IOException {
        Date date = new Date(2023-01-22);
        List<String> category = List.of("Fruits");
        ARRInputData arrr = new ARRInputData("apple123",1);
        Item item = new Item("10077","Apple", 30, 2, category,date,"second floor");
        ChangeHistoryData data = new ChangeHistoryData("Daisy","ADD ITEM",arrr,item);
        ChangeHistory testsample = new ChangeHistory(data);
        testsample.save_history_change();
        String filepath ="src/main/java/historydatabase/history.csv";
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        List<String[]> fileData = new ArrayList<>();
        String st;
        while ((st = reader.readLine()) != null){
            String[] rowData = st.split(",");
            fileData.add(rowData);
        }
        int length = fileData.size();
        Date date1 = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = dateFormat.format(date1);
        String[][]test = new String[][]{{time,"Daisy","ADD ITEM","Apple","1","10077"}};
        List<String[]> testdata= Arrays.asList(test);
        assertArrayEquals(testdata.get(0),fileData.get(length-1));
    }


}
*/
