public class Tax extends SquareType {
    private int cost;

    public Tax(int cost) {
        setName("Luxury Tax");
        setTileType("tax");
        this.cost = cost;
    }

    // getters

    public int getCost() {
        return cost;
    }

    // setters

    public void setCost(int c) {
        cost = c;
    }
}