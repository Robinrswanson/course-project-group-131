package interface_adaptors.arr;

import use_cases.arr.ARRInputData;
import use_cases.arr.ARROutputBoundary;

import javax.swing.*;
import java.awt.*;

public class ReturnPresenter implements ARROutputBoundary {
    /**
     * A presenter for the Return functionality.
     *
     * It is a part of the MVC model functionality adopted for the Add, Return and Remove functionalities for
     * updating the quantity of the item. Calls are made to the ARROutputBoundary .
     *
     */

    ARRIView ReturnScreen;

    /**
     *
     * @param returnScreen JPanel object
     */
    public void setScreen(ARRIView returnScreen)
    {
        this.ReturnScreen = returnScreen;

    }

    /**
     * Displays a Dialog box indicating the items were successfully returned.
     *
     * @param data Used to access the data values for displaying message in dialog box
     *
     */
    @Override
    public void prepareSuccess(ARRInputData data)
    {
        JOptionPane.showMessageDialog((Component) ReturnScreen,  data.getQuantity() +" items were returned",  "Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays a dialog box to the user, indicating error in the data object.
     *
     * @param error A constant value for the type of error in the data entered by the user.
     */
    @Override
    public void prepareFailure(int error)
    {
        String message = "";
        if( error == NEGATIVE_INT_ERROR)
            message = "Items Not Returned \n Quantity cannot be negative";
        else
            message = "Items Not Returned \n Invalid Serial No";

        JOptionPane.showMessageDialog((Component)ReturnScreen, message, "Rejected", JOptionPane.WARNING_MESSAGE);
    }
}
