import java.util.Scanner;
public class TicTacToe {

    //Create Board
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args) {

        //Play Again
        boolean playAgain = true;
        while(playAgain == true) {

            //clear board
            clearBoard();

            //show board
            display();

            //declare variables
            Scanner sc = new Scanner(System.in);
            int player1row = 0;
            int player1col = 0;
            int player2row = 0;
            int player2col = 0;
            int tie = 0;
            String player1 = "x";
            String player2 = "o";


            //play game
            for (int x = 0; x < 5; x--) {

                //get player 1 input
                player1row = SafeInput.getRangedInt(sc, "Player 1 choose a row", 0, 2);

                player1col = SafeInput.getRangedInt(sc, "Player 1 choose a column", 0, 2);

                //check for valid input
                while (isValidMove(player1row, player1col) == false) {
                    System.out.print("Please enter a valid input.");

                    player1row = SafeInput.getRangedInt(sc, "Player 1 choose a row", 0, 2);

                    player1col = SafeInput.getRangedInt(sc, "Player 1 choose a column", 0, 2);
                }

                board[player1row][player1col] = "x";

                display();

                tie++;

                //check for win
                if (isColWin("x") == true) {
                    System.out.println();
                    System.out.println("Player one wins!");
                    break;
                }
                if (isRowWin("x") == true) {
                    System.out.println();
                    System.out.println("Player one wins!");
                    break;
                }

                if (isDiagonalWin("x") == true) {
                    System.out.println();
                    System.out.println("Player one wins!");
                    break;
                }

                //check for tie
                if (isTie(tie) == true) {
                    System.out.println();
                    System.out.println("It's a tie!");
                    break;
                }
                //get player 2 input
                player2row = SafeInput.getRangedInt(sc, "Player 2 choose a row", 0, 2);

                player2col = SafeInput.getRangedInt(sc, "Player 2 choose a column", 0, 2);

                while (isValidMove(player2row, player2col) == false) {
                    System.out.print("Please enter a valid input.");

                    player2row = SafeInput.getRangedInt(sc, "Player 2 choose a row", 0, 2);

                    player2col = SafeInput.getRangedInt(sc, "Player 2  choose a column", 0, 2);
                }

                board[player2row][player2col] = "o";

                display();

                tie++;

                //check for win
                if (isColWin("o") == true) {
                    System.out.println();
                    System.out.println("Player two wins!");
                    break;
                }
                if (isRowWin("o") == true) {
                    System.out.println();
                    System.out.println("Player two wins!");
                    break;
                }
                if (isDiagonalWin("o") == true) {
                    System.out.println();
                    System.out.println("Player two wins!");
                    break;
                }
                //check for tie
                if (isTie(tie) == true) {
                    System.out.println();
                    System.out.println("It's a tie!");
                    break;
                }
            }

            //play again
            playAgain = SafeInput.getYNConfirm(sc, "Would you like to play again? ");

        }

    }

    private static void clearBoard() {
        //clear board
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " "; // make this cell a space
            }
        }
    }
    private static void display() // shows the Tic Tac Toe game used as part of the prompt for the users move choice…
    {
        for (int i = 0; i < board.length; i++)
        {
            System.out.println();
            for (int j = 0; j < board[i].length; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
        }

    }
    private static boolean isValidMove(int row, int col) // returns true if there is a space at the given proposed move coordinates which means it is a legal move.
    {

        boolean retVal = false;
        if(board[row][col].equals(" "))  // is it a space?
            retVal = true;
        return retVal;
    }

    private static boolean isColWin(String player) // checks for a col win for specified player
    {
        if(board[0][0].equals(player) &&  board[1][0].equals(player)  &&  board[2][0].equals(player))
        {
            return true;
        }
        else if(board[0][1].equals(player) && board[1][1].equals(player) &&  board[2][1] .equals(player))
        {
            return true;
        }
        else if(board[0][2].equals(player) && board[1][2].equals(player)&& board[2][2].equals(player))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private static boolean isRowWin(String player) // checks for a row win for the specified player
    {
        if(board[0][0].equals(player) &&  board[0][1].equals(player)  &&  board[0][2].equals(player))
        {
            return true;
        }
        else if(board[1][0].equals(player) && board[1][1].equals(player) &&  board[1][2] .equals(player))
        {
            return true;
        }
        else if(board[2][0].equals(player) && board[2][1].equals(player)&& board[2][2].equals(player))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private static boolean isDiagonalWin(String player) // checks for a diagonal win for the specified player
    {
        if(board[0][0].equals(player) &&  board[1][1].equals(player)  &&  board[2][2].equals(player))
        {
            return true;
        }
        else if(board[2][0].equals(player) && board[1][1].equals(player) &&  board[0][2] .equals(player))
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    private static boolean isTie(int x) // checks for a tie condition: all spaces on the board are filled OR there is an X and an O in every win vector (i.e. all possible 8 wins are blocked by having both and X and an O in them.)
    {
        if(x == 9)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
