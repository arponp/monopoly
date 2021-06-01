public class Railroad extends SquareType {
    private int cost;
    private int rent;

    public Railroad(String name, int cost, int rent) {
        setName(name);
        setTileType("railroad");
        this.cost = cost;
        this.rent = rent;
    }

    // getters
    public int getCost() {
        return cost;
    }

    public int getRent() {
        return rent;
    }

    // sell

    public int sell() {
        setOwner(0);
        System.out.println("You sold this railroad for $" + (cost / 2));
        return cost / 2;
    }
}
