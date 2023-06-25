package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerBuy implements Initializable {

    private Container main;
    ArrayList<Player> players;
    void setList(ArrayList<Player> players)
    {
        this.players=players;


    }

    void SetMain(Container main)
    {
        temporary=new ArrayList<>();
        this.main=main;
    }


    @FXML
    private Button buy;
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
    private Buy buyobj;
    ArrayList<Player> temporary;

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

        System.out.println("Entering showlist");
        list.removeAll(temporary);
Buy buy=new Buy();
buy.setState(0);
buy.setBuyerClient(main.getClientName());

NetworkUtil nabid=main.getNetworkUtil();
Object obj=null;
        try {
            System.out.println("writting");
            nabid.write(buy);
            System.out.println("reading");
             obj=nabid.read();
            System.out.println("reading done");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(obj instanceof Buy) {
            System.out.println("entered");
            Buy ob1 = (Buy) obj;
            ob1.setState(2);
            buyobj=ob1;
            System.out.println("my query");
            for(Player a:ob1.getAvailablePlayers())
                System.out.println(a);
            System.out.println("halfway there");
            int flag=0;
            for (Player a :ob1.getAvailablePlayers())
            {
                flag=0;
                for(Player b:list)
                {

                    if(b.getName().equals(a.getName()))
                    {
                        flag=-1;
                        break;
                    }
                }
                if(flag==0) {
                    list.add(a);
                    temporary.add(a);
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

        }




    @FXML
    void buybutton(ActionEvent event) {

                Player obja=totaltable.getSelectionModel().getSelectedItem();
                String str=obja.getName();
        buyobj.setDesiredPlayerName(str);
        NetworkUtil nabid=main.getNetworkUtil();
        try {
            nabid.write(buyobj);
            Object o=nabid.read();
            if(o instanceof Buy)
            {
                System.out.println("final object received");
                buyobj=(Buy) o;
                if(buyobj.getBuyerClient().equals(main.getClientName()))
                {
                    System.out.println("reached");
                   ArrayList<Player> temp= main.getPlayers();
                   temp.add(buyobj.getDesiredPlayer());
                    System.out.println("Done adding");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
