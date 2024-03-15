import java.util.Arrays;

public class Board {
    String[][] board;
    boolean finish = false;
    public Board() {
        board = new String[][]{{" ", " A ", " B ", " C "}, {"1", " * ", " * ", " * "}, {"2", " * ", " * ", " * "}, {"3", " * ", " * ", " * "}};
        PrintBoard();
        System.out.println("Let's play a game of Tic Tac Toe, When prompted enter your preferred spot for your mark e.g 1A");
    }
    public void UpdateBoard(int row, int col, int type){
        if(board[row][col].equals(" * ")) {
            if (type == 1)
                board[row][col] = " O ";
            if (type == 2)
                board[row][col] = " X ";

            PrintBoard();
        }else{
            System.out.println("The spot is already used");
        }
        String win = CheckWinState();
        if(!win.equals("")) {
            System.out.println(win);
            finish = true;
        }
    }
    private void PrintBoard(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public boolean isFinish() {
        return finish;
    }

    private String CheckWinState(){
        String p1="Player 1 wins";
        String p2="Player 2 wins";
        String characterP1 = " O ";
        String characterP2 = " X ";

        if(board[1][1].equals(characterP1) && board[2][2].equals(characterP1) && board[3][3].equals(characterP1)){
            return p1;
        }
        if(board[1][3].equals(characterP1) && board[2][2].equals(characterP1) && board[3][1].equals(characterP1)){
            return p1;
        }
        if(board[1][1].equals(characterP2) && board[2][2].equals(characterP2) && board[3][3].equals(characterP2)){
            return p2;
        }
        if(board[1][3].equals(characterP2) && board[2][2].equals(characterP2) && board[3][1].equals(characterP2)){
            return p2;
        }

        for(int i=1;i<4;i++){
            int countP1R = 0;
            int countP1C = 0;
            int countP2R = 0;
            int countP2C = 0;
            for(int j=1;j<4;j++){
                countP1R = (board[i][j].equals(characterP1))? countP1R+1 : countP1R-1;
                countP1C = (board[j][i].equals(characterP1))? countP1C+1 : countP1C-1;
                countP2R = (board[i][j].equals(characterP2))? countP2R+1 : countP2R-1;
                countP2C = (board[j][i].equals(characterP2))? countP2C+1 : countP2C-1;
            }
            if(countP1R==3 || countP1C==3) {
                return p1;
            }
            if(countP2R==3 || countP2C==3){
                return p2;
            }
        }
        boolean full = true;
        for(int i=1;i<4;i++){
            for(int j=1;j<4;j++){
                if(board[i][j].equals(" * ")){
                    full = false;
                }
            }
        }
        if(full){
            return "Draw";
        }
        return "";
    }
}
