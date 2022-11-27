package use_cases;

import interface_adaptors.ImportPresenter;

import java.util.List;

public interface ImportInputBoundary {
    /**
     * Takes each item provided and updates the item information
     * @param importData contains a list of String arrays, each being a respective row in the csv file
     * @return a boolean based on the success or failure of the import process
     */
    String importDatabase(ImportDS importData);
}
