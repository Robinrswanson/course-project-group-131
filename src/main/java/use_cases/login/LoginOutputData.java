package use_cases.login;

public class LoginOutputData {

    private boolean correctUser = false;
    private boolean correctPassword = false;
    private boolean manager = false;

    /**
     * Gets whether a correct user was inputted
     * @return true if correct
     */
    public boolean getCorrectUser(){
        return correctUser;
    }

    /**
     * Gets whether a correct password was inputted
     * @return true if correct
     */
    public boolean getCorrectPassword(){
        return correctPassword;
    }

    /**
     * Gets whether the user is a manager
     * @return true if manager
     */
    public boolean getManager(){
        return manager;
    }

    /**
     * Sets whether the username is correct
     * @param value true/false
     */
    public void setCorrectUser(boolean value){
        this.correctUser = value;
    }

    /**
     * Sets whether the password is correct
     * @param value true/false
     */
    public void setCorrectPassword(boolean value){
        this.correctPassword = value;
    }

    /**
     * Sets whether the user is a manager
     * @param value true/false
     */
    public void setManager(boolean value){
        this.manager = value;
    }



}
