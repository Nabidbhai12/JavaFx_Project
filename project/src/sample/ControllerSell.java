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
import java.util.concurrent.ForkJoinPool;

public class ControllerSell implements Initializable {
    private Container main;
    ArrayList<Player> players;
    void setList(ArrayList<Player> players)
    {
        this.players=players;
    }

    void SetMain(Container main)
    {
        this.main=main;
    }


    @FXML
    private Button sell;
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
    private Button showList;
    ObservableList<Player> list= FXCollections.observableArrayList();

    @FXML
    void Back(ActionEvent event) {
main.showHomepage();
    }

    @FXML
    void Showlist(ActionEvent event) {
        for(Player a:players)
            list.remove(a);
        System.out.println("pressed");
        if(players==null)
            label.setText("Sorry");
        else {
            int flag=0;
            for (Player a : players) {
                System.out.println(a);
                flag=0;
                for (Sell b:main.getSellrequest()) {
                    if (b.getPlayerName().equals(a.getName())) {
                        flag = -1;
                        break;
                    }
                }
                    if(flag==0) {
                        list.add(a);
                        System.out.println(a);
                    }
                }
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


    @FXML
    void sellbtn(ActionEvent event) {
        try {
            System.out.println("pressed sell button");
            Object obja=totaltable.getSelectionModel().getSelectedItem();

            String str1 =((Player) obja).getName();
            String str ="100";


                    Sell sell = new Sell();
                    int flag = 0;
                    for (Player a : players) {
                        if (a.getName().equals(str1)) {
                            flag++;
                            sell.setClientName(a.getClubname());
                            sell.setPlayer(a);
                            sell.setPlayerName(a.getName());
                            sell.setPrice(Double.parseDouble(str));
                        }
                    }
                    if (flag == 0)
                        System.out.println("Writing ....");
                    NetworkUtil ob1 = main.getNetworkUtil();
                    main.Addsell(sell);
                    ob1.write(sell);
                    System.out.println("writing done from client side of sell class");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
