package use_cases;

public interface ImportOutputBoundary {

    public String prepareSuccess(); // display if the use case succeeded

    public String prepareFailure(int value, AddDS data); //Display if the use case failed

}
