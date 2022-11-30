package interface_adaptors;

import use_cases.ImportInputBoundary;

import java.io.IOException;

public class ImportController {
    private final ImportInputBoundary importUseCase;

    public ImportController(ImportInputBoundary useCase){
        this.importUseCase = useCase;
    }
    /**
     * The controller creates instance of GatewayReader and passes through ImportUseCase
     * @param filepath a String that is the location of the desired inventory to be imported
     * @return a String for the View to present
     */
    public String importDatabase(String filepath) throws IOException {
        GatewayReader reader = new GatewayReader(filepath);
        return importUseCase.importDatabase(reader);
    }
}
