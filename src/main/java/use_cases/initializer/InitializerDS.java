package use_cases.initializer;

import java.util.List;

public class InitializerDS {

    List<String[]> inventory;

    public InitializerDS(List<String[]> inventory){
        this.inventory = inventory;
    }

    // simple getters to extract the data from InitializerDS
    public List<String[]> getInventory(){
        return inventory;
    }
}
