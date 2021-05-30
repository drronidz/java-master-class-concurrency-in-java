package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public ListView listView;

    private Task<ObservableList<String>> task;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                Thread.sleep(1000);
                final ObservableList<String> employees = FXCollections.observableArrayList(
                        "DIAB ABDOU",
                        "OMOR GUEMMAZ",
                        "DIALO ABOU",
                        "DJABAIR DJILALI"
                );


//                Platform.runLater(() -> listView.setItems(employees));
                return employees;
            }
        };

        listView.itemsProperty().bind(task.valueProperty());
    }
    @FXML
    public void buttonPressed(ActionEvent event) {
        new Thread(task).start();

    }
}
