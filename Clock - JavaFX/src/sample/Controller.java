package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

import javax.swing.*;
import javax.swing.text.Element;
import javax.swing.text.TabableView;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;

import static javafx.scene.input.KeyCode.F;


public class Controller
{



    @FXML
    private Canvas myCanvas = new Canvas();

    @FXML
    public TableView<Alarm> table = new TableView<>();

    @FXML
    private TableColumn<Alarm, Integer> hourCol = new TableColumn<>("Godzina");
    @FXML
    private TableColumn<Alarm, Integer> minuteCol = new TableColumn<>("Minuta");
    @FXML
    private TableColumn<Alarm, Boolean> activeCol = new TableColumn<>("Aktywny");

    @FXML
    private MenuItem mnitZamknij = new MenuItem("Zamknij");

    @FXML
    private MenuItem mnitWyczysc = new MenuItem("Wyczyść alarmy");

    @FXML
    private MenuItem mnitDodaj = new MenuItem("Dodaj alarm");

    @FXML
    private Button btOdswiez = new Button("Odśwież");

    @FXML
    private Menu mnAutor = new Menu();



    @FXML
    void initialize() throws IllegalTimeValueException {

        LocalTime time = LocalTime.now();

       /* myCanvas.widthProperty().bind(gPane.widthProperty());
        myCanvas.heightProperty().bind(gPane.heightProperty());
*/
        GraphicsContext gc = myCanvas.getGraphicsContext2D();
        myCanvas.isResizable();
        gc.setFill(Color.LAVENDER);
        gc.fillRect(0, 0, 1000, 300);


        //drawClock( gc );
        double marginX = 50;
        double marginY = 38;

        double lengthOfSegmentVertical = 95;
        double lengthOfSegmentHorizontal = 85;
        double penSize = 7;
        double space = 6;
        double spaceBetweenNumbers = 23;
        double separatorY = 92;
        double separatorSize = 30;


        double marginX1hour = 50;
        double marginX2hour = marginX + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers;
        double marginX1minute = marginX + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + spaceBetweenNumbers + separatorSize + spaceBetweenNumbers * 2;
        double marginX2minute = marginX + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + spaceBetweenNumbers + separatorSize + spaceBetweenNumbers * 2 + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers;
        double marginX1second = marginX + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + spaceBetweenNumbers + separatorSize + spaceBetweenNumbers * 2 + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers * 3;
        double marginX2second = marginX + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + separatorSize + spaceBetweenNumbers * 2 + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + spaceBetweenNumbers + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers;

        double separatorX1 = marginX + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + spaceBetweenNumbers;
        double separatorX2 = marginX + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + spaceBetweenNumbers + separatorSize + spaceBetweenNumbers * 2 + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers + penSize + space + lengthOfSegmentHorizontal + space + penSize
                + spaceBetweenNumbers;

        double separatorY2 = separatorY * 1.1;
        double marginYsecond = marginY + 25;
        double lengthOfSegmentHorizontalSecond = lengthOfSegmentHorizontal * 0.7;
        double lengthOfSegmentVerticalSecond = lengthOfSegmentVertical * 0.7;
        double spaceSecond = space * 0.7;
        double separatorSize2 = separatorSize * 0.7;


        drawSeparator(gc, separatorX1, separatorY, separatorSize);
        drawSeparator(gc, separatorX2, separatorY2, separatorSize2);

        Timeline clockTimeline = new Timeline();



        KeyFrame clockKF = new KeyFrame(
                Duration.millis(1000),
                ae -> {
                    LocalTime nowTime = LocalTime.now();


                    checkNumber(nowTime.getHour() / 10, gc, marginX1hour, marginY, penSize, lengthOfSegmentHorizontal, lengthOfSegmentVertical, space);
                    checkNumber(nowTime.getHour() % 10, gc, marginX2hour, marginY, penSize, lengthOfSegmentHorizontal, lengthOfSegmentVertical, space);


                    checkNumber(nowTime.getMinute() / 10, gc, marginX1minute, marginY, penSize, lengthOfSegmentHorizontal, lengthOfSegmentVertical, space);
                    checkNumber(nowTime.getMinute() % 10, gc, marginX2minute, marginY, penSize, lengthOfSegmentHorizontal, lengthOfSegmentVertical, space);


                    checkNumber(nowTime.getSecond() / 10, gc, marginX1second, marginYsecond, penSize, lengthOfSegmentHorizontalSecond, lengthOfSegmentVerticalSecond, space * 0.7);

                    checkNumber(nowTime.getSecond() % 10, gc, marginX2second, marginYsecond, penSize, lengthOfSegmentHorizontalSecond,
                            lengthOfSegmentVerticalSecond, spaceSecond);
                });


        clockTimeline.getKeyFrames().add(clockKF);

        clockTimeline.setCycleCount(Animation.INDEFINITE);

        clockTimeline.play();




        Label placeholder = new Label();
        placeholder.setText("Nic do wyświetlenia");
        table.setPlaceholder(placeholder);

        final ObservableList<Alarm> data = FXCollections.observableArrayList(
                new Alarm(13, 50, true),
                new Alarm(14, 57, false),
                new Alarm(14, 59, true),
                new Alarm(14, 47, true)

                );


        hourCol.setCellValueFactory(new PropertyValueFactory<Alarm, Integer>("hour"));
        minuteCol.setCellValueFactory(new PropertyValueFactory<Alarm, Integer>("minute"));
        activeCol.setCellValueFactory(new PropertyValueFactory<Alarm, Boolean>("isActive"));

        table.setItems(data);


        Timeline alarmTimeline = new Timeline();


        KeyFrame alarmKF = new KeyFrame(
                Duration.millis(1000),
                action -> {
                    LocalTime nowTimeAlarm = LocalTime.now();

                    if(nowTimeAlarm.getHour() == 14 && nowTimeAlarm.getMinute() == 9){
                        MediaPlayer mp = new MediaPlayer(new Media(
                                Paths.get("C://Users/karol/OneDrive/Pulpit/Java-projects/clock/src/sample/Bell.mp3").toUri().toString()));
                        mp.play();

                    }

                    Alarm a = null;
                    try {
                        a = new Alarm(nowTimeAlarm.getHour(),nowTimeAlarm.getMinute(),true);
                    } catch (IllegalTimeValueException e) {
                        e.printStackTrace();
                    }

                    if(table.getItems().contains(a)){
                        MediaPlayer mp = new MediaPlayer(new Media(
                                Paths.get("C://Users/karol/OneDrive/Pulpit/Java-projects/clock/src/sample/Bell.mp3").toUri().toString()));
                        mp.play();
                    }
                }
        );

        alarmTimeline.getKeyFrames().add(alarmKF);
        alarmTimeline.setCycleCount(Animation.INDEFINITE);
        alarmTimeline.play();



        table.setRowFactory(
                new Callback<TableView<Alarm>, TableRow<Alarm>>() {
                    @Override
                    public TableRow<Alarm> call(TableView<Alarm> tableView) {
                        final TableRow<Alarm> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();
                        MenuItem editItem = new MenuItem("Edit");
                        editItem.setOnAction(event -> {

                            String hourEdit = JOptionPane.showInputDialog("Wpisz godzinę: " );
                            String minuteEdit = JOptionPane.showInputDialog("Wpisz minuty: " );

                            int hourEditInt = Integer.parseInt(hourEdit);
                            int minuteEditInt = Integer.parseInt(minuteEdit);
                            boolean yn;

                            if (JOptionPane.showConfirmDialog(null, "Aktywować alarm? ", "Aktywacja",
                                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                               yn = true;
                            } else {
                                yn = false;
                            }


                            Alarm al = null;
                            try {
                                al = new Alarm(hourEditInt, minuteEditInt, yn);
                            } catch (IllegalTimeValueException e) {
                                e.printStackTrace();
                            }


                            table.getItems().set(row.getIndex(), al);



                        });
                        MenuItem removeItem = new MenuItem("Delete");
                        removeItem.setOnAction(event -> table.getItems().remove(row.getItem()));
                        rowMenu.getItems().addAll(editItem, removeItem);


                        // tylko dla non-null Alarm:    otherwise(ContextMenu)null));
                        row.contextMenuProperty().bind(
                                Bindings.when(Bindings.isNotNull(row.itemProperty()))
                                        .then(rowMenu).otherwise(rowMenu));//(ContextMenu)null));

                        return row;
                    }
                });

        btOdswiez.setOnAction(event -> {
            table.refresh();
            table.refresh();
        });



        mnitZamknij.setOnAction( event -> System.exit(0));
        mnitWyczysc.setOnAction( event -> table.getItems().removeAll(table.getItems()) );
        mnitDodaj.setOnAction( (ActionEvent event) -> {


            Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("AddAlarm.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Stage stage = new Stage();
                    stage.setTitle("Dodaj alarm");
                    if (root != null) {
                        stage.setScene(new Scene(root, 600, 400));
                    }
                    stage.show();
        });

        btOdswiez.setOnAction( event -> {
            if (ControllerAddAlarm.zatwierdzClicked == true) {

                Alarm alarm = new Alarm(ControllerAddAlarm.aaa);


                //data.addAll(ControllerAddAlarm.aaa);
                data.add(alarm);

                ControllerAddAlarm.zatwierdzClicked = false;
                table.refresh();
            }

        });


        Label menuLabel = new Label("O Autorze");
        menuLabel.setOnMouseClicked(event -> {

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("AboutAuthor.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Autor");
            if (root != null) {
                stage.setScene(new Scene(root, 600, 400));
            }
            stage.show();

        });
        mnAutor.setGraphic(menuLabel);


        table.refresh();

        //});


    }


    private void checkNumber(int time, GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                             double lengthVertical, double space){
            switch (time) {
            case 1:
                draw1(gc, upperLeftX, marginY, strong, lengthHorizontal, lengthVertical, space);
                break;
            case 2:
                draw2(gc, upperLeftX, marginY, strong, lengthHorizontal, lengthVertical, space);
                break;
            case 3:
                draw3(gc, upperLeftX, marginY, strong, lengthHorizontal, lengthVertical, space);
                break;
            case 4:
                draw4(gc, upperLeftX, marginY, strong, lengthHorizontal, lengthVertical, space);
                break;
            case 5:
                draw5(gc, upperLeftX, marginY, strong, lengthHorizontal, lengthVertical, space);
                break;
            case 6:
                draw6(gc, upperLeftX, marginY, strong, lengthHorizontal, lengthVertical, space);
                break;
            case 7:
                draw7(gc, upperLeftX, marginY, strong, lengthHorizontal, lengthVertical, space);
                break;
            case 8:
                draw8(gc, upperLeftX, marginY, strong, lengthHorizontal, lengthVertical, space);
                break;
            case 9:
                draw9(gc, upperLeftX, marginY, strong, lengthHorizontal, lengthVertical, space);
                break;
            case 0:
                draw0(gc, upperLeftX, marginY, strong, lengthHorizontal, lengthVertical, space);
                break;
        }
    }

    private void drawNULL (GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                         double lengthVertical, double space){

        gc.setStroke(Color.LIGHTGREY);
        gc.setFill(Color.LAVENDER);

        gc.strokeRect(upperLeftX, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY, strong, lengthVertical);


        gc.strokeRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);


        gc.strokeRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);
        gc.fillRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);


        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );


        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);


        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);


        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);

    }
    private void draw0 (GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                           double lengthVertical, double space){

        gc.setStroke(Color.LIGHTGREY);
        gc.setFill(Color.DARKBLUE);

        gc.strokeRect(upperLeftX, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY, strong, lengthVertical);


        gc.strokeRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);


        gc.strokeRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);
        gc.fillRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);


        gc.setFill(Color.LAVENDER);
        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );


        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);


        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);


        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);

    }
    private void draw1 (GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                        double lengthVertical, double space){

        gc.setFill(Color.LAVENDER);
        gc.setStroke(Color.LIGHTGREY);

        gc.strokeRect(upperLeftX, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY, strong, lengthVertical);


        gc.strokeRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);


        gc.strokeRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);
        gc.fillRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);


        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );


        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);


        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);


        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);

    }
    private void draw2 (GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                        double lengthVertical, double space){

        gc.setStroke(Color.LIGHTGREY);


        gc.setFill(Color.LAVENDER);
        gc.strokeRect(upperLeftX, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY, strong, lengthVertical);


        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);

        gc.strokeRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);
        gc.fillRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);

        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );

        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);

        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);

        gc.setFill(Color.LAVENDER);
        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);


    }
    private void draw3 (GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                        double lengthVertical, double space){

        gc.setFill(Color.LAVENDER);
        gc.setStroke(Color.LIGHTGREY);

        gc.strokeRect(upperLeftX, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY, strong, lengthVertical);


        gc.strokeRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);


        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);
        gc.fillRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);


        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );


        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);


        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);


        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);

    }
    private void draw4 (GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                        double lengthVertical, double space){


        gc.setStroke(Color.LIGHTGREY);

        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY, strong, lengthVertical);

        gc.setFill(Color.LAVENDER);
        gc.strokeRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);


        gc.strokeRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);
        gc.fillRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);

        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );

        gc.setFill(Color.LAVENDER);
        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);


        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);


        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);

    }
    private void draw5 (GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                        double lengthVertical, double space){

        gc.setStroke(Color.LIGHTGREY);

        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY, strong, lengthVertical);

        gc.setFill(Color.LAVENDER);
        gc.strokeRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);

        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);
        gc.fillRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);

        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );

        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);

        gc.setFill(Color.LAVENDER);
        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);

        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);

    }
    private void draw6 (GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                        double lengthVertical, double space){

        gc.setStroke(Color.LIGHTGREY);

        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY, strong, lengthVertical);

        gc.strokeRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);

        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);
        gc.fillRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);

        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );

        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);

        gc.setFill(Color.LAVENDER);
        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);

        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);

    }
    private void draw7 (GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                        double lengthVertical, double space){

        gc.setFill(Color.LAVENDER);
        gc.setStroke(Color.LIGHTGREY);

        gc.strokeRect(upperLeftX, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY, strong, lengthVertical);


        gc.strokeRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);


        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);
        gc.fillRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);

        gc.setFill(Color.LAVENDER);
        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );


        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);


        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);


        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);

    }
    private void draw8 (GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                        double lengthVertical, double space){

        gc.setFill(Color.DARKBLUE);
        gc.setStroke(Color.LIGHTGREY);

        gc.strokeRect(upperLeftX, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY, strong, lengthVertical);

        gc.strokeRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);

        gc.strokeRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);
        gc.fillRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);

        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );

        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);

        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);

        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);

    }
    private void draw9 (GraphicsContext gc, double upperLeftX, double marginY, double strong, double lengthHorizontal,
                        double lengthVertical, double space){
        gc.setFill(Color.DARKBLUE);
        gc.setStroke(Color.LIGHTGREY);

        gc.strokeRect(upperLeftX, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY, strong, lengthVertical);

        gc.setFill(Color.LAVENDER);
        gc.strokeRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX, marginY + lengthVertical + space , strong, lengthVertical);

        gc.setFill(Color.DARKBLUE);
        gc.strokeRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);
        gc.fillRect(upperLeftX + strong + space, marginY, lengthHorizontal, strong);

        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical , lengthHorizontal, strong );

        gc.strokeRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);
        gc.fillRect(upperLeftX + strong + space, marginY + lengthVertical+ strong + lengthVertical, lengthHorizontal ,strong);

        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY, strong, lengthVertical);

        gc.strokeRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);
        gc.fillRect(upperLeftX + strong + space + lengthHorizontal + space, marginY + lengthVertical + space , strong, lengthVertical);

    }

    private void drawSeparator (GraphicsContext gc, double upperLeftX, double y, double size){

            Timeline timeline = new Timeline();


            KeyFrame kf = new KeyFrame(
                    Duration.millis(1000),
                    ae -> {

                        gc.setFill(Color.LAVENDER);
                        gc.fillRect(upperLeftX, y, size, size);
                        gc.fillRect(upperLeftX, y + size * 2, size, size);

                    });

            KeyFrame kf1 = new KeyFrame(
                    Duration.millis(500),
                    ae -> {

                        gc.setFill(Color.INDIGO);
                        gc.fillRect(upperLeftX, y, size, size);
                        gc.fillRect(upperLeftX, y + size * 2, size, size);


                    });


            timeline.getKeyFrames().addAll(kf, kf1);

            timeline.setCycleCount(Animation.INDEFINITE);

            timeline.play();


    }

}