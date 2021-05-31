import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player p1 = new Player("A", 1, board.getBoard()[8][8]);
        Player p2 = new Player("B", 2, board.getBoard()[8][8]);

        board.print(p1, p2);

    }
}
