package main_builders_directors;

import javax.swing.*;

public abstract class FeatureDirector {

    /**
     *
     * @return the corresponding builder for the director. As an abstract class, this is implemented by each of the
     * individual directors
     */
    abstract FeatureBuilder getBuilder();

    /**
     * Creates the classes necessary for the feature to function and adhere to clean architecture
     *
     * @param allScreens the JPanel holding all the screens
     * @return the screen corresponding to the feature (ex. AddScreen for AddArchitectureDirector)
     */
    public JPanel createFeature(JPanel allScreens){
        getBuilder().buildPresenter();
        getBuilder().buildUseCase();
        getBuilder().buildController();
        getBuilder().buildScreen(allScreens);
        getBuilder().presenterSetScreen();
        return getBuilder().getScreen();
    }

    /**
     *
     * @return the name of the screen for the feature. this will be utilized by the JPanel containing every screen
     */
    public abstract String getScreenName();
}
