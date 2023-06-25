package sample;

import java.io.Serializable;
import java.util.ArrayList;

class Buy implements Serializable {
     private ArrayList<Player> availablePlayers;
     private String desiredPlayerName;
     private String sellerClient;
     private String buyerClient;
     private int state;
     private Player desiredPlayer;

     public Player getDesiredPlayer() {
          return desiredPlayer;
     }

     public void setDesiredPlayer(Player desiredPlayer) {
          this.desiredPlayer = desiredPlayer;
     }

     public void AddPlayer(Player a)
     {
          availablePlayers.add(a);


     }
     public int getState() {
          return state;
     }

     public void setState(int state) {
          this.state = state;
     }

     public String getSellerClient() {
          return sellerClient;
     }

     public void setSellerClient(String sellerClient) {
          this.sellerClient = sellerClient;
     }

     Buy()
     {
          availablePlayers=new ArrayList<>();

     }

     public String getBuyerClient() {
          return buyerClient;
     }

     public void setBuyerClient(String buyerClient) {
          this.buyerClient = buyerClient;
     }

     public String getDesiredPlayerName() {
          return desiredPlayerName;
     }

     public void setDesiredPlayerName(String desiredPlayerName) {
          this.desiredPlayerName = desiredPlayerName;
     }

     public ArrayList<Player> getAvailablePlayers() {
          return availablePlayers;
     }

     public void setAvailablePlayers(ArrayList<Player> availablePlayers) {
          this.availablePlayers = availablePlayers;
     }
}
