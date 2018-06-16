package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.TextField;

import javafx.scene.control.TableView;
import java.awt.*;
import java.io.IOException;

public class Controller {

    int minutesCouter = 0, secondsCounter = 0, milisecondsCounter = 0;
    String minutesDisplay = "", secondsDisplay = "", milisecondsDisplay = "";

    Timeline miliseconds = new Timeline(new KeyFrame(Duration.millis(1), ev -> milisecondsCounter++),
            new KeyFrame(Duration.millis(1), ev -> display()));
    Timeline seconds = new Timeline(new KeyFrame(Duration.seconds(1), ev -> secondsCounter++),
            new KeyFrame(Duration.seconds(1), ev -> display()));
    Timeline minutes = new Timeline(new KeyFrame(Duration.minutes(1), ev -> minutesCouter++),
            new KeyFrame(Duration.minutes(1), ev -> display()));

    @FXML
    public TableView<Measurement> table;
    @FXML
    public TableColumn<Measurement, String> nameColumn;
    @FXML
    public TableColumn<Measurement, String> startTimeColumn;
    @FXML
    public TableColumn<Measurement, String> stopTimeColumn;
    @FXML
    public TableColumn<Measurement, String> resultTimeColumn;


    @FXML
    private Canvas canvas;

    @FXML
    private Label minuteLabel;
    @FXML
    private Label secondLabel;
    @FXML
    private Label milisecondLabel;
    @FXML
    private Label sepLabel;
    @FXML
    private Label dotyLabel;

    public Controller() {
    }

    public void ProgramZamknijButton(ActionEvent ev)
    {
        System.exit(0);
    }

    public void StoperRozpocznijPomiarButton(ActionEvent ev)
    {
        runTime();
    }

    public void StoperZakonczPomiarButton(ActionEvent ev) throws IOException
    {
        miliseconds.stop();
        seconds.stop();
        minutes.stop();

        Stage meaStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("mea.fxml"));
        AnchorPane meaPane = loader.load();
        Scene meaScene = new Scene(meaPane);
        meaStage.setScene(meaScene);
        meaStage.setTitle("Zapisywanie pomiaru");
        meaStage.show();

    }

    public void OAutorzeButton(ActionEvent ev) throws IOException
    {
        Stage meaStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("Author.fxml"));
        AnchorPane meaPane = loader.load();
        Scene meaScene = new Scene(meaPane);
        meaStage.setScene(meaScene);
        meaStage.setTitle("O autorze");
        meaStage.show();
    }

    public  void StoperWyczyscTarczeButton(ActionEvent ev)
    {
        minuteLabel.setText("00");
        secondLabel.setText("00");
        milisecondLabel.setText("0000");
        minutesCouter = 0;
        secondsCounter = 0;
        milisecondsCounter = 0;
        minutesDisplay = "";
        secondsDisplay = "";
        milisecondsDisplay = "";
        initialize();
    }

    public void display()
    {
        setVisible();
        setTime();
        minuteLabel.setText(minutesDisplay);
        secondLabel.setText(secondsDisplay);
        milisecondLabel.setText(milisecondsDisplay);
    }

    public void setTime()
    {
        if(minutesCouter > 59)
            minutesCouter = 0;
        if(secondsCounter > 59)
            secondsCounter = 0;
        if(milisecondsCounter > 1000)
            milisecondsCounter = 0;

        if(minutesCouter < 10)
            minutesDisplay = "0" + minutesCouter;
        else minutesDisplay = "" + minutesCouter;
        if(secondsCounter < 10)
            secondsDisplay = "0" + secondsCounter;
        else secondsDisplay = "" + secondsCounter;
        if(milisecondsCounter < 10)
            milisecondsDisplay = "000" + milisecondsCounter;
        if(milisecondsCounter < 100)
            milisecondsDisplay = "00" + milisecondsCounter;
        if(milisecondsCounter < 1000)
            milisecondsDisplay = "0" + milisecondsCounter;
        else
            milisecondsDisplay = "" + milisecondsCounter;
    }

    public void runTime()
    {
        miliseconds.setCycleCount(Animation.INDEFINITE);
        miliseconds.play();

        seconds.setCycleCount(Animation.INDEFINITE);
        seconds.play();

        minutes.setCycleCount(Animation.INDEFINITE);
        minutes.play();
    }

    void setVisible()
    {
        milisecondLabel.setVisible(true);
        secondLabel.setVisible(true);
        minuteLabel.setVisible(true);
    }

    @FXML

    void initialize()
    {
        if(minuteLabel.getText().equals("00") && secondLabel.getText().equals("00")&& milisecondLabel.getText().equals("0000"))
        {
            Timeline minutes = new Timeline(new KeyFrame(Duration.seconds(2), evt -> minuteLabel.setVisible(false)),
                    new KeyFrame(Duration.seconds(1), evt -> minuteLabel.setVisible(true)));
            minutes.setCycleCount(Animation.INDEFINITE);
            minutes.play();
            Timeline seconds = new Timeline(new KeyFrame(Duration.seconds(2), evt -> secondLabel.setVisible(false)),
                    new KeyFrame(Duration.seconds(1), evt -> secondLabel.setVisible(true)));
            seconds.setCycleCount(Animation.INDEFINITE);
            seconds.play();
            /*Timeline separator = new Timeline(new KeyFrame(Duration.seconds(2), evt -> sepLabel.setVisible(false)),
                    new KeyFrame(Duration.seconds(1), evt -> sepLabel.setVisible(true)));
            separator.setCycleCount(Animation.INDEFINITE);
            separator.play();
            Timeline dot = new Timeline(new KeyFrame(Duration.seconds(2), evt -> dotyLabel.setVisible(false)),
                    new KeyFrame(Duration.seconds(1), evt -> dotyLabel.setVisible(true)));
            dot.setCycleCount(Animation.INDEFINITE);
            dot.play();*/
            Timeline miliseconds = new Timeline(new KeyFrame(Duration.seconds(2), evt -> milisecondLabel.setVisible(false)),
                    new KeyFrame(Duration.seconds(1), evt -> milisecondLabel.setVisible(true)));
            miliseconds.setCycleCount(Animation.INDEFINITE);
            miliseconds.play();
        }
        else
            setVisible();
    }
}
