import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private final String name;
    int playerType;
    private HashMap<Integer,Integer> moves;
    private Board gameBoard;
    public Player(String name, Board game, int playerNumber) {
        this.name = name;
        moves = new HashMap<>();
        gameBoard = game;
        playerType = playerNumber;
    }
    public void AddMove(int row, int col){
        moves.put(row,col);
        gameBoard.UpdateBoard(row,col,playerType);
    }
    public String getName() {
        return name;
    }
}
