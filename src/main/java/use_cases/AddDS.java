package use_cases;

public class AddDS {

    private String serialNum;
    private int quantity;

    public AddDS(String serialNum, int quantity){
        this.serialNum = serialNum;
        this.quantity = quantity;
    }

    // simple getters to extract the data from AddDS
    public String getSerialNum(){
        return serialNum;
    }

    public int getQuantity(){
        return quantity;
    }
}

