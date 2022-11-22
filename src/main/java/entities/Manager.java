package entities;

public class Manager extends Employee {

    Manager(String username, String password) {
        super(username, password);
    }

    public String getUsername() {
        return super.getUsername();
    }

    public String getPassword() {
        return super.getPassword();
    }

    public boolean getUpdateItem() {
        return true;
    }

    public boolean getUpdatePrice() {
        return true;
    }
}