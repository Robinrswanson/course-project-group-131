package use_cases.change_history_use_case;

import entities.Item;
import use_cases.arr.ARRInputData;

public class ChangeHistoryData {
    /**
     * A data structure for ChangeHistory class
     * Wraps all the data required by ChangeHistory class into a single object
     */

    protected String userName;
    protected String action;
    protected String quantity;
    protected String itemName;
    protected String seriNum;

    /**
     *
     * @param userName String type userName
     * @param action String
     * @param data ARRInputData
     * @param item Item
     */

    public ChangeHistoryData(String userName, String action, ARRInputData data, Item item)
    {
        this.userName = userName;
        this.action = action;
        this.quantity = Integer.toString(data.getQuantity());
        this.itemName = item.getName();
        this.seriNum = item.getSerialNumber();
    }

}
