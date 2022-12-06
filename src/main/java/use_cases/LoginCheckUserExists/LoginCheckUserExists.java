package use_cases.LoginCheckUserExists;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LoginCheckUserExists {

    public String username;
    public String password;


    public LoginCheckUserExists(String username, String password)
    {
        this.password = password;
        this.username = username;
    }

    public List<Boolean> CheckExists(String username, String password)
    {
        List<Boolean> BoolList = new ArrayList<>();
        String path = "src/main/java/database/UserName Password.csv";
        List<String[]> users= new ArrayList<>() ;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while((line=reader.readLine())!=null){
                String[] values = line.split(",");
                users.add(values);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(String[] user : users)
        {
            if(Objects.equals(user[0], username))
            {
                BoolList.add(0,true);
                Boolean pw_matches= this.Check_pw_matches(user[1],password);
                BoolList.add(1,pw_matches);
                if (pw_matches)
                {
                    BoolList.add(this.Check_is_manager(user[2],"M"));
                }

                return BoolList;

            }
        }

        BoolList.add(0,false);
        return BoolList;

    }

    public boolean Check_pw_matches(String pw, String pwTest)
    {
        if(Objects.equals(pw, pwTest))
        {
            return true;
        }else{
            return false;
        }

    }


    public boolean Check_is_manager(String status, String Manager_Status){
        if(Objects.equals(status,Manager_Status))
        {
            return true;
        }
        else{
            return false;
        }
    }






}
