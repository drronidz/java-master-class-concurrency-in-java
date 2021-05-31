package sample;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/31/2021 , 
    CREATED ON : 11:06 PM
*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class EmployeeService extends Service<ObservableList<String>> {
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names = {
                        "DIAB ABDOU",
                        "OMOR GUEMMAZ",
                        "DIALO ABOU",
                        "DJABAIR DJILALI",
                        "BAARAOUI MAKHLOUF",
                        "MAKHLOUFI MOKHTAR",
                };
                ObservableList<String> employees = FXCollections.observableArrayList();

//                Platform.runLater(() -> listView.setItems(employees));

                for(int i=0; i<6; i++) {
                    employees.add(names[i]);
                    updateMessage("Added " + names[i] + " to the list");
                    updateProgress(i + 1, 6);
                    Thread.sleep(200);
                }
                return employees;
            }
        };
    }
}
