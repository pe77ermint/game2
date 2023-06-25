package original;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardGame {
    public static String [][] board = new String [4][4];
    public static String [][] cards = new String [4][4];
    public static Scanner scanner = new Scanner(System.in);

    public static void printBoard(){

        for(int i = 0;i<4; i++){
            System.out.print(" . ");
            for(int j = 0; j<4; j++){
                System.out.print(board[i][j]);
                System.out.print(" . ");
            }
            System.out.println();
        }
    }

    public static void shuffleCards(){
        Random random = new Random();
        ArrayList<String> letters = new ArrayList<String>();
        letters.add("P");
        letters.add("T");
        letters.add("Z");
        letters.add("L");
        letters.add("W");
        letters.add("Q");
        letters.add("S");
        letters.add("A");
        letters.add("P");
        letters.add("T");
        letters.add("Z");
        letters.add("L");
        letters.add("W");
        letters.add("Q");
        letters.add("S");
        letters.add("A");

        int index;
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                index = random.nextInt(letters.size());
                cards[i][j] = letters.get(index);
                letters.remove(index);
            }
        }



    }

    public static void checkInput(String [][] cards){
        while(true){
            if(!gameOver()){
                System.out.println("Row: (1-4)");
                int row1 = scanner.nextInt();
                System.out.println("Column: (1-4)");
                int column1 = scanner.nextInt();

                if(!board[row1-1][column1-1].equals(" $ ")){
                    System.out.println("Already Entered!");
                    System.out.println();

                    printBoard();
                    continue;
                }else{
                    board[row1-1][column1-1] = " " + cards[row1-1][column1-1] + " ";
                    printBoard();
                }

                System.out.println("Row: (1-4)");
                int row2 = scanner.nextInt();
                System.out.println("Column: (1-4)");
                int column2 = scanner.nextInt();

                if(!board[row2-1][column2-1].equals(" $ ")){
                    System.out.println("Already Entered");
                    board[row1-1][column1-1] = " $ ";
                    System.out.println();

                    printBoard();
                    continue;
                }else{
                    board[row2-1][column2-1] = " " + cards[row2-1][column2-1] + " ";

                    if( board[row1-1][column1-1].equals( board[row2-1][column2-1])){
                        printBoard();
                        System.out.println("Correct!");
                    }else{
                        printBoard();
                        System.out.println("False!");
                        board[row1-1][column1-1] = " $ ";
                        board[row2-1][column2-1] = " $ ";
                        printBoard();
                    }
                }
            }else{
                System.out.println("Game Over");
                break;
            }
        }
    }

    public static boolean gameOver(){
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                if(board[i][j].equals(" $ ")){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        while (true){
            System.out.println("Press n for new game, q to quit");
            String nq = scanner.nextLine();
            if(nq.equals("q")){
                System.out.println("Exitting...");
                break;
            }else if(nq.equals("n")){

                shuffleCards();
                for(int i = 0; i<4; i++){
                    for(int j = 0; j<4; j++){
                        board[i][j] = " $ ";
                    }
                }

                printBoard();
                checkInput(cards);
                break;

            }else{
                System.out.println("Invalid Character");
                continue;
            }
        }
    }
}
