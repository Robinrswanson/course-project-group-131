package screens;

public class FilterScreenInputData {

    String name;
    String serialNum;

    public FilterScreenInputData(String name, String serialNum){
        this.name = name;
        this.serialNum = serialNum;
    }

    public String toString(){
        return this.name;
    }
}

