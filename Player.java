import java.util.ArrayList;

public class Player implements Piece {
    private String name;
    private int number;
    private int balance;
    private ArrayList<House> properties;
    private boolean inJail;

    public Player(String name, int number) {
        this.name = name;
        this.balance = 0;
        this.number = number;
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

    public ArrayList<House> getProperties() {
        return this.properties;
    }

    public boolean getJailStatus() {
        return this.inJail;
    }

    // setters

    public void setOwner(String human) {
        this.name = human;
    }

    // methods

    public void addProperty(House property) {
        properties.add(property);
        balance -= property.getPrice();
    }

    public void goToJail() {
        this.inJail = true;
    }

}
