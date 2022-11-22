package use_cases;
import java.io.File;

public class Export {

    public Export(){

    }
    // Either make a reader and read database, extract and write to a new file, or return file path for database
    public File exportDatabase(){
        File fileToReturn = new File("src/main/java/database/Sample Data - Sample Item.csv");
        return fileToReturn;
    }
}
