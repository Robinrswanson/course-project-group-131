package use_cases.update_price;

import entities.*;
import use_cases.arr.ARRInputData;
import use_cases.change_history_use_case.ARRChangeHistoryData;
import use_cases.change_history_use_case.ChangeHistory;
import use_cases.change_history_use_case.ChangeHistoryData;
import use_cases.change_history_use_case.UpdatePriceChangeHistoryData;

public class UpdatePrice implements UpdatePriceInputBoundary {
    private final UpdatePriceOutputBoundary presenter;
    public final String ACTION = "CHANGE PRICE";

    public UpdatePrice(UpdatePriceOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * @param data contains serial number of the item, the price to update, and if that staff has the
     *             rights to update price or not.
     */
    public void updateItem(UpdatePriceInputData data) {
        if (data.getPrice() < 0) {
            presenter.prepareFailure(0);
        } else if (!TempDataStorage.hasItem(data.getSerialNum())) {
            presenter.prepareFailure(1);
        } else if (!(User.getStatus().equals(User.MANAGER_STATUS_CONSTANT))) {
            presenter.prepareFailure(2);
        } else {
            Item item = TempDataStorage.getItem(data.getSerialNum());

            item.setPrice(data.getPrice());
            updateHistory(data, item);
            presenter.prepareSuccess(data);
        }
    }

    private void updateHistory(UpdatePriceInputData data, Item item)
    {
        ChangeHistoryData historyData = new UpdatePriceChangeHistoryData(User.getUserName(),this.ACTION, data, item);
        new ChangeHistory(historyData).save_history_change();
    }
}