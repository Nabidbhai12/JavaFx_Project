package sample;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class Controller3 {

    private CLub[] Clubs;
    private Container main;
    private ArrayList<Player> players;
    private ArrayList<String> nabid1;
    void SetMain(Container main) {
        this.main = main;
    }


    void setList(ArrayList<Player> players) {
        this.players = players;

    }

    void setList2(CLub[] cLub) {
        Clubs = cLub;
    }

    void setList3(ArrayList<String> nabid1) {
        this.nabid1 = nabid1;
    }

    @FXML
    private TextField Name;

    @FXML
    private TextField Country;

    @FXML
    private TextField clubname;

    @FXML
    private TextField Position;

    @FXML
    private TextField Age;

    @FXML
    private TextField Height;

    @FXML
    private TextField Number;

    @FXML
    private TextField Weeklysalary;

    @FXML
    private Button add;

    @FXML
    private TextField show;

    @FXML
    void Back(ActionEvent event) {
main.showHomepage();
    }

    @FXML
    void Add(ActionEvent event) {
        System.out.println("started");
        String str1 = Name.getText();

        String str2 = Country.getText();


        String str3 = Age.getText();


        String str4 = Height.getText();


        String str5 = clubname.getText();


        String str6 = Position.getText();


        String str7 = Number.getText();


        String str8 = Weeklysalary.getText();
        System.out.println("fisnhed");
        int temp2 = 0;
        int flag3 = 0;

        for (Player d : players) {
            //System.out.println(d);
            if (str1.equalsIgnoreCase(d.getName()) || (Integer.parseInt(str7) == d.getNumber() && str5.equalsIgnoreCase(d.getClubname()))) {
                show.setText("The player is already here");
                System.out.println("1");
                flag3 = 1;
                break;
            }
        }
        System.out.println("fisnhed1");
        for (Player d : players) {
            if (!(str6.equalsIgnoreCase("Forward") || str6.equalsIgnoreCase("DEFENDER") || str6.equalsIgnoreCase("MIDFIELDER") || str6.equalsIgnoreCase("goalkeeper"))) {
                System.out.println("2");
                show.setText("Wrong position");
            }

            if(flag3==1)
            break;
        }

        System.out.println("fisnhed2");

        if (flag3 == 0) {
            for(CLub l:Clubs)
                System.out.println(l);
            for (CLub l : Clubs) {
                if (str5.equalsIgnoreCase(l.getclubName())) {
                    System.out.println("temping");
                    temp2++;
                    if (l.CanAddAnymore()) {

                        Player newPlayer = new Player(str1, str2, Integer.parseInt(str3), Double.parseDouble(str4), str5, str6, Integer.parseInt(str7), Double.parseDouble(str8));
                        (new playerMethod()).Addplayer(players, newPlayer);
                        System.out.println("3");
                        show.setText("Added");

                        l.Addplayer(newPlayer);
                    } else {
                        System.out.println("4");
                        show.setText("Already 5 player have been added");
                    }
                }
            }
            System.out.println("fisnhed");
            if (temp2 == 0) {
                Player newPlayer = new Player(str1, str2, Integer.parseInt(str3), Double.parseDouble(str4), str5, str6, Integer.parseInt(str7), Double.parseDouble(str8));
                (new playerMethod()).Addplayer(players, newPlayer);
                nabid1.add(str5);
                new clubmethod().AddClub(nabid1, Clubs, players, CLub.getNoofClubs() + 1);
                System.out.println("5");
               show.setText("added");


            }
            System.out.println("fisnhed4");

        }
    }
@FXML
        void Show (ActionEvent event){

        }
    }

