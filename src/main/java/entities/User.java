package entities;

public class User {
    private static String userName;
    private static String status;


    public static String getUserName() {
        return userName;
    }

    public static String getStatus()
    {
        return status;
    }

    public static void setUserName(String user)
    {
        userName = user;
    }

    public static void setStatus(String stat)
    {
        status = stat;
    }
}
