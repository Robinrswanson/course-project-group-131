package use_cases;

import interface_adaptors.ImportPresenter;

import java.io.IOException;
import java.util.List;

public interface ImportInputBoundary {
    /**
     * Takes each item provided and updates the item information
     * @param
     * @return a boolean based on the success or failure of the import process
     */
    String importDatabase(gatewayReaderInterface reader) throws IOException;
}
