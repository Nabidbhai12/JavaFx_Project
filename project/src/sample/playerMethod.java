package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class playerMethod extends Player {
    static void show(ArrayList<Player> nabid)
    {
        for(Player i:nabid)
            System.out.println(i.toString());

    }

    void Addplayer(ArrayList<Player> nabid,Player p)
    {
        nabid.add(p);


    }


        ArrayList<Player> searchName(ArrayList<Player> nabid, String name) {
        ArrayList<Player> arr=new ArrayList<>();
        int temp=0;
            for (Player i : nabid) {
                if (i.getName().equalsIgnoreCase(name)) {
                    arr.add(i);
                    temp++;
                }
            }

            if(temp==0)
                return  null;
            else
            return arr;
        }

        ArrayList<Player> searchClub(ArrayList<Player> nabid, String clubName, String countryName) {
            ArrayList<Player> arr=new ArrayList<>();
            int temp=0;
            if(clubName.equalsIgnoreCase("any"))
            {
                for(Player r:nabid)
                {
                    if(r.getCountry().equalsIgnoreCase(countryName))
                    {
                        temp++;
                        arr.add(r);
                    }
                }
                if(temp==0)
                    return null;
                else
                    return arr;
            }
            else if(countryName.equalsIgnoreCase("any"))
            {

                for(Player r:nabid)
                {
                    if(r.getClubname().equalsIgnoreCase(clubName))
                    {
                        temp++;
                        arr.add(r);
                    }
                }
                if(temp==0)
                    return null;
                else
                    return arr;

            }
            else {
                for (Player i : nabid) {
                    if (i.getClubname().equalsIgnoreCase(clubName) && i.getCountry().equalsIgnoreCase(countryName)) {
                        arr.add(i);
                        temp++;
                    }
                }
                if (temp == 0)
                    return null;
                else
                    return arr;

            }
        }

        ArrayList<Player> searchPosition(ArrayList<Player> nabid, String position) {
            ArrayList<Player> arr=new ArrayList<>();
            int temp=0;
            for (Player i : nabid) {
                if (i.getPosition().equalsIgnoreCase(position))
                {
                    arr.add(i);
                    temp++;
                }
            }
            if(temp==0)
                return null;
            else
                return arr;
        }

        ArrayList<Player> serachSalary(ArrayList<Player> nabid, double high, double low) {
            ArrayList<Player> arr=new ArrayList<>();
            int temp=0;
            for (Player i : nabid) {
                if ((i.getWeeklySalary() >= low) == true && ((i.getWeeklySalary() <= high) == true))
                {
                    temp++;
                    arr.add(i);
                }
            }
            if(temp==0)
                return null;
            else
                return arr;
        }
        ArrayList<Country> PlayerCount(ArrayList<Player> nabid) {
            Map<String,Integer> countryCount=new HashMap<>();
            ArrayList<String > country=new ArrayList<>();
            int p=0;
            for(Player i:nabid) {
                if (!man1.isequal(country, i.getCountry())) {
                    country.add(i.getCountry());

                }
            }
                p=0;
                for(String s:country)
                {
                    p=0;
                    for(Player i:nabid)
                    {
                        if(s.equalsIgnoreCase(i.getCountry()))
                            p++;
                    }
                    countryCount.put(s,p);

                }
            ArrayList<Country> nad=new ArrayList<>();

               for(Map.Entry entry:countryCount.entrySet())
               {
                //   System.out.println("Country :"+entry.getKey()+" Number of player:"+entry.getValue());

                   nad.add(new Country((String) entry.getKey(),(Integer) entry.getValue()));
               }
               return nad;



            }


        }

