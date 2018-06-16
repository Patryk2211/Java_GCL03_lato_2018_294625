package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Controller.*;

public class Mea {

    FXMLLoader fxmlLoader1;
    Controller controller;
    ObservableList<Measurement> items;



    @FXML
    public void initalize()
    {
        fxmlLoader1 = new FXMLLoader(getClass().getResource("sample.fxml"));
        controller = fxmlLoader1.getController();
        items = FXCollections.observableArrayList();
    }


    @FXML
    public TextField textName;


    public void anulujButton(ActionEvent ev)
    {
        System.out.println("Zapis anulowany");
    }

    public void dodajButton(ActionEvent ev)
    {
        controller.table.setItems(getItems());
    }

    public ObservableList<Measurement> getItems()
    {
        String text = textName.getText();
        items.add(new Measurement(text, "22:18", "22:22", "" + controller.minutesCouter + ":" + controller.secondsCounter + "." + controller.milisecondsCounter));

        return items;
    }
}


