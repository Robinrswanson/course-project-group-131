package use_cases;

import interface_adaptors.ImportPresenter;

import java.io.IOException;
import java.util.List;

public interface ImportInputBoundary {
    /**
     * Takes each item provided and updates the item information
     * @param reader a class that reads files
     * @return a string that tells the pres
     */
    String importDatabase(gatewayReaderInterface reader) throws IOException;
}
