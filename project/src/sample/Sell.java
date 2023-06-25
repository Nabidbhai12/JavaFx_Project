package sample;

import java.io.Serializable;

public class Sell implements Serializable {
    private String playerName;
    private String clientName;
    private  Player player;




    Sell()
    {

    }
    Sell(String clientName)
    {
        this.clientName=clientName;

    }
    public void setPrice(Double price)
    {
        player.setPrice(price);

    }
    public String getPlayerName() {
        return playerName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


}
