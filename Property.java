public class Property extends SquareType {
    private int price;
    private int rent;

    public Property(String name, int price, int rent) {
        setName(name);
        setTileType("Land");
        this.price = price;
        this.rent = rent;
    }

    // getters
    public int getPrice() {
        return this.price;
    }

    public int getRent() {
        return this.rent;
    }

    // setters
    public void setPrice(int price) {
        this.price = price;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
}
