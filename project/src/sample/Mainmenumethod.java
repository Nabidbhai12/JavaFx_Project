package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class Mainmenumethod {
    boolean Check(String str,int upperbound,int lowerbound)
    {
        if(str==null)
            return true;
        if(str.length()>1)
            return true;
        if(str.charAt(0)>=48+lowerbound && str.charAt(0)<=+48+upperbound)
            return false;
        else
            return true;
    }
    void display1(ArrayList<Player> Players) {
        Scanner sc = new Scanner(System.in);
        String str1;
        ArrayList<Player> nad = new ArrayList<>();
        int flag = 0;
        while (true) {
            // ArrayList<Player> nad=new ArrayList<>();

            System.out.println("1.By Player Name\n2.By club and country \n 3.by position \n 4.by salaryRange \n 5.country wise\n6.exit");
            String str;
            str=sc.nextLine();
            while (new Mainmenumethod().Check(str,6,1))
            {
                System.out.println("Please Enter Anything from the  Menu");

                str=sc.nextLine();

            }
            int q = Integer.parseInt(str);

            switch (q) {

                case 1:
                    System.out.println("Enter playerName:");
                    str1 = sc.nextLine();
                    nad = (new playerMethod()).searchName(Players, str1);
                    if (nad == null)
                        System.out.println("Error!Player not found");
                    else {
                        playerMethod.show(nad);
                    }
                    break;

                case 2:
                    System.out.println("Enter clubname frist then countryname");
                    str1 = sc.nextLine();
                    String nas = sc.nextLine();
                    nad = (new playerMethod()).searchClub(Players, str1, nas);
                    if (nad == null)
                        System.out.println("ERROR!Player not found");
                    else
                        playerMethod.show(nad);
                    break;

                case 3:
                    System.out.println("Enter positionname");
                    str1 = sc.nextLine();
                    nad = (new playerMethod()).searchPosition(Players, str1);
                    if (nad == null)
                        System.out.println("ERROR!Player not found");
                    else
                        playerMethod.show(nad);
                    break;
                case 4:
                    System.out.println("Enter maximum Salary");
                    str1 = sc.nextLine();
                    System.out.println("iNPUT MINIMUM Salary");
                    String nas1 = sc.nextLine();
                    double uplim = Double.parseDouble(str1);
                    double downlim = Double.parseDouble(nas1);
                    nad = (new playerMethod()).serachSalary(Players, uplim, downlim);
                    if (nad == null)
                        System.out.println("ERROR!Player not found");
                    else
                        playerMethod.show(nad);
                    break;
                case 5:
                    new playerMethod().PlayerCount(Players);
                    break;
                case 6:
                    flag = -1;
                    break;
                default:
                    System.out.println("PLEASE INPUT SOMETHING BETWEEN 1 TO 6");


            }
            if (flag == -1)
                break;
        }
    }

    void display2(ArrayList<Player> Players) {
        int flag = 0;
        Scanner sc = new Scanner(System.in);
        String str1;
        ArrayList<Player> nad = new ArrayList<>();
        while (true) {
            System.out.println("1.Players with maximum salary of the club\n 2.Player with maximum age \n 3.Player with maximum height\n 4.yearly salary\n 5.main menu");

            String str;
            str=sc.nextLine();
            while (new Mainmenumethod().Check(str,5,1))
            {
                System.out.println("Please Enter Anything from the Main Menu");
                str=sc.nextLine();


            }


            int q = Integer.parseInt(str);

            switch (q) {
                case 1:
                    System.out.println("Input a club namemaximum salary");
                    str1 = sc.nextLine();
                    nad = (new clubmethod()).MaximumSalary(Players, str1);
                    if (nad == null)
                        System.out.println("Error Club not found");
                    else
                        playerMethod.show(nad);
                    break;
                case 2:
                    System.out.println("Input a club name for maximum age");
                    str1 = sc.nextLine();
                    nad = (new clubmethod()).MaximumAge(Players, str1);
                    if (nad == null)
                        System.out.println("Error club not found");
                    else
                        playerMethod.show(nad);
                    break;
                case 3:
                    System.out.println("Input a club for maximum height");
                    str1 = sc.nextLine();
                    nad = (new clubmethod()).MaximumHeight(Players, str1);
                    if (nad == null)
                        System.out.println("Error! club not found");
                    else
                        playerMethod.show(nad);
                    break;
                case 4:
                    System.out.println("iNPUT A CLUB FOR WEEKLY salary");
                    str1 = sc.nextLine();
                    //double b = (new clubmethod()).YearlySalary(Players, str1);
                    //if(b==-1.00)
                      //  System.out.println("Error! Club not found");
                    //else
                    //System.out.println(b);
                    break;
                case 5:
                    flag = -1;
                    break;

            }
            if (flag == -1)
                break;

        }
    }
    void display3(ArrayList<Player> Players,ArrayList<String> nabid1,CLub[] Clubs)
    { Scanner sc=new Scanner(System.in);

        System.out.println("iNPUT NAME OF THE PLAYER");
        String str1=sc.nextLine();
        System.out.println("Input country of the player");
        String str2=sc.nextLine();
        System.out.println("Input age of the player");

        String str3=sc.nextLine();
        System.out.println("Input height of the player");

        String str4=sc.nextLine();
        System.out.println("Input Club  of the player");

        String str5=sc.nextLine();
        System.out.println("Input position of the player");

        String str6=sc.nextLine();

        System.out.println("Input jerseyNumber of the player");
        String str7=sc.nextLine();
        System.out.println("Input weeklysalary of the player");

        String str8=sc.nextLine();
        int temp2=0;
        int flag3=0;

        for(Player d:Players)
        {
            if(str1.equalsIgnoreCase(d.getName()) || (Integer.parseInt(str7)==d.getNumber() && str5.equalsIgnoreCase(d.getClubname()) )) {
                System.out.println("The player is already here");
                flag3 = 1;
                break;
            }
        }
        for(Player d:Players)
        {
            if(!(str6.equalsIgnoreCase("Forward") || str6.equalsIgnoreCase("DEFENDER") || str6.equalsIgnoreCase("MIDFIELDER") || str6.equalsIgnoreCase("goalkeeper")))
            {
                System.out.println("Wrong position");
                flag3=1;
                break;
            }
        }


        if(flag3==0){
            for (CLub l : Clubs) {
                if (str5.equalsIgnoreCase(l.getclubName())) {
                    temp2++;
                    if (l.CanAddAnymore()) {

                        Player newPlayer = new Player(str1, str2, Integer.parseInt(str3), Double.parseDouble(str4), str5, str6, Integer.parseInt(str7), Double.parseDouble(str8));
                        (new playerMethod()).Addplayer(Players, newPlayer);
                        System.out.println("Addeded from normal");

                        l.Addplayer(newPlayer);
                    } else
                        System.out.println("sorry");
                }
            }
            if (temp2 == 0) {
                Player newPlayer = new Player(str1, str2, Integer.parseInt(str3), Double.parseDouble(str4), str5, str6, Integer.parseInt(str7), Double.parseDouble(str8));
                (new playerMethod()).Addplayer(Players, newPlayer);
                nabid1.add(str5);
                new clubmethod().AddClub(nabid1, Clubs, Players, CLub.getNoofClubs() + 1);
                System.out.println("added from add club");


            }
          //  for(CLub i:Clubs)
            //    System.out.println(i.getclubName());
            //for(Player i:Players)
              //  System.out.println(i);
        }

    }

    }


