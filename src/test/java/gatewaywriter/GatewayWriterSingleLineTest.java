package gatewaywriter;

import interface_adaptors.gateway.GatewayReader;
import interface_adaptors.gateway.GatewayWriter;
import org.junit.jupiter.api.Test;
import use_cases.gateway_interfaces.GatewayReaderInterface;
import use_cases.gateway_interfaces.GatewayWriterInterface;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GatewayWriterSingleLineTest {
    @Test
    void getData() throws IOException {
        GatewayReaderInterface reader = new GatewayReader("src/test/java/TestingSampleData/Single Item.csv");
        List<String[]> data = reader.getData();
        GatewayWriterInterface writer = new GatewayWriter("src/test/java/TestingSampleData/Temp Write File.csv");
        writer.rewriteFile(data);
        reader.setFilePath("src/test/java/TestingSampleData/Temp Write File.csv");
        List<String[]> result = reader.getData();
        String[] expected1 = {"1", "Ice Cream", "9.99", "10", "N/A", "N/A", "Frozen"};
        assertArrayEquals(expected1, result.get(0));
    }
}
