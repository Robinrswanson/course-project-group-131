package use_cases.export_inventory;

import interface_adaptors.export_inventory.ExportIView;

public interface ExportOutputBoundary {

    void setScreen(ExportIView screen);
    void prepareSuccess(String filepath); //display when use case is successful
}
