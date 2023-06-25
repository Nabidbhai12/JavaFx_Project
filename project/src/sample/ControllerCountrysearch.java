package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class ControllerCountrysearch implements Initializable {
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
    private Button serachbtn;

    @FXML
    private Button back;

    @FXML
    private TableView<Country> totaltable;

    @FXML
    private TableColumn<Country, String> countryname;

    @FXML
    private TableColumn<Country, Integer> Numberofplayer;
ObservableList<Country>list=FXCollections.observableArrayList();
    @FXML
    void Back(ActionEvent event) {
        main.showSearchPlayer();

    }

    @FXML
    void Searchbtn(ActionEvent event) {
        ArrayList<Country> nad;
       nad= new playerMethod().PlayerCount(players);
for(Country a:nad)
{
    System.out.println(a.getName());
    list.add(a);
}
countryname.setCellValueFactory(new PropertyValueFactory<Country,String>("Name"));
        Numberofplayer.setCellValueFactory(new PropertyValueFactory<Country,Integer>("NoofPlayers"));
totaltable.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
