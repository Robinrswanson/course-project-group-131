package entities;

public class User {
    private static String userName;
    private static String status;
    public static final String MANAGER_STATUS_CONSTANT = "M";
    public static final String EMPLOYEE_STATUS_CONSTANT = "E";

    /**
     * Gets the username of the user
     * @return a String
     */
    public static String getUserName() {
        return userName;
    }

    /**
     * Gets the
     * @return a String (right now consisting of only one character)
     */
    public static String getStatus()
    {
        return status;
    }

    public static void setUserName(String user)
    {
        userName = user;
    }

    public static void setStatus(boolean ManagerStatus)
    {
        if (ManagerStatus){
            status = MANAGER_STATUS_CONSTANT;
        }
        else{
            status = EMPLOYEE_STATUS_CONSTANT;
        }
    }
}
