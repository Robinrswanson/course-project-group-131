package use_cases;

import java.io.IOException;
import java.util.List;

public interface gatewayReaderInterface {

    public List<String[]> getData() throws IOException;


}
