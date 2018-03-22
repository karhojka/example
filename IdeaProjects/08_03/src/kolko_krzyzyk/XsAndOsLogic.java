package kolko_krzyzyk;

import java.util.Random;
import java.util.Scanner;

public class XsAndOsLogic {

    private final int SIZE = 3; // final -> zmienna tylko raz może być zainicjalizowana
    String x = "x";
    String o = "o";
    String empty = "-";
    int[][] board;
    String[][] boardString;
    boolean isFin = true;
    String ourString;
    String oppString;
    int symbolNumber = 0;

    Random randnum = new Random();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN_bck = "\u001B[47m";


    public XsAndOsLogic() {
        init();
    }
//////////////////////////////////////////////////////////////////

    private void init() {
        board = new int[SIZE][SIZE];
        boardString = new String[SIZE][SIZE];

        int k = 1;
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                board[i][j] = k++;
                boardString[i][j] = "-";
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////
    public void printBoard() {
        System.out.println(ANSI_RED +"Welcome!\n" + ANSI_BLUE+"this is our board:" + ANSI_RESET);
        for (int i = 0; i < SIZE; i++) {
            System.out.print(ANSI_BLUE + "\t" + "|" + "\t" + ANSI_RESET);
            for (int j = 0; j < SIZE; j++) {

                System.out.print(ANSI_PURPLE + board[i][j] + ANSI_RESET);
                System.out.print(ANSI_BLUE +"\t" + "|" + "\t" + ANSI_RESET);

            }

            System.out.println();

        }
    }


//-------------------------------------------------------------------------------------------------------------

    public void move() {
        Scanner in = new Scanner(System.in);

        System.out.println("\nchoose your symbol");
        String string = in.nextLine();


      if (string.equals(x)) {
          symbolNumber = 1;
          oppString = o;
          System.out.println("so, your opponent's symbol is: " + oppString);
      }

      else if(string.equals(o)) {

            symbolNumber = 0;
            oppString = x;
           System.out.println("so, your opponent's symbol is: " + oppString);
      }

      else {
            System.out.println(" your symbol is wrooong\n THE END ");
            isFin = false;
        }

       //////////////////////////////////////////////////////////////////////////



        while (isFin) {

            symbolNumber = symbolNumber + 1;              // określamy symbolNumber  i znak w każdej pętli

            if (symbolNumber % 2 == 0) {
                ourString = o;
            }
            else
                ourString = x;

            System.out.println("\nchoose field number:");


                int boardNum = in.nextInt();     //  na naszej planszy z numerami wybieramy pole

            switch (boardNum) {
                case 1:
                    if(boardString[0][0].equals(empty)){
                    boardString[0][0] = ourString;
                    break;}
                    else {symbolNumber--;
                        System.out.println("to pole jest już zajęte!\nwybierz nowe:");break;}
                case 2:
                    if(boardString[0][1].equals(empty)){
                    boardString[0][1] = ourString;
                    break;}
                    else {symbolNumber--;
                        System.out.println("to pole jest już zajęte!\nwybierz nowe:");break;}
                case 3:
                    if(boardString[0][2].equals(empty)){
                    boardString[0][2] = ourString;
                    break;}
                    else {symbolNumber--;
                        System.out.println("to pole jest już zajęte!\nwybierz nowe:");break;}
                case 4:
                    if(boardString[1][0].equals(empty)){
                    boardString[1][0] = ourString;
                    break;}
                    else {symbolNumber--;
                        System.out.println("to pole jest już zajęte!\nwybierz nowe:");break;}
                case 5:
                    if(boardString[1][1].equals(empty)){
                    boardString[1][1] = ourString;
                    break;}
                    else {symbolNumber--;
                        System.out.println("to pole jest już zajęte!\nwybierz nowe:");break;}
                case 6:
                    if(boardString[1][2].equals(empty)){
                    boardString[1][2] = ourString;
                    break;}
                    else {symbolNumber--;
                        System.out.println("to pole jest już zajęte!\nwybierz nowe:");break;}
                case 7:
                    if(boardString[2][0].equals(empty)){
                    boardString[2][0] = ourString;
                    break;}
                    else {symbolNumber--;
                        System.out.println("to pole jest już zajęte!\nwybierz nowe:");break;}
                case 8:
                    if(boardString[2][1].equals(empty)){
                    boardString[2][1] = ourString;
                    break;}
                    else {symbolNumber--;
                        System.out.println("to pole jest już zajęte!\nwybierz nowe:");break;}
                case 9:
                    if(boardString[2][2].equals(empty)){
                    boardString[2][2] = ourString;
                    break;}
                    else {symbolNumber--;
                        System.out.println("to pole jest już zajęte!\nwybierz nowe:");break;}
            }

            printBoardString(); // wyświetlanie planszy po każdym ruchu

            isFin=isFinished(); // czy kończymy grę?

        }
/////////////////////////////////////////////////////////////////////////////

    }

 public void printBoardString() {

        for (int i = 0; i < SIZE; i++) {
            System.out.print("\t" + "|" + "\t");
            for (int j = 0; j < SIZE; j++) {

                System.out.print(boardString[i][j]);
                System.out.print("\t" + "|" + "\t");

            }

            System.out.println();

        }
    }

    ////////////////////////////////////////////////////////////////////////
    // sprawdzamy warunki:

    public int isFull() {

        int isFull = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if ((boardString[i][j]== o || boardString[i][j]== x))
                  isFull++;
            }
        }
        return isFull;
    }

    public int inRows() {

        int inRows = 0;
        for (int i = 0; i < SIZE; i++) {
            if ((boardString[i][0]!=empty)&&(boardString[i][0] == boardString[i][1]) && (boardString[i][1] == boardString[i][2])) inRows++;
        }
        return inRows;
    }

    public int inColumns() {

        int inColumns = 0;
        for (int i = 0; i < SIZE; i++) {
            if ((boardString[1][i]!=empty)&&(boardString[0][i] == boardString[1][i]) && (boardString[1][i] == boardString[2][i])) inColumns++;
        }
        return inColumns;
    }

    public int inDiagonalOne() {
        int inDiag = 0;
        if ((boardString[1][1]!=empty)&&(boardString[0][0] == boardString[1][1]) && (boardString[1][1] == boardString[2][2])) inDiag++;
        return inDiag;


};
    public int inDiagonalTwo() {
        int inDiag = 0;
        if ((boardString[1][1]!=empty)&&(boardString[0][2].equals(boardString[1][1])) && (boardString[1][1].equals(boardString[2][0]))) inDiag++;
        return inDiag;
    }


//----------------------------------------------------------------------------------------------
   public boolean isFinished(){

        if(inColumns()!=0 || inRows()!=0 || inDiagonalTwo()!=0 || inDiagonalOne()!=0){
            System.out.println(ANSI_RED+"THE END!\n and the winer is: " + ourString + " :)" );
        return false;}
        else if(isFull()==9){
            System.out.println(ANSI_BLUE+"\n there is no winner tho :(" );
            return false;}
         else
    return true;
   }
}
