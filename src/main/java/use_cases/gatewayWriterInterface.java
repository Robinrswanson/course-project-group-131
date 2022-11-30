package use_cases;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface gatewayWriterInterface {

    public void rewriteFile(List<String[]> newFileContents);

    public void editSingleCell(String replace, int row, int col) throws IOException;

    public void addNewLines(String[] newRowData) throws IOException;
}
