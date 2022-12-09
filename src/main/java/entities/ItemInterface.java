package entities;

import java.util.Date;
import java.util.List;

public interface ItemInterface {
    final int SERIAL_NUMBER_INDEX = 0;
    final int NAME_INDEX = 1;
    final int PRICE_INDEX = 2;
    final int QUANTITY_INDEX = 3;
    final int CATEGORY_INDEX = 4;
    final int DATE_INDEX = 5;
    final int STORAGE_INDEX = 6;

    // tje above fixes the issues of the magic numbers
    public String getSerialNumber();

    public String getName();

    public double getPrice();

    public int getQuantity();

    public List<String> getCategories();

    public Date getExpirationDates();

    public String getStorageLocation();

    public void setQuantity(int quantity);

    public void setPrice(double price);

    public void setCategories(List<String> categories);

    public void setStorageLocation(String storagelocation);

    String[] getStringArrayFormat();
}
