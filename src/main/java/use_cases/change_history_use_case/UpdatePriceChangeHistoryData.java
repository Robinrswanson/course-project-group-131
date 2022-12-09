package use_cases.change_history_use_case;

import entities.ItemInterface;
import use_cases.update_price.UpdatePriceInputData;

public class UpdatePriceChangeHistoryData extends ChangeHistoryData{

    public UpdatePriceChangeHistoryData(String userName, String action, UpdatePriceInputData data, ItemInterface item) {
        super(userName, action, item);
        quantity = Double.toString(data.getPrice());
    }
}