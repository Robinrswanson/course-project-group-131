package use_cases.login;

public class LoginOutPutDS {
    private static String username;
    private static Boolean IsManager;

    public LoginOutPutDS()
    {

    }

    public String Get_username()
    {
        return this.username;
    }

    public boolean Get_Is_Manager()
    {
        return this.IsManager;
    }

    public void Set_username(String username)
    {
        this.username = username;
    }

    public void Set_Is_Manager(Boolean Is_Manager)
    {
        this.IsManager = Is_Manager;
    }

}