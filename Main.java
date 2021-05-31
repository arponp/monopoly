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
        board.printLegend();
        while (true) {
            if (winner) {
                break;
            }
            Player p;
            if (turn) {
                p = p1;
            } else {
                p = p2;
            }
            int roll1 = (int) (Math.random() * 6) + 1;
            int roll2 = (int) (Math.random() * 6) + 1;
            int roll = roll1 + roll2;
            boolean doubles = roll1 == roll2;
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

            p.setLocation(board.getBoard()[p.getRow()][p.getCol()]); // set position after roll

            board.print(p1, p2);
            System.out.print("Game:\n" + p + "'s turn\n"); // print player's turn
            System.out.println("You rolled a " + roll); // print roll total
            if (doubles)
                System.out.println("You rolled doubles!");
            System.out.println("You landed on: " + p.getLocation().getName()); // print landing spot
            if (p.getLocation().getTileType().equals("chance")) { // implement chance
                Chance c = (Chance) p.getLocation();
                String chance = c.getChanceCard();
                System.out.println("Chance: " + chance);
                if (chance.equals("Go To Jail")) {
                    System.out.println("You are now in jail!");
                    p.setJailStatus(true);
                    p.setRow(8);
                    p.setCol(0);
                } else if (chance.equals("Collect $200")) {
                    p.setBalance(p.getBalance() + 200);
                    System.out.println("Your balance is now $" + p.getBalance());
                } else if (chance.equals("Pay $50")) {
                    p.setBalance(p.getBalance() - 50);
                    System.out.println("Your balance is now $" + p.getBalance());
                } else if (chance.equals("Get out of jail free")) {
                    System.out.println("You have received a 'Get out of jail free' card. Use when you are in jail");
                    p.setJailFrees(p.getJailFrees() + 1);
                } else { // pay 150
                    p.setBalance(p.getBalance() - 150);
                    System.out.println("Your balance is now $" + p.getBalance());
                }
            } else if (p.getLocation().getTileType().equals("free parking")) {
                if (pot > 0) {
                    System.out.println("You have received $" + pot);
                    pot = 0;
                    p.setBalance(p.getBalance() + pot);
                } else {
                    System.out.println("You have received $100");
                    p.setBalance(p.getBalance() + 100);
                }
                System.out.println("You have $" + p.getBalance());
            } else if (p.getLocation().getTileType().equals("go to jail")) {
                System.out.println("You have been sent to jail");
                p.setRow(8);
                p.setCol(0);
                p.setLocation(board.getBoard()[p.getRow()][p.getCol()]); // set position after roll
            } else if (p.getLocation().getTileType().equals("land")) {
                // check if owned
                Land property = (Land) board.getBoard()[p.getRow()][p.getCol()];
                if (property.getOwner() == 0) {
                    // can buy
                    System.out.println("Would you like to purchase this property?\n[1] yes\n[2] no");
                    int choice = input.nextInt();
                    input.nextLine();
                    if (choice == 1) { // player buys property
                        // check if player has sufficient funds
                        if (p.getBalance() < property.getCost()) {
                            System.out.print("You cannot afford this property");
                        } else {
                            p.setBalance(p.getBalance() - property.getCost());
                            board.getBoard()[p.getRow()][p.getCol()].setOwner(p.getNumber());
                            System.out.println("You have purchased: " + property.getName());
                            System.out.println("Your balance is now: $" + p.getBalance());
                        }
                    } else { // player refuses
                        System.out.println("You have chose to not purchase this property");
                    }
                } else if (board.getBoard()[p.getRow()][p.getCol()].getOwner() != p.getNumber()) {
                    // owned by other player
                    int rent = property.getRent();
                    System.out.println("You paid $" + rent + " for rent");
                    p.setBalance(p.getBalance() - rent);
                    System.out.println("Your balance is now: $" + p.getBalance());
                }

            } else if (p.getLocation().getTileType().equals("railroad")) {
                Railroad r = (Railroad) board.getBoard()[p.getRow()][p.getCol()];
                // check if owned
                if (r.getOwner() == 0) {
                    // give option to buy
                    System.out.println("Would you like to purchase this property?\n[1] yes\n[2] no");
                    int choice = input.nextInt();
                    input.nextLine();
                    if (choice == 1) {
                        if (p.getBalance() < r.getCost()) {
                            System.out.println("You cannot afford this railroad");
                        } else {
                            board.getBoard()[p.getRow()][p.getCol()].setOwner(p.getNumber());
                            System.out.println("You have purchased: " + r.getName());
                        }
                    } else {
                        System.out.println("You have chose to not purchase this railroad.");
                    }
                } else if (r.getOwner() != p.getNumber()) {
                    // pay fee
                    p.setBalance(p.getBalance() - r.getRent());
                    System.out.println("You paid: $" + r.getRent());
                    System.out.println("Your balance is now: $" + p.getBalance());
                }
            } else if (p.getLocation().getTileType().equals("tax")) {
                Tax t = (Tax) board.getBoard()[p.getRow()][p.getCol()];
                System.out.println("You paid: $" + t.getCost() + " in tax");
                System.out.println("Your balance is now: $" + p.getBalance());
            }

            // actions at end of turn
            System.out.println("Would you like to take any actions?\n[1] yes\n[2] no");
            int choice = input.nextInt();
            input.nextLine();
            // change player
            if (!doubles)
                turn = !turn;
        }

        input.close();
    }
}
