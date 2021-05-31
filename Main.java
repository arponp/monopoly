import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player p1 = new Player("A", 1, board.getBoard()[8][8]);
        Player p2 = new Player("B", 2, board.getBoard()[8][8]);
        int pot = 0;
        boolean turn = true; // true = p1, false = p2
        boolean winner = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Monopoly");
        board.print(p1, p2);
        while (true) {
            if (winner) {
                break;
            }
            board.print(p1, p2);
            Player p;
            if (turn) {
                p = p1;
            } else {
                p = p2;
            }
            int roll = (int) (Math.random() * 12) + 1;
            for (int i = 1; i <= roll; i++) {
                if (p.getRow() == 8 && p.getCol() > 0) {
                    // moving left
                    p.setCol(p.getCol() - 1);
                } else if (p.getCol() == 0 && p.getRow() > 0) {
                    // moving up
                    p.setRow(p.getRow() - 1);
                } else if (p.getCol() < 8 && p.getRow() == 0) {
                    // moving right
                    p.setCol(p.getCol() + 1);
                } else if (p.getCol() == 8 && p.getRow() < 8) {
                    // move down
                    p.setRow(p.getRow() + 1);
                }
            }

            p.setLocation(board.getBoard()[p.getRow()][p.getCol()]);

            board.print(p1, p2);
            System.out.print("Game:\n" + p + "'s turn\n");
            System.out.println("You rolled a " + roll);
            input.nextLine();
            // change player
            turn = !turn;
        }

        input.close();
    }
}
