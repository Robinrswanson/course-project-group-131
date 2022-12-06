package interface_adaptors.export_inventory;

import interface_adaptors.gateway.GatewayWriter;
import use_cases.export_inventory.ExportInputBoundary;

public class ExportController {
    ExportInputBoundary exportUseCase;

    public ExportController(ExportInputBoundary useCase){
        this.exportUseCase = useCase;
    }
    /**
     * The controller creates instance of GatewayWriter and passes through exportUseCase
     * The filepath is set automatically to the location of the database
     * @return a String for the View to present
     */
    public void export(){
        GatewayWriter writer = new GatewayWriter("src/main/java/database/Database.csv");
        exportUseCase.extractDataStorage(writer);
    }
}
