package use_cases.initializer;

import use_cases.gateway_interfaces.GatewayReaderInterface1;

import java.io.IOException;
import java.text.ParseException;

public interface InitializerInputBoundary {
    /**
     * Initializes the inventory.
     * @param reader a class that reads files
     */

    void initializeInventory(GatewayReaderInterface1 reader) throws ParseException, IOException;
}
