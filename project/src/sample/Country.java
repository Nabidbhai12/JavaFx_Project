package sample;

public class Country {
    private String Name;
    private int NoofPlayers;

     Country(String name,int noofPlayers) {
        this.NoofPlayers=noofPlayers;
        Name = name;
    }
    Country()
    {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNoofPlayers() {
        return NoofPlayers;
    }

    public void setNoofPlayers(int noofPlayers) {
        this.NoofPlayers = noofPlayers;
    }
}
