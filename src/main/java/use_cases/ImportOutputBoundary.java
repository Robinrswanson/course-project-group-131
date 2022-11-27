package use_cases;

public interface ImportOutputBoundary {

    public String prepareSuccess(String filepath);

    public String prepareFailure(int value, String[] data);

}
