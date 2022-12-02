package use_cases.initializer;

import use_cases.gateway_interfaces.GatewayReaderInterface;

import java.io.IOException;
import java.text.ParseException;

public interface InitializerInputBoundary {
    /**
     * Initializes the inventory.
     * @param reader a class that reads files
     * @throws ParseException
     * @throws IOException
     */

    void initializeInventory(GatewayReaderInterface reader) throws ParseException, IOException;
}
