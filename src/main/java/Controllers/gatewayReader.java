package Controllers;

import java.io.*;
import java.util.ArrayList;

public class gatewayReader {
    private final File file;
    private BufferedReader reader;
    public ArrayList<String> result;


    public gatewayReader   (File f){
        this.file = f;
    }

    public ArrayList<String> getData(){
        try {
            String line;
            result = new ArrayList<>();
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        }
        catch(Exception e){
            e.printStackTrace();
    }
        finally {
            try {
                reader.close();
                return result;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        }
}

