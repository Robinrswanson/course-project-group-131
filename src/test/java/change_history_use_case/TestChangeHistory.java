package change_history_use_case;

import change_history_use_case.ChangeHistory;
import org.testng.annotations.Test;
//This test is for testing the changehistory usecase
public class TestChangeHistory {
    @Test
    void create(){
        ChangeHistory testsample = new ChangeHistory("Daisy","Add","Apple","1","apple123");
        testsample.save_history_change();
    }


}
