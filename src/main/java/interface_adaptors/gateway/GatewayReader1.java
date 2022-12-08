package interface_adaptors.gateway;

import use_cases.gateway_interfaces.GatewayReaderInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GatewayReader1 implements GatewayReaderInterface {

    private File file;
    private String filePath;

    public GatewayReader1(String filePath){
        this.file = new File(filePath);
        this.filePath = filePath;
    }
    public void setFilePath(String filePath){
        this.filePath = filePath;
        this.file = new File(filePath);
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
