package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ReadThreadServer implements Runnable{
     private NetworkUtil networkUtil;
     private HashMap<String,NetworkUtil> clientMap;
    Thread t;
    private ArrayList<Sell> sellList;
    private Server server;
ReadThreadServer(HashMap<String,NetworkUtil>clientMap,NetworkUtil networkUtil,Server server,ArrayList<Sell> sellList)
{
    this.sellList=sellList;
    this.server=server;
    this.clientMap=clientMap;
    this.networkUtil=networkUtil;
    t=new Thread(this,"Server");
            t.start();

}

     @Override
     public void run() {
         try {
             System.out.println("From serverRead thread: starting");
             while (true) {
                 System.out.println("waiting to read an object");
                 Object obj = networkUtil.read();
                 System.out.println("read done");
                 if (obj instanceof CLub) {
                     System.out.println("Object Type : Club");

                     CLub club = (CLub) obj;
                     System.out.println("Client Name " + club.getClubName());
                     String str = club.getClubName();
                     ArrayList<Player> temp = server.getPlayers();

                     for (Player t : temp) {
                         if (t.getClubname().equals(str)) {
                             //      System.out.println("Founded member of the club , Name: " + t.getName());
                             club.Addplayer(t);
                         }
                     }
                     int flag=0;

                     for(Map.Entry entry:clientMap.entrySet())
                     {
                         if(entry.getKey().equals(str))
                         {
                             flag++;
                             break;
                         }
                     }
                     if(flag==0)
                         clientMap.put(str,networkUtil);
                     clientMap.put(str, networkUtil);
                     for (Player t : temp)
                         System.out.println(t);

                     System.out.println("Work done.Writting...");
                     networkUtil.write(club);
                 }
                 if (obj instanceof Sell) {
                     Sell ob1;
                     ob1 = (Sell) obj;


                     int flag=0;
                     for (Sell a : sellList) {
                         if(a.getPlayerName().equals(ob1.getPlayerName()))
                             flag=-1;
                         System.out.println(a.getClientName() + " requested to sell " + a.getPlayerName());
                     }
                     if(flag==0)
                         sellList.add(ob1);

                 }
                 if(obj instanceof Buy)
                 {
                     System.out.println("buy object found");
                     Buy buy=(Buy) obj;
                     if(buy.getState()==0)
                     {
                         System.out.println("state 0");
                         ArrayList<Player> playerlist=server.getPlayers();
                         System.out.println("available players");
                        for (Sell a:sellList)
                        {
                            if(!a.getClientName().equals(buy.getBuyerClient())) {
                                buy.AddPlayer(a.getPlayer());
                                System.out.println(a.getPlayerName());
                            }
                        }
                         buy.setState(1);
                         networkUtil.write(buy);
                         System.out.println("writting...");

                     }
                     if(buy.getState()==2)
                     {
                         ArrayList<Player> temp=server.getPlayers();
                         for (Player a:temp)
                         {
                             if(buy.getDesiredPlayerName().equals(a.getName()))
                             {
                                 buy.setSellerClient(a.getClubname());
                                 a.setClubname(buy.getBuyerClient());
                                 buy.setDesiredPlayer(a);
                                 Sell temp2=null;
                                 for(Sell l:sellList)
                                 {
                                     if(l.getPlayerName().equals(a.getName()))
                                     {
                                         temp2=l;

                                         System.out.println("proobable error");
                                     }
                                 }
                                 System.out.println(temp2.getPlayerName());
                                 sellList.remove(temp2);
                                 System.out.println("removed");
                                 System.out.println("player "+a.getName()+" old club "+a.getClubname()+" new club "+buy.getBuyerClient());
                             }
                         }
                         buy.setState(3);
                         for (Map.Entry entry:clientMap.entrySet())
                         {
                             if(entry.getKey().equals(buy.getBuyerClient()))
                             {
                                 System.out.println("found sending "+entry.getKey());
                                 NetworkUtil ob1= (NetworkUtil) entry.getValue();
                                 ob1.write(buy);
                             }

                         }
                         {

                         }

                     }
                 }
             }
         }
    catch(Exception e)
             {
                 e.printStackTrace();
             }
    finally{
                 try {
                     networkUtil.closeConnection();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }

         }
     }

