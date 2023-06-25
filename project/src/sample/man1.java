package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class man1 {


    static boolean isequal(ArrayList<String> arr, String s)
    {


        if(arr.size()==0)
            return false;
        for (String str : arr)
        {
            if (str.equalsIgnoreCase(s)==true)
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Player> Players = new ArrayList<>(1000);
        ArrayList<String> nabid1=new ArrayList<>();
        CLub[] Clubs =null;
        int noofClubs = new Filemehtod().Raedfile("players.txt",Players,nabid1);
        CLub.setNoofClubs(noofClubs);
        Clubs=new clubmethod().AddClub(nabid1,Clubs,Players,noofClubs);
     //   for(CLub p:Clubs)
       //     System.out.println(p.getclubName());
            int i, flag,flag1=0;


        double temp = 0.0;
        Player plr;
        while (true) {
            System.out.println("MAIN MENU");
            System.out.println("1.SEARCH PLAYERS\n 2.Serch Clubs \n3.Add player\n 4.exit System");
            Scanner sc = new Scanner(System.in);
            String str=sc.nextLine();
           // System.out.println("my string length "+str.length()+" :"+str);
            while(new Mainmenumethod().Check(str,4,1))
            {
                System.out.println("Please Enter Anything from the Main Menu");
                str=sc.nextLine();


            }
            int p = Integer.parseInt(str);
            String str1;
            ArrayList<Player> nad=new ArrayList<>();
            switch (p) {

                case 1:new Mainmenumethod().display1(Players);

                    break;
                case 2:

                 new Mainmenumethod().display2(Players);
                 break;
                case 3:
                                new Mainmenumethod().display3(Players,nabid1,Clubs);
                       break;
                case 4:
                    flag1=-1;
                    new Filemehtod().writeFile("players.txt",Players);

                    break;

            }
            if(flag1==-1)
                break;

        }
    }
}