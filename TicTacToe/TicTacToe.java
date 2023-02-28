import java.util.*;

public class TicTacToe {

    // Global player and CPU positions
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);


        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            // Users' position
            int playerPos = scan.nextInt();
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("Position taken try again: ");
                playerPos = scan.nextInt();
            }
            placePiece(gameBoard, playerPos, "player");
            String result = checkWinner();

            if (result.length() > 0 ) {
                System.out.print(result);
                break;
            }
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);

            result = checkWinner();
            if (result.length() > 0 ) {
                System.out.print(result);
                break;
            }

        }


    }
        public static void printGameBoard(char [] [] gameBoard) {
            for (char[] row : gameBoard) {
                for(char c : row) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }

        public static void placePiece(char[] [] gameBoard, int pos, String user){
            char symbol = ' ';
            if(user.equals("player")) {
                symbol = 'X';
                playerPositions.add(pos);
            } else if (user.equals("cpu")){
                symbol = 'O';
                cpuPositions.add(pos);
            }

            switch(pos) {
                case 1:
                    gameBoard[0][0]=symbol;
                    break;
                case 2:
                    gameBoard[0][2]=symbol;
                    break;
                case 3:
                    gameBoard[0][4]=symbol;
                    break;
                case 4:
                    gameBoard[2][0]=symbol;
                    break;
                case 5:
                    gameBoard[2][2]=symbol;
                    break;
                case 6:
                    gameBoard[2][4]=symbol;
                    break;
                case 7:
                    gameBoard[4][0]=symbol;
                    break;
                case 8:
                    gameBoard[4][2]=symbol;
                    break;
                case 9:
                    gameBoard[4][4]=symbol;
                    break;
                default:
                    break;
            }
        }
    public static String checkWinner() {
        // WINNING CONDITIONS
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List topCol = Arrays.asList(1, 4, 7);
        List middleCol = Arrays.asList(2, 5, 8);
        List bottomCol = Arrays.asList(3, 6, 9);
        //  Hit a diagonal
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winningCond = new ArrayList<List>();
        winningCond.add(topRow);
        winningCond.add(middleRow);
        winningCond.add(bottomRow);
        winningCond.add(topCol);
        winningCond.add(middleCol);
        winningCond.add(bottomCol);
        winningCond.add(cross1);
        winningCond.add(cross2);

        for (List l: winningCond) {
            if(playerPositions.containsAll(l)) {
                
                return "Congratulations you won!";
            }else if(cpuPositions.containsAll(l)){
                return "You lost!";
            }else if (playerPositions.size() + cpuPositions.size() == 9 ) {
                return "GAME OVER";
            }
        }
        return"";

    }
}