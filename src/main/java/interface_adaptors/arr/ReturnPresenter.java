package interface_adaptors.arr;

import use_cases.arr.ARRInputData;
import use_cases.arr.ARROutputBoundary;

import javax.swing.*;
import java.awt.*;

public class ReturnPresenter implements ARROutputBoundary {

    ARRIView ReturnScreen;
    JFrame frame;
    public void setScreen(ARRIView returnScreen)
    {
        this.ReturnScreen = returnScreen;

    }

    public void prepareSuccess(ARRInputData data)
    {
        JOptionPane.showMessageDialog((Component) ReturnScreen, "The items were returned",  "Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

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
