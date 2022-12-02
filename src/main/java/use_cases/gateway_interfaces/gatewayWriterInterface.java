package use_cases.gateway_interfaces;

import java.io.IOException;
import java.util.List;

public interface gatewayWriterInterface {

    void rewriteFile(List<String[]> newFileContents);

    void editSingleCell(String replace, int row, int col) throws IOException;

    void addNewLines(String[] newRowData) throws IOException;
}
