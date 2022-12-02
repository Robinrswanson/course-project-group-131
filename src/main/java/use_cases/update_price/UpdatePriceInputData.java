package use_cases.update_price;

public class UpdatePriceInputData {

    private String serialNum;
    private double price;

    private boolean updatePrice;

    public UpdatePriceInputData(String serialNum, double price, boolean updatePrice){
        this.serialNum = serialNum;
        this.price = price;
        this.updatePrice = updatePrice;
    }

    public String getSerialNum(){
        return this.serialNum;
    }

    public double getPrice(){
        return this.price;
    }

    public boolean getUpdatePrice(){
        return this.updatePrice;
    }
}
