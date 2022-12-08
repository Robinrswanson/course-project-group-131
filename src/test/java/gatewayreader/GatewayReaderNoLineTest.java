package gatewayreader;

import interface_adaptors.gateway.GatewayReader;
import org.junit.jupiter.api.Test;
import use_cases.gateway_interfaces.GatewayReaderInterface;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GatewayReaderNoLineTest {
    @Test
    void getData() throws IOException {
        GatewayReaderInterface reader = new GatewayReader("src/test/java/TestingSampleData/No Items.csv");
        List<String[]> result = reader.getData();
        assertTrue(result.isEmpty());
    }
}
