import java.util.ArrayList;

public class Jail extends SquareType {
    private ArrayList<Player> players;

    public Jail() {
        players = new ArrayList<Player>();
        setName("Jail");
        setTileType("jail");
    }

    // getters and setters

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean addToJail(Player p) {
        return players.add(p);
    }

    public boolean removeFromJail(Player p) {
        return players.remove(p);
    }
}
