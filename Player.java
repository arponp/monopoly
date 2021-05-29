import java.util.ArrayList;

public class Player implements Piece {
    private String name;
    private int number;
    private int balance;
    private ArrayList<SquareType> assets;
    private ArrayList<House> properties;
    private boolean inJail;
    private SquareType location;

    public Player(String name, int number) {
        this.name = name;
        this.balance = 0;
        this.number = number;
        this.assets = new ArrayList<SquareType>();
        this.properties = new ArrayList<House>();
        this.inJail = false;
    }

    // getters

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public int getBalance() {
        return this.balance;
    }

    public ArrayList<SquareType> getAssets() {
        return this.assets;
    }

    public ArrayList<House> getProperties() {
        return this.properties;
    }

    public boolean getJailStatus() {
        return this.inJail;
    }

    public SquareType getLocation() {
        return location;
    }

    // setters

    public void setOwner(String human) {
        this.name = human;
    }

    public void setLocation(SquareType square) {
        location = square;
    }

    // methods

}
