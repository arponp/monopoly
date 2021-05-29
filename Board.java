public class Board {
    private SquareType[][] board;

    public Board() {
        board = new SquareType[9][9];
        board[0][0] = new FreeParking();
        board[0][1] = new Land("Mission Boulevard", "red", 200);
        board[0][2] = new Land("Palm avenue", "red", 220);
        board[0][3] = new Chance();
        board[0][4] = new Land("Palm avenue", "red", 230);
    }

    // getters

    public SquareType[][] getBoard() {
        return board;
    }

    // methods

    public void printBoard(Player p1, Player p2) {

    }
}
