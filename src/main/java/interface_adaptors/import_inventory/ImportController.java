package interface_adaptors.import_inventory;

import interface_adaptors.gateway.GatewayReader1;
import use_cases.import_inventory.ImportInputBoundary;

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
    public void importDatabase(String filepath) throws IOException {
        GatewayReader1 reader = new GatewayReader1(filepath);
        importUseCase.importDatabase(reader);
    }
}
