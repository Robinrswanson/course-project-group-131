package use_cases.login;

import use_cases.gateway_interfaces.GatewayReaderInterface;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Login implements LoginInputBoundary {

    public static final int USERNAME_COLUMN = 0;
    public static final int PASSWORD_COLUMN = 1;
    public static final int STATUS_COLUMN = 2;
    private LoginOutputBoundary presenter;


    public Login(LoginOutputBoundary presenter)
    {
        this.presenter = presenter;
    }

    public void checkExists(LoginInputData data, GatewayReaderInterface reader) throws IOException {
        List<String[]> users = reader.getData();
        LoginOutputData outData = new LoginOutputData();

        for(String[] user : users)
        {
            if(Objects.equals(user[USERNAME_COLUMN], data.getUsername()))
            {
                outData.setCorrectUser(true);
                if (pwMatches(user[PASSWORD_COLUMN], data.getPassword()))
                {
                    outData.setCorrectPassword(true);
                    outData.setManager(isManager(user[STATUS_COLUMN],"M"));
                }
                break;
            }
        }
        if (outData.getCorrectPassword()){
            LoginOutPutDS ds = new LoginOutPutDS();
            ds.Set_Is_Manager(outData.getManager());
            ds.Set_username(data.getUsername());
        }
        presenter.prepareDisplay(outData);
    }

    public boolean pwMatches(String pw, String pwTest)
    {
        return Objects.equals(pw, pwTest);

    }


    public boolean isManager(String status, String Manager_Status){
        return Objects.equals(status, Manager_Status);
    }






}
