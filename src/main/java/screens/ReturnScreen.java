package screens;
import javax.swing.*;
import use_cases.ReturnOutputBoundaryInterface;
import interface_adaptors.*;
public class ReturnScreen extends AddScreen implements ReturnOutputBoundaryInterface {


    ReturnScreen(JPanel screens, AddController controller)
    {
        super(screens,controller);
    }
    public void itemReturned(int itemCount)
    {
        JOptionPane.showMessageDialog(null, "The item has been Returned \n The new items are: " + itemCount, "Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    public void itemNotReturned()
    {
        JOptionPane.showMessageDialog(null, "The item has not been Returned", "Rejected", JOptionPane.WARNING_MESSAGE);

    }

}
