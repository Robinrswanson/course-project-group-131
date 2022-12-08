package use_cases.login;

import use_cases.gateway_interfaces.GatewayReaderInterface;

import java.io.IOException;

public interface LoginInputBoundary {

    void checkExists(LoginInputData data, GatewayReaderInterface reader) throws IOException;
}
