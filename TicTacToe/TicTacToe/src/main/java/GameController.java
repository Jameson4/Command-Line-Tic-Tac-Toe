import java.util.Scanner;

public class GameController {

    Player player1, player2;
    Board board;
    boolean finished = false;
    Scanner scanInput = new Scanner(System.in);
    public GameController(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void PlayGame(){
        boolean currPlayer = true;
        boolean notDone = true;
        String move = "";
        String playAgain = "";
        while(notDone){
            if(currPlayer){
                System.out.println(player1.getName()+" make your move: ");
                while(!scanInput.hasNext("[123][abcABC]")){
                    System.out.println("That is not a valid position please try again.");
                    scanInput.next();
                }
                move = scanInput.next();
                MakeMove(player1,move);
                currPlayer = !currPlayer;
            }else{
                System.out.println(player2.getName()+" make your move: ");
                while(!scanInput.hasNext("[123][abcABC]")){
                    System.out.println("That is not a valid position please try again.");
                    scanInput.next();
                }
                move = scanInput.next();
                MakeMove(player2,move);
                currPlayer = !currPlayer;
            }
            if(board.isFinish()){
                System.out.println("Would you like to play again? Y/N");
                playAgain = scanInput.next();
                char temp = playAgain.charAt(0);
                switch(Character.toUpperCase(temp)){
                    case 'N': notDone = false;
                }
            }
        }
    }

    private void MakeMove(Player player, String move){
        char tempRow = move.charAt(0);
        char tempCol = move.charAt(1);
        int row,col=0;
        switch(Character.toUpperCase(tempCol)){
            case 'A': col = 1;
                break;
            case 'B': col = 2;
                break;
            case 'C': col = 3;
                break;
        }
        row = Character.getNumericValue(tempRow);

        player.AddMove(row,col);
    }
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
