package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public ListView listView;

    @FXML
    public ProgressBar progressBar;

    @FXML
    public Label progressLabel;

    private Task<ObservableList<String>> task;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        task = new Task<ObservableList<String>>() {
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
        progressBar.progressProperty().bind(task.progressProperty());
        progressLabel.textProperty().bind(task.messageProperty());
        listView.itemsProperty().bind(task.valueProperty());
    }
    @FXML
    public void buttonPressed(ActionEvent event) {
        new Thread(task).start();

    }
}
