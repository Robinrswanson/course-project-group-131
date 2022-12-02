package use_cases.update_price;

import entities.*;

public class UpdatePrice implements UpdatePriceInputBoundary {
    private final UpdatePriceOutputBoundary presenter;

    public UpdatePrice(UpdatePriceOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     * @param data contains serial number of the item, the price to update, and if that staff has the
     *                 rights to update price or not.
     */
    public void updateItem(UpdatePriceInputData data){
        if (data.getPrice() < 0){
            presenter.prepareFailure(0);
        }
        else if (! TempDataStorage.hasItem(data.getSerialNum())){
            presenter.prepareFailure(1);
        }
        else if (!data.getUpdatePrice()){
            presenter.prepareFailure(2);
        }

        Item item = TempDataStorage.getItem(data.getSerialNum());

        item.setPrice(data.getPrice());
        presenter.prepareSuccess(data);
    }
}