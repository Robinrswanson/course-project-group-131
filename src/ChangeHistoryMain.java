import change_history_use_case.ChangeHistory;

public class ChangeHistoryMain {
    public ChangeHistoryMain(String[] args){
        String name = "Evan";
        String serium = "000001";
        String action = "Add";
        String item = "Fruit";
        String quantity = "10";
        ChangeHistory h = new ChangeHistory(name,action,item,quantity,serium);
        h.save_history_change();
    }
}
