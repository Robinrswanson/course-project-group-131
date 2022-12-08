package interface_adaptors.login;

import interface_adaptors.gateway.GatewayReader;
import use_cases.login.LoginInputBoundary;
import use_cases.login.LoginInputData;

import java.io.IOException;

public class LoginController {

    private final LoginInputBoundary useCase;

    public LoginController(LoginInputBoundary useCase){
        this.useCase = useCase;
    }

    /**
     * Organizes the input data, calls on the use case
     * @param username the entered-in username
     * @param password the entered-in password
     */
    public void checkUserExists(String username, char[] password) throws IOException {
        LoginInputData data = new LoginInputData(username, getPassword(password));
        GatewayReader reader = new GatewayReader("src/main/java/database/UserName Password.csv");
        useCase.checkExists(data, reader);
    }

    /**
     *
     * @param passwordInChar the password, contained in Chars
     * @return the password in String format
     */
    private String getPassword(char[] passwordInChar) {

        StringBuilder pwBuilder = new StringBuilder();
        for (char i : passwordInChar) {
            pwBuilder.append(i);
        }
        return pwBuilder.toString();
    }
}
