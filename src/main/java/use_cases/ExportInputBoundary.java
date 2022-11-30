package use_cases;

import java.util.List;

public interface ExportInputBoundary {
    /**
     * extracts the data from the inventory and writes it to the file
     * @param writer a class that writes the current state of the inventory to the database
     * @return a String displaying if the use case succeeded or failed
     */
    String extractDataStorage(gatewayWriterInterface writer);
}
