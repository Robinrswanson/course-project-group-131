package main_builders_directors;

import interface_adaptors.arr.*;
import screens.RemoveScreen;
import screens.ReturnScreen;
import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARROutputBoundary;
import use_cases.arr.RemoveUseCase;
import use_cases.arr.ReturnUseCase;

import javax.swing.*;

public class RemoveFeatureBuilder implements FeatureBuilder {

        private ARRIView removeScreen;
        private ARRInputBoundary removeUseCase;
        private RemoveController removeController;
        private ARROutputBoundary removePresenter;
        private String userName;

        public RemoveFeatureBuilder(String userName)
        {
            this.userName = userName;
        }

        public void buildPresenter()
        {
            removePresenter = new RemovePresenter();
        }

        public void buildUseCase()
        {
            removeUseCase = new RemoveUseCase(removePresenter);
        }

        public void buildController()
        {
            removeController = new RemoveController(removeUseCase, userName);
        }

        public void buildScreen(JPanel Screens)
        {
            removeScreen = new RemoveScreen(Screens, removeController);
        }

        public void presenterSetScreen()
        {
            removePresenter.setScreen(removeScreen);
        }

        public JPanel getScreen()
        {
            return (JPanel)removeScreen;
        }

        public String getScreenName()
        {
            return ARRIView.REMOVE_SCREEN_NAME_CONSTANT;
        }

    }
