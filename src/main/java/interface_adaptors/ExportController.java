package interface_adaptors;

import use_cases.ExportDS;
import use_cases.ExportInputBoundary;

public class ExportController {
    ExportInputBoundary exportUseCase;

    public ExportController(ExportInputBoundary useCase){
        this.exportUseCase = useCase;
    }
    public String export(){
        ExportDS data = exportUseCase.extractDataStorage();
        gatewayWriter writer = new gatewayWriter("src/main/java/database/Database.csv");
        writer.rewriteFile(data.getDatabase());
        return "src/main/java/database/Database.csv";
    }
}
