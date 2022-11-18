public class Employee {
    private final String username;
    private final String password;

    Employee(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean getUpdateItem(){
        return true;
    }

    public boolean getUpdatePrice(){
        return false;
    }
}
