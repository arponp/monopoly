public class Chance extends SquareType {
    public Chance() {
        setName("Chance");
        setTileType("chance");
    }

    // methods

    public String getChanceCard() {
        int n = (int) Math.random() * 5;
        if (n == 4) {
            return "Go To Jail";
        } else if (n == 3) {
            return "Collect $200";
        } else if (n == 2) {
            return "Pay $50";
        } else if (n == 1) {
            return "Get out of jail free";
        }
        return "Pay $150";
    }
}
