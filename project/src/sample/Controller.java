package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;

import static javafx.application.Platform.exit;


public class Controller {
    ArrayList<Player> players;
    void setList(ArrayList<Player> players) {
        this.players = players;

    }
    private Container main;
    void SetMain(Container main)
    {
        this.main=main;
    }
    @FXML
    private Button searchplayers;

    @FXML
    private Button searchclubs;

    @FXML
    private Button addplayers;

    @FXML
    private Button exit;
    @FXML
    private Button Sell;

    @FXML
    private Button Buy;

    @FXML
    void AddPlayers(ActionEvent event) {
        main.Addplayer();

    }
    @FXML
    void Buymethod(ActionEvent event) {
main.showbuy();
    }
    @FXML
    void Sellmethod(ActionEvent event) {
main.ShowSell();
    }

    @FXML
    void Exit(ActionEvent event) {
        //new Filemehtod().writeFile("players.txt",players);

exit();

    }

    @FXML
    void Searchclubs(ActionEvent event) {
        main.Clubmenu();


    }

    @FXML
    void Searchplayers(ActionEvent event) {
        main.showSearchPlayer();
    }


}
