package use_cases.login;

public class LoginInputData {

    private String username;
    private String password;

    /**
     * The input data passed into the Login Use Case to determine whether a user exists
     * @param username the username entered by the user
     * @param password the password entered by the user
     */
    public LoginInputData(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username
     * @return the username
     */
    public String getUsername(){
        return username;
    }

    /**
     * Fetches the password
     * @return the password
     */
    public String getPassword(){
        return password;
    }
}
