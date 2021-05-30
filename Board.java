public class Board {
    private SquareType[][] board;

    public Board() {
        board = new SquareType[9][9];
        // top of board
        board[0][0] = new FreeParking();
        board[0][1] = new Land("Mission Boulevard", "red", 200);
        board[0][2] = new Land("Palm Avenue", "red", 220);
        board[0][3] = new Land("Mission Cielo Avenue", "red", 230);
        board[0][4] = new Railroad("A Railroad", 200, 20);
        board[0][5] = new Chance();
        board[0][6] = new Land("Bear Avenue", "blue", 250);
        board[0][7] = new Land("Bear Road", "blue", 260);
        board[0][8] = new GoToJail();
        // left
        board[1][0] = new Land("New York Avenue", "orange", 190);
        board[2][0] = new Land("Tennessee Avenue", "orange", 180);
        board[3][0] = new Land("ST James Place", "orange", 180);
        board[4][0] = new Railroad("B Railroad", 200, 20);
        board[5][0] = new Land("Virginia Avenue", "pink", 160);
        board[6][0] = new Tax(150);
        board[7][0] = new Land("States Avenue", "pink", 140);
        board[8][0] = new Jail();
        // right
        board[1][8] = new Land("Pacific Avenue", "green", 300);
        board[2][8] = new Land("NC Avenue", "green", 320);
        board[3][8] = new Chance();
        board[4][8] = new Railroad("C Railroad", 200, 20);
        board[5][8] = new Land("Park Place", "purple", 350);
        board[6][8] = new Tax(210);
        board[7][8] = new Land("Boardwalk", "purple", 400);
        board[8][8] = new Go();
        // bottom
        board[8][7] = new Land("Mediterranian Avenue", "brown", 70);
        board[8][6] = new Chance();
        board[8][5] = new Land("Baltic Avenue", "brown", 80);
        board[8][4] = new Railroad("D Railroad", 200, 20);
        board[8][3] = new Land("Oriental Avenue", "sky blue", 100);
        board[8][2] = new Land("Vermont Avenue", "sky blue", 100);
        board[8][1] = new Land("Connecticut Avenue", "sky blue", 120);
    }

    // getters

    public SquareType[][] getBoard() {
        return board;
    }

    // methods

}
