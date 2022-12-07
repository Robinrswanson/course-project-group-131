package use_cases.arr;

import entities.Item;
import use_cases.change_history_use_case.ChangeHistory;
import use_cases.change_history_use_case.ChangeHistoryData;

public class ReturnUseCase extends Add implements ARRInputBoundary
{
    /**
     * ReturnUseCase return the given quantity of the item.
     */


    private final String ACTION = "Return";

    private String userName;

    /**
     * ReturnUseCase Object created by the ReturnScreenBuilder
     * @param presenter A presenter object of type ARROutputBoundary, initialised by ReturnScreenBuilder
     */
    public ReturnUseCase(ARROutputBoundary presenter)
    {
        super(presenter);
    }

    /**
     * Makes a call to the changeItemQuantity method in the super class Add, to increase
     * the quantity by the value being returned.
     *
     * @param data contains serial number of the item and quantity to add
     */
    @Override
    public void changeItemQuantity(ARRInputData data)
    {
        super.changeItemQuantity(data);
        //updateHistory();
    }
    @Override
    public void updateHistory(ARRInputData data, Item item)
    {
        ChangeHistoryData historyData = new ChangeHistoryData(this.userName,this.ACTION, data, item);
        new ChangeHistory(historyData);

    }
}