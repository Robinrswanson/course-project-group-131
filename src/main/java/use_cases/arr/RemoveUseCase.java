package use_cases.arr;

import entities.Item;
import entities.User;
import use_cases.change_history_use_case.ChangeHistory;
import use_cases.change_history_use_case.ChangeHistoryData;

public class RemoveUseCase implements ARRInputBoundary{

    /**
     * RemoveUseCase removes the given quantity of the item.
     */


    private final String ACTION = "Remove Item";
    private ARROutputBoundary presenter;


    /**
     * RemoveUseCase Object created by the RemoveScreenBuilder
     * @param presenter A presenter object of type ARROutputBoundary, initialised by RemoveScreenBuilder
     */
    public RemoveUseCase(ARROutputBoundary presenter)
    {
        this.presenter = presenter;
    }

    /**
     * Makes a call to the changeItemQuantity method in the super class Add, to reduce
     * the quantity by the value being removed.
     *
     * @param data contains serial number of the item and quantity to add
     */
    @Override
    public void changeItemQuantity(ARRInputData data)
    {
        ARRInputBoundary arr = new Add(presenter);
        arr.changeItemQuantity(data);
        //updateHistory();
    }
    @Override
    public void updateHistory(ARRInputData data, Item item)
    {
        ChangeHistoryData historyData = new ChangeHistoryData(User.getUserName(),this.ACTION, data, item);
        new ChangeHistory(historyData);

    }

}
