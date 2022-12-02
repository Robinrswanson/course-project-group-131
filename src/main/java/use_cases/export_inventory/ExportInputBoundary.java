package use_cases.export_inventory;

import use_cases.gateway_interfaces.gatewayWriterInterface;

public interface ExportInputBoundary {
    /**
     * extracts the data from the inventory and writes it to the file
     * @param writer a class that writes the current state of the inventory to the database
     * @return a String displaying if the use case succeeded or failed
     */
    void extractDataStorage(gatewayWriterInterface writer);
}
