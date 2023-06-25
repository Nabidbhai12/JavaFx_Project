package sample;

import java.util.ArrayList;

public class clubmethod {
    CLub[] AddClub(ArrayList<String> nabid1,CLub[] Clubs,ArrayList<Player> Players,int noofClubs)
    {
        Clubs=new CLub[noofClubs];
        int t=0;
        for(int i=0;i<noofClubs;i++)
        {
            t=0;
            for(Player p:Players)
            {
                if(p.getClubname().equalsIgnoreCase(nabid1.get(i)))
                {
                    t++;
                }
            }
            Clubs[i]=new CLub(nabid1.get(i),t);

        }
        //for(CLub p:Clubs)
          //  System.out.println("from club ;"+p.getclubName());

        return Clubs;
    }

    ArrayList<Player> MaximumSalary(ArrayList<Player> nabid,String clubname)
    { double temp=0.0;
        ArrayList<Player> arr=new ArrayList<>();
        int store=0;
        for(Player i:nabid)
        {
            if(clubname.equalsIgnoreCase(i.getClubname()))
            {
                if(i.getWeeklySalary()>temp)
                {
                    store++;
                    temp=i.getWeeklySalary();

                }
            }
        }
        if(store==0)
            return null;
        for(Player i:nabid)
        {
            if(clubname.equalsIgnoreCase(i.getClubname()))
            {
                if(temp==i.getWeeklySalary())
                    arr.add(i);
            }

        }
            return arr;

    }
    ArrayList<Player> MaximumAge(ArrayList<Player> nabid,String str)
    {
        int temp=0;
        int store=0;
        ArrayList<Player> arr=new ArrayList<>();
        Player tempplayer=null;
        for(Player i:nabid)
        {
            if(i.getClubname().equalsIgnoreCase(str))
            {
                if(i.getAge()>temp)
                {
                    store++;
                    temp=i.getAge();

                }
            }
        }
        if(store==0)
            return null;
        for(Player i:nabid)
        {
            if(i.getClubname().equalsIgnoreCase(str))
            {
                if(temp==i.getAge())
                    arr.add(i);

            }
        }


           return arr;
    }
    ArrayList<Player> MaximumHeight(ArrayList<Player> nabid,String str)
    {
        double temp=0.0;
        int store=0;
        ArrayList<Player> arr=new ArrayList<>();
        Player tempplayer=null;
        for(Player i:nabid)
        {
            if(i.getClubname().equalsIgnoreCase(str))
            {
                if(i.getHeight()>temp)
                {
                    store++;
                    temp=i.getHeight();

                }
            }
        }
        if(store==0)
            return null;
        for(Player i:nabid)
        {
            if(i.getHeight()==temp)
                arr.add(i);
        }


            return arr;

    }
    CLub YearlySalary(ArrayList<Player> nabid, String club)
    {
        double Total=0;
        int store=0;
        for(Player i:nabid)
        {
            if(i.getClubname().equalsIgnoreCase(club))
            {
                store++;
                Total+=(52*i.getWeeklySalary());
            }
        }
        if(store==0)
            return null;
        return new CLub(club,Total);

    }


}
