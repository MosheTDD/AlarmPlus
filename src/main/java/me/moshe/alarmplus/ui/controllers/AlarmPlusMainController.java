package me.moshe.alarmplus.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import me.moshe.alarmplus.AlarmPlus;

import java.net.URL;
import java.util.ResourceBundle;

public class AlarmPlusMainController implements Initializable {
    ObservableList<Integer> hours = FXCollections
            .observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);
    ObservableList<Integer> minutes = FXCollections
            .observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
                    33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59);
    @FXML
    private Label TIMESETMESSAGE;

    @FXML
    private Label TIMEUNTILMESSAGE;

    @FXML
    private ComboBox HOURDROPDOWN;

    @FXML
    private ComboBox MINUTEDROPDOWN;

    @FXML
    public AnchorPane ANCHOR;

    @FXML
    public void focus(){
        ANCHOR.requestFocus();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HOURDROPDOWN.setItems(hours);
        MINUTEDROPDOWN.setItems(minutes);
        TIMESETMESSAGE.setText(AlarmPlus.timeSet);
        TIMEUNTILMESSAGE.setText(AlarmPlus.timeUntil);
    }

    @FXML
    public void setAlarm(){
        AlarmPlus.calculateTime((int) HOURDROPDOWN.getValue(), (int) MINUTEDROPDOWN.getValue());
        TIMESETMESSAGE.setText(AlarmPlus.timeSet);
        TIMEUNTILMESSAGE.setText(AlarmPlus.timeUntil);
    }
}
