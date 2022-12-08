package interface_adaptors.login;

public interface LoginIView {

    String LOGIN_SCREEN_NAME_CONSTANT = "Login";

    void displayPasswordFail();
    void displayUsernameFail();
    void changeToMainScreen();
}
