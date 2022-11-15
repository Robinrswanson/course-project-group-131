import Entities.*;
import use_cases.*;
import Controllers.*;
import java.io.*;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        File file = new File("C:\\Users\\robin\\IdeaProjects\\course-project-group-131\\src\\main\\java\\Database\\Sample Data - Sample Item.csv");
        gatewayReader reader = new gatewayReader(file);
        ArrayList<String> data = reader.getData();
        System.out.println(data);
    }
}
