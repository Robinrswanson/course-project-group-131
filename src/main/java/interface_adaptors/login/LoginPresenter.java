package interface_adaptors.login;

import use_cases.login.LoginOutPutDS;
import use_cases.login.LoginOutputBoundary;
import use_cases.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    private LoginIView screen;

    public void setScreen(LoginIView screen){
        this.screen = screen;
    }

    /**
     * Prepares the Login Screen display, based on the information recieved from the use case
     * @param data contains whether the correct username and password were entered
     */
    @Override
    public void prepareDisplay(LoginOutputData data){

        if (!data.getCorrectUser()){
            screen.displayUsernameFail();
        }
        else if (!data.getCorrectPassword()){
            screen.displayPasswordFail();
        }
        else{
            screen.changeToMainScreen();
        }
    }
}
