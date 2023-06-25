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
import java.util.ResourceBundle;

public class ControllerClubsearch4 implements Initializable {
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
    private Button back;

    @FXML
    private TableView<CLub> totaltable;

    @FXML
    private TableColumn<CLub, String> countryname;

    @FXML
    private TableColumn<CLub, Double> Numberofplayer;
    ObservableList<CLub>list= FXCollections.observableArrayList();

    @FXML
    void Back(ActionEvent event) {

main.Clubmenu();
    }

    @FXML
    void Searchbtn(ActionEvent event) {
        CLub nad;
      String  str1 = main.getClientName();
        nad = (new clubmethod()).YearlySalary(players, str1);
        list.add(nad);
        countryname.setCellValueFactory(new PropertyValueFactory<CLub,String>("clubName"));
        Numberofplayer.setCellValueFactory(new PropertyValueFactory<CLub,Double>("yearlySalary"));
        totaltable.setItems(list);


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
