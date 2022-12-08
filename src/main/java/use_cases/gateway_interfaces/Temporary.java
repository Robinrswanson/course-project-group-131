package use_cases.gateway_interfaces;

import java.io.IOException;
import java.util.List;

public interface Temporary {
    String getFilePath();
    List<String[]> getData() throws IOException;

    void setFilePath(String filePath);


}
