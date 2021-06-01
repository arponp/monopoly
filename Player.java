import java.util.ArrayList;

public class Player implements Piece {
    private String name;
    private int number;
    private int balance;
    private ArrayList<SquareType> assets;
    private boolean inJail;
    private SquareType location;
    private int row;
    private int col;
    private int jailFrees;

    public Player(String name, int number, SquareType location) {
        this.name = name;
        this.balance = 1500;
        this.number = number;
        this.assets = new ArrayList<SquareType>();
        this.inJail = false;
        this.location = location;
        this.row = 8;
        this.col = 8;
        this.jailFrees = 0;
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

    public boolean getJailStatus() {
        return this.inJail;
    }

    public SquareType getLocation() {
        return location;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getJailFrees() {
        return jailFrees;
    }
    // setters

    public void setRow(int r) {
        this.row = r;
    }

    public void setCol(int c) {
        this.col = c;
    }

    public void setOwner(String human) {
        this.name = human;
    }

    public void setLocation(SquareType square) {
        location = square;
    }

    public void setBalance(int b) {
        balance = b;
    }

    public void setJailStatus(boolean b) {
        this.inJail = b;
    }

    public void setJailFrees(int i) {
        jailFrees = i;
    }
    // methods

    public String toString() {
        return "Player " + number;
    }

    public boolean addAsset(SquareType s) {
        return assets.add(s);
    }

    public void removeAsset(int i) {
        assets.remove(i);
    }

}
