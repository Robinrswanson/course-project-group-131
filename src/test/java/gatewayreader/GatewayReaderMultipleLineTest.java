package gatewayreader;

import interface_adaptors.gateway.GatewayReader;
import org.junit.jupiter.api.Test;
import use_cases.gateway_interfaces.GatewayReaderInterface;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GatewayReaderMultipleLineTest {
    @Test
    void getData() throws IOException {
        GatewayReaderInterface reader = new GatewayReader("src/test/java/TestingSampleData/Multiple Items.csv");
        List<String[]> result = reader.getData();
        String[] expected1 = {"1", "Ice Cream", "9.99", "20", "N/A", "N/A", "Frozen"};
        String[] expected2 = {"8", "Chicken", "2.00", "17", "N/A", "12-04-2022", "Meats"};
        String[] expected3 = {"18", "Homogenized Milk", "2.99", "100", "N/A", "12-09-2022", "Dairy"};
        assertArrayEquals(expected1, result.get(0));
        assertArrayEquals(expected2, result.get(1));
        assertArrayEquals(expected3, result.get(2));
    }
}
