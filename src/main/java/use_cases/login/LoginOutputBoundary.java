package use_cases.login;

import interface_adaptors.login.LoginIView;

public interface LoginOutputBoundary {

    void setScreen(LoginIView screen);
    void prepareDisplay(LoginOutputData data);
}
