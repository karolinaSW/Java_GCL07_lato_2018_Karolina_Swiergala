package sample;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;

public class ControllerAddAlarm {


    public static boolean zatwierdzClicked = false;

    public static int hour = 0;
    public static int minute = 0;
    public static boolean active = false;

    public static Alarm aaa;

    static {
        try {
            aaa = new Alarm(hour,minute,active);
        } catch (IllegalTimeValueException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private ChoiceBox<Integer> chbMinute = new ChoiceBox<>();

    @FXML
    private ChoiceBox<Integer> chbHour = new ChoiceBox<>();

    @FXML
    private ChoiceBox<Boolean> chbActivate = new ChoiceBox<>();

    @FXML
    private Button btAnuluj = new Button("Anuluj");

    @FXML
    private Button btZatwierdz = new Button("Zatwierdź");



    @FXML
    void initialize(){

        zatwierdzClicked = false;

        chbHour.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);

        chbMinute.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,18,20,21,22,23,24,25,26,27,
                28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59);
        //chbMinute.setValue(0);

        chbActivate.getItems().addAll(true, false);
        //chbActivate.setValue(true);

        btAnuluj.setOnAction(event -> {


            btAnuluj.getScene().getWindow().hide();
        });
        btZatwierdz.setOnAction( event -> {


            hour = chbHour.getValue();
            minute = chbMinute.getValue();
            active = chbActivate.getValue();

            try {

                aaa.setHour(hour);
                aaa.setMinute(minute);
                aaa.setIsActive(active);
            } catch (IllegalTimeValueException e) {
                e.printStackTrace();
            }

            zatwierdzClicked = true;

            btZatwierdz.getScene().getWindow().hide();


        });

    }

}
