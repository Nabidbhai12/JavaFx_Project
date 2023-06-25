package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ControllerClubsearch3 {

    private Container main;
    private ArrayList<Player> players;

    void setList(ArrayList<Player> players) {
        this.players = players;

    }

    void SetMain(Container main) {
        this.main = main;
    }


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
    void Back(ActionEvent event) {
        main.Clubmenu();

    }

    ObservableList<Player> list = FXCollections.observableArrayList();

    @FXML
    void Searchbtn(ActionEvent event) {
        ArrayList<Player> nad;
        String str1 = main.getClientName();
        nad = (new clubmethod()).MaximumHeight(players, str1);
        if (nad == null)
            System.out.println("Error Club not found");
        else {
            for (Player a : nad)
                list.add(a);
        }
        Name.setCellValueFactory(new PropertyValueFactory<Player, String>("Name"));
        Country.setCellValueFactory(new PropertyValueFactory<Player, String>("Country"));
        Age.setCellValueFactory(new PropertyValueFactory<Player, Integer>("Age"));
        Height.setCellValueFactory(new PropertyValueFactory<Player, Double>("Height"));
        Clubname.setCellValueFactory(new PropertyValueFactory<Player, String>("Clubname"));
        Position.setCellValueFactory(new PropertyValueFactory<Player, String>("Position"));
        Number.setCellValueFactory(new PropertyValueFactory<Player, Integer>("Number"));
        Weeklysalary.setCellValueFactory(new PropertyValueFactory<Player, Integer>("weeklySalary"));
        totaltable.setItems(list);

    }
}
