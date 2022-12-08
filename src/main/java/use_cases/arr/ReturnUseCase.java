package use_cases.arr;

import entities.Item;
import entities.User;
import use_cases.change_history_use_case.ChangeHistory;
import use_cases.change_history_use_case.ChangeHistoryData;

public class ReturnUseCase implements ARRInputBoundary
{
    /**
     * ReturnUseCase return the given quantity of the item.
     */

    private final String userName =User.getUserName();
    private ARROutputBoundary presenter;
    private final String ACTION = "Return";


    /**
     * ReturnUseCase Object created by the ReturnScreenBuilder
     * @param presenter A presenter object of type ARROutputBoundary, initialised by ReturnScreenBuilder
     */
    public ReturnUseCase(ARROutputBoundary presenter)
    {
        this.presenter = presenter;
    }

    /**
     * Makes a call to the changeItemQuantity method in the Add class through the Interface, to increase
     * the quantity by the value being returned.
     *
     * @param data contains serial number of the item and quantity to add
     */
    public void changeItemQuantity(ARRInputData data)
    {
        ARRInputBoundary obj = new Add(presenter);
        obj.changeItemQuantity(data);
        //updateHistory();
    }
    @Override
    public void updateHistory(ARRInputData data, Item item)
    {
        ChangeHistoryData historyData = new ChangeHistoryData(userName, this.ACTION, data, item);
        new ChangeHistory(historyData);

    }
}
