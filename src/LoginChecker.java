import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginChecker {
    private String username;
    private String password;




    public LoginChecker(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Boolean Check_UserExists(String username)   {

        String path = "C:\\Users\\ken_w\\Desktop\\Uoft 2022-2023\\Fall 2022\\CSC 207 Software design\\UserName Password.csv";
        String line = "";
        List<String[]> arrlist = new ArrayList<String[]>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",");
                arrlist.add(x);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] strings : arrlist) {
            if (username.equals(strings[0])) {
                return true;}

        }
        return false;


    }

    public Boolean Check_PwMatches(String username, String password) {

        String path = "C:\\Users\\ken_w\\Desktop\\Uoft 2022-2023\\Fall 2022\\CSC 207 Software design\\UserName Password.csv";
        String line = "";
        List<String[]> arrlist = new ArrayList<String[]>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",");
                arrlist.add(x);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] strings : arrlist) {
            if (username.equals(strings[0])) {
                System.out.println(strings[1]);
                return strings[1].equals(password);

            }

        }
        return false;
    }
}