package gatewaywriter;

import interface_adaptors.gateway.GatewayReader;
import interface_adaptors.gateway.GatewayWriter;
import org.junit.jupiter.api.Test;
import use_cases.gateway_interfaces.GatewayReaderInterface;
import use_cases.gateway_interfaces.GatewayWriterInterface;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GatewayWriterNoLineTest {

    /**
     * Test for when the writer writes no lines to a file
     * @throws IOException
     */
    @Test
    void getData() throws IOException {
        GatewayReaderInterface reader = new GatewayReader("src/test/java/TestingSampleData/No Items.csv");
        List<String[]> data = reader.getData();
        GatewayWriterInterface writer = new GatewayWriter("src/test/java/TestingSampleData/Temp Write File.csv");
        writer.rewriteFile(data);
        reader.setFilePath("src/test/java/TestingSampleData/Temp Write File.csv");
        List<String[]> result = reader.getData();
        assertTrue(result.isEmpty());
    }
}
