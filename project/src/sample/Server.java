package sample;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

class Server {
     private ServerSocket serverSocket;
     public HashMap<String, NetworkUtil> clientMap;


    ArrayList<Player> Players;
    ArrayList<String> nabid1;
    CLub Clubs[];
    ArrayList<Sell> sellList;

    public ArrayList<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<Player> players) {
        Players = players;
    }

    Server() {
        sellList=new ArrayList<>();
clientMap=new HashMap<>();
         Players = new ArrayList<>(1000);
         nabid1=new ArrayList<>();
         int noofClubs = new Filemehtod().Raedfile("players.txt",Players,nabid1);
         CLub.setNoofClubs(noofClubs);
         Clubs=new clubmethod().AddClub(nabid1,Clubs,Players,noofClubs);


         //clientMap = new HashMap<>();
         try {
             serverSocket = new ServerSocket(33332);
             while (true) {
                 Socket clientSocket = serverSocket.accept();
                 serve(clientSocket);
             }
         } catch (Exception e) {
             System.out.println("server.Server starts:" + e);
         }
     }

     public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
         NetworkUtil networkUtil = new NetworkUtil(clientSocket);
         new ReadThreadServer(clientMap, networkUtil,this,sellList);
     }
     public static void main(String [] args)
     {
         Server server=new Server();
     }

}
