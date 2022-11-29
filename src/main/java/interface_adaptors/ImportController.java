package interface_adaptors;

import use_cases.ImportDS;
import use_cases.ImportInputBoundary;

import java.io.IOException;

public class ImportController {
    private final ImportInputBoundary importUseCase;

    public ImportController(ImportInputBoundary useCase){
        this.importUseCase = useCase;
    }
    public String importDatabase(String filepath) throws IOException {
        gatewayReader reader = new gatewayReader(filepath);
        return importUseCase.importDatabase(reader);
    }
}
