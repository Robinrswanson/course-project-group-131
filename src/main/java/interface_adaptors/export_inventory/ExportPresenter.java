package interface_adaptors.export_inventory;

import use_cases.export_inventory.ExportOutputBoundary;

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
