package use_cases.change_history_use_case;

import interface_adaptors.gateway.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//After changing the item data, related use case should create a Change History object with data and then call
//the save_history_change method

//Can be considered as a gatewaywriter ; could be split into data model,use case,and gateway writer but this use case is not too long.
public class ChangeHistory {
    //public to private
    public String time;
    public String username;
    public String serinum;
    public String action;
    //or make this the item object
    public String item;
    public String quantity;


//GET all the history data we need when constructing ChangeHistory object

    public ChangeHistory(ChangeHistoryData data)  {
        //get current time and save it as a String arribute
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.time = dateFormat.format(date);
        this.serinum = data.seriNum;
        this.action = data.action;
        this.item = data.itemName;
        this.quantity = data.quantity;
        this.username = data.userName;



    }

    //gateway writer to write new line of history data to the file "history.csv"
    public void save_history_change() {
        String path = "src/main/java/historydatabase/history.csv";
        GatewayWriter writer = new GatewayWriter(path);
        String[] newline = {this.time,this.username,this.action,this.item,this.quantity,this.serinum};
        System.out.println("start");
        writer.addNewLines(newline);
        System.out.println("finish");


    }}
