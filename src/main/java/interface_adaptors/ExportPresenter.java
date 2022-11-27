package interface_adaptors;

import use_cases.ExportOutputBoundary;

import java.util.List;

public class ExportPresenter implements ExportOutputBoundary {

    public String prepareSuccess(){
        return "Export Successful";
    }
}
