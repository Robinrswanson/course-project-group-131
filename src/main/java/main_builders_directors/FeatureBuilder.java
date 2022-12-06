package main_builders_directors;

import javax.swing.*;

public interface FeatureBuilder {

    // the methods necessary to create all the classes for a feature
    void buildPresenter();
    void buildUseCase();
    void buildController();
    void buildScreen(JPanel allScreens);
    void presenterSetScreen();

    JPanel getScreen();
    // no changes?

    String getScreenName();

}
