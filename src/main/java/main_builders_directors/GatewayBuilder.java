package main_builders_directors;

import java.io.IOException;

public interface GatewayBuilder {

    void buildGateway() throws IOException;
    // this is specifically for features that require a gateway reader
}
