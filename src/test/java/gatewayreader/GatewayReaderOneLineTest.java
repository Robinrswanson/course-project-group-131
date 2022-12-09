package gatewayreader;

import interface_adaptors.gateway.GatewayReader;
import org.junit.jupiter.api.Test;
import use_cases.gateway_interfaces.GatewayReaderInterface;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GatewayReaderOneLineTest {

    /**
     * Tests for when the file to be read has one line
     * @throws IOException
     */
    @Test
    void getData() throws IOException {
        GatewayReaderInterface reader = new GatewayReader("src/test/java/TestingSampleData/Single Item.csv");
        List<String[]> result = reader.getData();
        String[] expected = {"1", "Ice Cream", "9.99", "10", "N/A", "N/A", "Frozen"};
        assertArrayEquals(expected, result.get(0));
    }
}
