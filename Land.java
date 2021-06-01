import java.util.ArrayList;

public class Land extends SquareType {
    private int cost;
    private String color;
    private ArrayList<House> houses;
    private ArrayList<Hotel> hotels;

    public Land(String name, String color, int cost) {
        setName(name);
        setTileType("land");
        this.color = color;
        this.cost = cost;
        this.houses = new ArrayList<House>();
        this.hotels = new ArrayList<Hotel>();
    }

    // getters
    public int getCost() {
        return cost;
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
    public void addProperty() {
        if (houses.size() == 3) {
            houses.clear();
            hotels.add(new Hotel());
            System.out.println("4 houses removed. One hotel added.");
            return;
        }
        System.out.println("One house added");
        houses.add(new House());
    }

    public int getRent() {
        int totalRent = 0;
        totalRent += (houses.size() * 50);
        totalRent += (hotels.size() * 210);
        if (totalRent == 0) {
            totalRent = 20;
        }
        return totalRent;
    }

    public int sell() {
        houses.clear();
        hotels.clear();
        setOwner(0);
        System.out
                .println("You sold this property for: $" + ((houses.size() * 25) + (hotels.size() * 105) + (cost / 2)));
        return (houses.size() * 25) + (hotels.size() * 105) + (cost / 2);
    }
}
