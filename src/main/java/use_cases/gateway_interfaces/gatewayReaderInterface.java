package use_cases.gateway_interfaces;

import java.io.IOException;
import java.util.List;

public interface gatewayReaderInterface {

    String getFilePath();
    List<String[]> getData() throws IOException;


}
