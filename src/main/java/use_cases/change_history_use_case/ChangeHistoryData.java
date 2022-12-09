package use_cases.change_history_use_case;

import entities.ItemInterface;

public abstract class ChangeHistoryData {
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
     * @param item Item
     */

    public ChangeHistoryData(String userName, String action, ItemInterface item)
    {
        this.userName = userName;
        this.action = action;
        this.itemName = item.getName();
        this.seriNum = item.getSerialNumber();
    }
}
