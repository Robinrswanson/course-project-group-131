package change_history_use_case;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ChangeHistoryResponseModel {
        public String time;
        public String username;
        public String action;
        //or make this the item object
        public String item;
        public String quantity;

        public ChangeHistoryResponseModel(String username, String action,String item,String quantity) {
                //get current time and save it as a String arribute
                Date date = Calendar.getInstance().getTime();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                this.time = dateFormat.format(date);
                this.username = username;
                this.action = action;
                this.item = item;
                this.quantity = quantity;
        }

    }
