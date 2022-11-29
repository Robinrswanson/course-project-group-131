package interface_adaptors;

import use_cases.gatewayReaderInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class gatewayReader implements gatewayReaderInterface {

    private final File file;
    private final String filePath;

    public gatewayReader(String filePath){
        this.file = new File(filePath);
        this.filePath = filePath;
    }
    public String getFilePath(){
        return this.filePath;
    }

    public List<String[]> getData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String[]> fileData = new ArrayList<>();
        String st;
        while ((st = reader.readLine()) != null){
            String[] rowData = st.split(",");
            fileData.add(rowData);
        }
        return fileData;
    }


}
