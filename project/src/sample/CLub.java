package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class CLub implements Serializable {
    private static int noofClubs;
    private String clubName;
    private ArrayList<Player> Playerlist;
    private int noofplayers;
    private double yearlySalary;

    public ArrayList<Player> getPlayerlist() {
        return Playerlist;
    }

    public void setPlayerlist(ArrayList<Player> playerlist) {
        Playerlist = playerlist;
    }

    CLub(String clubName, double yearlySalary)
    {
        this.clubName=clubName;
        Playerlist=new ArrayList<>();
        this.yearlySalary=yearlySalary;
    }
    CLub(String clubName, int noofplayers)
    {
        this.clubName=clubName;
        Playerlist=new ArrayList<>();
        this.noofplayers=noofplayers;
    }
    CLub(String clubName)
    {
        this.clubName=clubName;
        Playerlist=new ArrayList<>();

    }

    @Override
    public String toString() {
        return "CLub{" +
                "clubName='" + clubName + '\'' +
                '}';
    }



    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    static void setNoofClubs(int num)
    {
        noofClubs=num;

    }
    static int getNoofClubs(){return noofClubs;}

    String getclubName() {return clubName;}
    boolean CanAddAnymore()
    {
        if(this.noofplayers<7)
            return true;
        else
           return false;


    }
    void show()
    {
        System.out.println("No of players in "+clubName+"is "+noofplayers);
        for(Player i:Playerlist)
        {
            System.out.println(i);

        }
    }
    void Addplayer(Player p)
    {
        Playerlist.add(p);
        this.noofplayers++;


    }


}
