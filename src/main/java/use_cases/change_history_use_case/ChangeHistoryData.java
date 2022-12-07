package use_cases.change_history_use_case;

import entities.Item;
import use_cases.arr.ARRInputData;

public class ChangeHistoryData {

    protected String userName;
    protected String action;
    protected String quantity;
    protected String itemName;
    protected String seriNum;

    public ChangeHistoryData(String userName, String action, ARRInputData data, Item item)
    {
        this.userName = userName;
        this.action = action;
        this.quantity = Integer.toString(data.getQuantity());
        this.itemName = item.getName();
        this.seriNum = item.getSerialNumber();
    }

}
