package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controllerpositionsearch implements Initializable {

    private Container main;
    private ArrayList<Player> players;
    void setList(ArrayList<Player> players)
    {
        this.players=players;

    }

    void SetMain(Container main)
    {
        this.main=main;
    }

    @FXML
    private TextField playernamefield;

    @FXML
    private Button serachbtn;

    @FXML
    private TableView<Player> totaltable;

    @FXML
    private TableColumn<Player, String> Name;

    @FXML
    private TableColumn<Player, String> Country;

    @FXML
    private TableColumn<Player, Integer> Age;

    @FXML
    private TableColumn<Player, Double> Height;

    @FXML
    private TableColumn<Player, String> Clubname;

    @FXML
    private TableColumn<Player, String> Position;

    @FXML
    private TableColumn<Player, Integer> Number;

    @FXML
    private TableColumn<Player, Integer> Weeklysalary;
    @FXML
    private Button back;
    @FXML
    private Label label;

    @FXML
    void Back(ActionEvent event) {
        main.showSearchPlayer();

    }

    ObservableList<Player> list= FXCollections.observableArrayList();


    @FXML
    void Searchbtn(ActionEvent event) {
        ArrayList<Player> nad;
        String str1;

        str1 =playernamefield.getText();
        nad = (new playerMethod()).searchPosition(players, str1);
        if (nad == null)
            main.showAlert1();
        else

        {
            for (Player a:nad)
                list.add(a);
        }
        Name.setCellValueFactory(new PropertyValueFactory<Player,String>("Name"));
        Country.setCellValueFactory(new PropertyValueFactory<Player,String>("Country"));
        Age.setCellValueFactory(new PropertyValueFactory<Player,Integer>("Age"));
        Height.setCellValueFactory(new PropertyValueFactory<Player,Double>("Height"));
        Clubname.setCellValueFactory(new PropertyValueFactory<Player,String>("Clubname"));
        Position.setCellValueFactory(new PropertyValueFactory<Player,String>("Position"));
        Number.setCellValueFactory(new PropertyValueFactory<Player,Integer>("Number"));
        Weeklysalary.setCellValueFactory(new PropertyValueFactory<Player,Integer>("weeklySalary"));
        totaltable.setItems(list);


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
