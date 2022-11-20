package Screens;

public class FilterScreenDS {

    String name;
    String serialNum;

    public FilterScreenDS(String name, String serialNum){
        this.name = name;
        this.serialNum = serialNum;
    }

    public String toString(){
        return this.name;
    }
}

