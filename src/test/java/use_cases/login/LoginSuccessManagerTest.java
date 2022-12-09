package use_cases.login;

import entities.Item;
import entities.ItemInterface;
import entities.TempDataStorage;
import entities.User;
import interface_adaptors.login.LoginController;
import interface_adaptors.login.LoginIView;
import interface_adaptors.update_price.UpdateIview;
import interface_adaptors.update_price.UpdatePresenter;
import org.junit.jupiter.api.Test;
import use_cases.update_price.UpdatePriceInputBoundary;
import use_cases.update_price.UpdatePriceInputData;
import use_cases.update_price.UpdatePriceOutputBoundary;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSuccessManagerTest {

    /**
     * Tests for success when a manager logs in
     */
    @Test
    void checkLogin() throws IOException {
        // Initialize an item class

        // This creates an anonymous implementing class for the Output Boundary.
        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void setScreen(LoginIView screen) {
                assertTrue(true);

            }

            @Override
            public void prepareDisplay(LoginOutputData data) {
                assertEquals(User.getStatus(), "M");
                assertTrue(data.getCorrectPassword());
                assertTrue(data.getCorrectUser());
            }
        };
        LoginInputBoundary useCase = new Login(presenter);
        LoginController controller = new LoginController(useCase);
        // controller calls on the reader, which currently reads from the official username/password file

        // Run the controller, which calls the use case
        controller.checkUserExists("1", new char[]{'1'});

    }
}
