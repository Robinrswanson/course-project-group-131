package main_builders_directors;

import interface_adaptors.arr.ARRIView;
import interface_adaptors.arr.ReturnController;
import interface_adaptors.arr.ReturnPresenter;
import screens.ReturnScreen;
import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARROutputBoundary;
import use_cases.arr.ReturnUseCase;

import javax.swing.*;

public class ReturnFeatureBuilder implements FeatureBuilder{

    private ARRIView returnScreen;
    private ARRInputBoundary returnUseCase;
    private ReturnController returnController;
    private ARROutputBoundary returnPresenter;
    private String userName;

    public ReturnFeatureBuilder(String userName)
    {
        this.userName = userName;
    }

    public void buildPresenter()
    {
        returnPresenter = new ReturnPresenter();
    }

    public void buildUseCase()
    {
        returnUseCase = new ReturnUseCase(returnPresenter);
    }

    public void buildController()
    {
        returnController = new ReturnController(returnUseCase, userName);
    }

    public void buildScreen(JPanel Screens)
    {
        returnScreen = new ReturnScreen(Screens, returnController);
    }

    public void presenterSetScreen()
    {
        returnPresenter.setScreen(returnScreen);
    }

    public JPanel getScreen()
    {
        return (JPanel)returnScreen;
    }

    public String getScreenName()
    {
        return ARRIView.RETURN_SCREEN_NAME_CONSTANT;
    }
}
