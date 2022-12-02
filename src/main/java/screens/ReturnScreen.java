package screens;
import javax.swing.*;
import use_cases.ReturnOutputBoundaryInterface;
import interface_adaptors.*;
public class ReturnScreen extends AddScreen implements ReturnOutputBoundaryInterface {


    public ReturnScreen(JPanel screens, ReturnController controller)
    {
        super(screens,controller);
    }

    private void addTitle()
    {
        JLabel title = new JLabel("Item Return");
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);
        this.add(titlePanel);
    }

    private JButton getAddButton()
    {

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
