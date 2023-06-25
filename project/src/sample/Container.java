package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

 class Container {
    private Stage stage;


     private Main main;
    ArrayList<Player> Players;
    private String clientName;
    ArrayList<String> nabid1;
    CLub Clubs[];
    NetworkUtil networkUtil;
    ArrayList<Sell> sellrequest;
    public void Addsell(Sell sell)
    {
        sellrequest.add(sell);

    }
     public void showAlert1() {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Incorrect Credentials");
         alert.setHeaderText("Incorrect Credentials");
         alert.setContentText("The Player you entered is not in this club.");
         alert.showAndWait();
     }
     public ArrayList<Sell> getSellrequest() {
         return sellrequest;
     }

     public void setSellrequest(ArrayList<Sell> sellrequest) {
         this.sellrequest = sellrequest;
     }

     Container(Stage stage, Main main)
    {
        sellrequest=new ArrayList<>();

        try {
            this.networkUtil=new NetworkUtil("127.0.0.1",33332);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.main=main;
        this.stage=stage;

showLoginpage();

    }
     public String getClientName() {
         return clientName;
     }

     public NetworkUtil getNetworkUtil() {
         return networkUtil;
     }

     public void setNetworkUtil(NetworkUtil networkUtil) {
         this.networkUtil = networkUtil;
     }
     public void setClientName(String clientName) {
         this.clientName = clientName;
     }
    public void showLoginpage()
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        Login controller = loader.getController();
        controller.setMain(this);
        controller.SetNetworkUtil(networkUtil);
        //Login.setList(Players);


        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 500, 600));
        stage.show();


    }
    public void refresh(){
        CLub temp=new CLub(clientName);

        try {
            networkUtil.write(temp);
            System.out.println("written");
            Object o=networkUtil.read();
            if(o instanceof CLub)
            {
                temp=(CLub) o;
                setPlayers(temp.getPlayerlist());
                System.out.println("end");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void showHomepage()
    {



        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        Controller controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);


        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 500, 600));
        stage.show();
        System.out.println("in main page");


    }
    public void showSearchPlayer()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Searchplayer.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        Controller1 controller = loader.getController();
        controller.SetMain(this);

        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 500, 600));
        stage.show();
    }
    void showPlayername()
    {
refresh();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Playername.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        Controllerplayername controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);

        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 500, 600));
        stage.show();
    }
    void showPlayername2()
    {
refresh();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Playername2.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        Controllerplayername2 controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);

        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 500, 600));
        stage.show();
    }
    void showPlayerposition()
    {
        refresh();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Playerpositionsearch.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        Controllerpositionsearch controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);

        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 500, 600));
        stage.show();
    }
    void Showcountrysearch()
    {
refresh();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Playercountrysearch.fxml"));
            Parent root=null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Loading the controller
            ControllerCountrysearch controller = loader.getController();
            controller.SetMain(this);
            controller.setList(Players);

            // Set the primary stage
            stage.setTitle("Searchplayer");
            stage.setScene(new Scene(root, 500, 600));
            stage.show();

    }
    public  void showsalary()
    {
refresh();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Playersalary.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        Controllerplayersalary controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);

        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 500, 600));
        stage.show();
    }
    public void Clubmenu()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Clubsearch.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        Controller2 controller = loader.getController();
        controller.SetMain(this);


        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }
    public void Clubsearch1()
    {
        refresh();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Clubsearch1.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ControllerClubsearch1 controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);

        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

    }
    public void Clubsearch2()
    {
        refresh();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Clubsearch2.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ControllerClubsearch2 controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);

        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

    }


    public void Clubsearch3()
    {
        refresh();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Clubsearch3.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ControllerClubsearch3 controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);

        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();


    }

     public ArrayList<Player> getPlayers() {
         return Players;
     }

     public void setPlayers(ArrayList<Player> players) {
         Players = players;
     }

     public void Clubsearch4()
    {
        refresh();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Clubsearch4.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ControllerClubsearch4 controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);

        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

    }
    public void Addplayer()
    {



        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Controller3.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        Controller3 controller = loader.getController();
        controller.SetMain(this);
       controller.setList(Players);
       controller.setList2(Clubs);
       controller.setList3(nabid1);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 1000, 1250));
        stage.show();
    }
    public void ShowSell()
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Sell.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ControllerSell controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);

        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

    }
    public void showbuy()
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Buy.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ControllerBuy controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);

        // Set the primary stage
        stage.setTitle("Searchplayer");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

    }



 }
