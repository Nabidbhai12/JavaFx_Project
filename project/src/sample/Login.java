package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Login {
     private Container main;
private NetworkUtil networkUtil;
     public Container getMain() {
          return main;
     }

     public void setMain(Container main) {
          this.main = main;
     }

     private  ArrayList<Player> playerList;

     @FXML
     private TextField clubnamefield;

     @FXML
     private Button enter;

     @FXML
     private Button Exit;

     @FXML
     void Enter(ActionEvent event) {
          Scanner input=new Scanner(System.in);
          String str=clubnamefield.getText();
          main.setClientName(str);

CLub club=new CLub(str);
Object obj;
          try {
               System.out.println("Writing ...");
               networkUtil.write(club);
               System.out.println("Done. Reading..");
           obj=  networkUtil.read();
           if(obj instanceof CLub)
           {
                System.out.println("Done");
                club=(CLub) obj;
                main.setPlayers(club.getPlayerlist());
                main.showHomepage();


           }
          } catch (Exception e) {
               e.printStackTrace();
          }

     }

     @FXML
     void Exitmethod(ActionEvent event) {
          exit(1);

     }

     public void SetNetworkUtil(NetworkUtil networkUtil) {
          this.networkUtil=networkUtil;
     }
}
