package entities;

import java.util.Date;
import java.util.List;

public interface ItemInterface {
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
