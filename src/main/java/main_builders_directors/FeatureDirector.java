package main_builders_directors;

import javax.swing.*;
import java.io.IOException;

public class FeatureDirector {

    /**
     *
     * @return the corresponding builder for the director. As an abstract class, this is implemented by each of the
     * individual directors
     */

    FeatureBuilder builder;

    public void setBuilder(FeatureBuilder builder){
        this.builder = builder;
    }
    /**
     * Creates the classes necessary for the feature to function and adhere to clean architecture
     *
     * @param allScreens the JPanel holding all the screens
     * @return the screen corresponding to the feature (ex. AddScreen for AddArchitectureDirector)
     */
    public JPanel createFeature(JPanel allScreens) throws IOException {
        if (builder instanceof GatewayBuilder){
            ((GatewayBuilder) builder).buildGateway();
        }
        if (builder instanceof ReaderBuilder){
            ((ReaderBuilder) builder).buildReader();
        }
        builder.buildPresenter();
        builder.buildUseCase();
        builder.buildController();
        builder.buildScreen(allScreens);
        builder.presenterSetScreen();
        return builder.getScreen();
    }

    /**
     *
     * @return the name of the screen for the feature. this will be utilized by the JPanel containing every screen
     */

}
