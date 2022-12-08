package use_cases.initializer;

import java.io.IOException;
import java.text.ParseException;

public interface InitializerInputBoundary {
    /**
     * Initializes the inventory.
     * @param reader a class that reads files
     */

    void initializeInventory(GatewayReaderInterface reader) throws ParseException, IOException;
}
