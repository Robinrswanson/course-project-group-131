package UseCases;

public interface AddOutputBoundary {

    int NEGATIVE_INT_ERROR = 0; // error code for if a negative integer was selected for quantity
    int SERIAL_NUM_NOT_FOUND_ERROR = 1; // error code for if the entered serial number is not found (will replace)

    String prepareSuccess(AddDS data); // display for if the Add Use Case is successful
    String prepareFailure(int error); // display for if the Add Use Case is unsuccessful

}

