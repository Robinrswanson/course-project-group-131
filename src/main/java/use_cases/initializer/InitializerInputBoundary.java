package use_cases.initializer;

import use_cases.gateway_interfaces.Temporary;

import java.io.IOException;
import java.text.ParseException;

public interface InitializerInputBoundary {
    /**
     * Initializes the inventory.
     * @param reader a class that reads files
     */

    void initializeInventory(Temporary reader) throws ParseException, IOException;
}
