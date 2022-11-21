package use_cases;

public interface UpdateOutputBoundary {

    int NEGATIVE_DOUBLE_ERROR = 0; // error code for if a negative double was selected for price
    int SERIAL_NUM_NOT_FOUND_ERROR = 1; // error code for if the entered serial number is not found
    int NOT_RIGHTS_TO_ACCESS = 2; // error code for if an employee(not the manager) wants to update the price

    public String prepareSuccess(UpdateDS data); // display for if the Update Use Case is successful
    public String prepareFailure(int error); // display for if the Update Use Case is unsuccessful
}
