package use_cases.gateway_interfaces;

import java.io.IOException;
import java.util.List;

public interface GatewayReaderInterface {

    String getFilePath();
    void setFilePath(String filePath);
    List<String[]> getData() throws IOException;



}

