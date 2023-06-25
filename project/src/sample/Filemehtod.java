package sample;

import java.io.*;
import java.util.ArrayList;

public class Filemehtod {


    public int Raedfile(String FileName, ArrayList<Player> Players,ArrayList<String> nabid1)  {
        BufferedReader input=null;

        try {


            input = new BufferedReader(new FileReader("players.txt"));
            //System.out.println("File opened");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int y = 0;
        int noofClubs = 0;
        String str=null;
        while (true) {


            try {


                str = input.readLine();

            } catch (Exception e) {

                e.printStackTrace();
            }
            if (str == null)
                break;
            String tokens[] = str.split(",");

            Players.add(new Player(tokens[0],tokens[1],Integer.parseInt(tokens[2]),Double.parseDouble(tokens[3]),tokens[4],tokens[5],Integer.parseInt(tokens[6]),Double.parseDouble(tokens[7]) ));
            boolean uu=man1.isequal(nabid1,Players.get(y).getClubname());
            if(!uu)
            {
                nabid1.add(Players.get(y).getClubname());
                noofClubs++;


            }
            y++;
        }
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return noofClubs;

    }
     public void writeFile(String  FileName,ArrayList<Player> Players) {
        BufferedWriter output=null;
            try {
                output = new BufferedWriter(new FileWriter(FileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        for(Player i:Players)
        {
            try {
                output.write(i.getName()+","+i.getCountry()+","+i.getAge()+","+i.getHeight()+","+i.getClubname()+","+i.getPosition()+","+i.getNumber()+","+i.getWeeklySalary());

              output.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         try {
             output.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
