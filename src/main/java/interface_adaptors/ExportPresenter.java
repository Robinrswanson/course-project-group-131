package interface_adaptors;

import use_cases.ExportOutputBoundary;

import java.util.List;

public class ExportPresenter implements ExportOutputBoundary {
    /**
     * Called if export is successful
     * @param filePath a String that is the location of the database
     * @return a String value for the View to present
     */
    public String prepareSuccess(String filePath){
        return "Inventory successfully exported to: " + filePath;
    }

}
