package interface_adaptors;

import use_cases.ExportInputBoundary;

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
    public String export(){
        GatewayWriter writer = new GatewayWriter("src/main/java/database/Database.csv");
        return exportUseCase.extractDataStorage(writer);
    }
}
