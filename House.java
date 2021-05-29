public class House extends SquareType {
    private int cost;
    private int rent;

    public House(String name, int cost, int rent) {
        setName(name);
        this.cost = cost;
        this.rent = rent;
    }

    // getters and setters

    public int getCost() {
        return cost;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
