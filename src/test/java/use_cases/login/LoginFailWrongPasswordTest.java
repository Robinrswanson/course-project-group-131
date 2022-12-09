package use_cases.login;

import entities.User;
import interface_adaptors.login.LoginController;
import interface_adaptors.login.LoginIView;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LoginFailWrongPasswordTest {

    /**
     * Tests for success when an incorrect password is entered (but correct username)
     */
    @Test
    void checkLogin() throws IOException {

        // This creates an anonymous implementing class for the Output Boundary.
        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void setScreen(LoginIView screen) {
                assertTrue(true);

            }

            @Override
            public void prepareDisplay(LoginOutputData data) {
                assertFalse(data.getCorrectPassword());
                assertTrue(data.getCorrectUser());
            }
        };
        LoginInputBoundary useCase = new Login(presenter);
        LoginController controller = new LoginController(useCase);
        // controller calls on the reader, which currently reads from the official username/password file

        // Run the controller, which calls the use case
        controller.checkUserExists("Tony", new char[]{'T'});

    }
}
