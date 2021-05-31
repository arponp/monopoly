import java.util.ArrayList;

public class Land extends SquareType {
    private int cost;
    private String color;
    private ArrayList<House> properties;

    public Land(String name, String color, int cost) {
        setName(name);
        setTileType("land");
        this.color = color;
        this.cost = cost;
    }

    // getters
    public int getCost() {
        return cost;
    }

    public ArrayList<House> getProperties() {
        return properties;
    }

    public String getColor() {
        return color;
    }

    // setters
    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // methods
    public boolean addProperty(House h) {
        return properties.add(h);
    }

    public int getRent() {
        if (properties.size() >= 4) {
            return 100;
        } else if (properties.size() == 3) {
            return 80;
        } else if (properties.size() == 2) {
            return 60;
        } else if (properties.size() == 1) {
            return 40;
        }
        return 10;
    }
}
