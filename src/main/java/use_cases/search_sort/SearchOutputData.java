package use_cases.search_sort;

public class SearchOutputData {

    private boolean searchSuccess;
    private String serialNumber;

    /**
     * Sets whether the search was successful
     * @param value whether the search is successful
     */
    public void setSearchSuccess(boolean value){
        searchSuccess = value;
    }

    /**
     *
     * @param serialNumber The serial number of the item to output
     */
    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }

    /**
     *
     * @return the serial number of the item
     */
    public String getSerialNumber(){
        return this.serialNumber;
    }

    /**
     *
     * @return whether the search was successful or not
     */
    public boolean getSearchSuccess(){
        return this.getSearchSuccess();
    }

}
