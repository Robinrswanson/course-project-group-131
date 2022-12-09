package use_cases.import_inventory;

import use_cases.gateway_interfaces.GatewayReaderInterface;

import java.io.IOException;

public interface ImportInputBoundary {
    /**
     * Takes each item provided and updates the item information
     * @param reader a class that reads files
     */
    void importDatabase(GatewayReaderInterface reader) throws IOException;
}
