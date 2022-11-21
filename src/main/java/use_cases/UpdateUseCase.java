package use_cases;

import java.util.*;
import entities.*;

public class UpdateUseCase implements UpdateInputBoundary {
    private final UpdateOutputBoundary presenter;

    public UpdateUseCase(UpdateOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     * @param data contains serial number of the item, the price to update, and if that staff has the
     *                 rights to update price or not.
     * @return a string of the view to show the user (created by the presenter)
     */
    public String updateItem(UpdateDS data){
        if (data.getPrice() < 0){
            return presenter.prepareFailure(0);
        }
        else if (! TempDataStorage.hasItem(data.getSerialNum())){
            return presenter.prepareFailure(1);
        }
        else if (!data.getUpdatePrice()){
            return presenter.prepareFailure(2);
        }

        Item item = TempDataStorage.getItem(data.getSerialNum());

        item.setPrice(data.getPrice());
        return presenter.prepareSuccess(data);
    }
}