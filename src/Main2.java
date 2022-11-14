import entities.src.code.*;
import use_cases.*;
import java.io.*;
import java.util.ArrayList;

public class Main2{
    public static void main(String[] args) {
        File file = new File("src//Database//Sample Data - Sample Item.csv");
        gatewayReader reader = new gatewayReader(file);
        ArrayList<String> data = reader.getData();
        System.out.println(data);
    }
}
