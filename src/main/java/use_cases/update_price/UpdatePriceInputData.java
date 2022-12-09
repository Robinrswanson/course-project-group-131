package use_cases.update_price;

public class UpdatePriceInputData {

    private String serialNum;
    private double price;


    public UpdatePriceInputData(String serialNum, double price){
        this.serialNum = serialNum;
        this.price = price;
    }

    public String getSerialNum(){
        return this.serialNum;
    }

    public double getPrice(){
        return this.price;
    }
}
