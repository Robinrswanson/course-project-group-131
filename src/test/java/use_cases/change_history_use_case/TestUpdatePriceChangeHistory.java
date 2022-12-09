package use_cases.change_history_use_case;

import entities.Item;
import use_cases.arr.ARRInputData;
import org.junit.jupiter.api.Test;
import use_cases.update_price.UpdatePriceInputData;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

//This test is for testing the changehistory usecase

public class TestUpdatePriceChangeHistory {

    /**
     * Tests for history updation when an item's price is updated
     *
     * @throws IOException
     */
    @Test
    void create() throws IOException {
        Date date = new Date(2023-01-22);
        List<String> category = List.of("Fruits");
        UpdatePriceInputData arrr = new UpdatePriceInputData("apple123",40);
        Item item = new Item("10077","Apple", 30, 2, category,date,"second floor");
        ChangeHistoryData data = new UpdatePriceChangeHistoryData("Daisy","CHANGE PRICE",arrr,item);
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
        String[][]test = new String[][]{{time,"Daisy","CHANGE PRICE","Apple","40.0","10077"}};
        List<String[]> testdata= Arrays.asList(test);
        assertArrayEquals(testdata.get(0),fileData.get(length-1));
    }

}

