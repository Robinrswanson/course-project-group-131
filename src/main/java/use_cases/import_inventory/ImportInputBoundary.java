package use_cases.import_inventory;

import use_cases.gateway_interfaces.gatewayReaderInterface;

import java.io.IOException;

public interface ImportInputBoundary {
    /**
     * Takes each item provided and updates the item information
     * @param reader a class that reads files
     * @return a string that tells the pres
     */
    String importDatabase(gatewayReaderInterface reader) throws IOException;
}
