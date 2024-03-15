import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        Board newGame = new Board();
        System.out.println("Please enter Player 1 name: ");
        String player1Name = scanInput.next();
        Player player1 = new Player(player1Name, newGame,1);
        System.out.println("Please enter Player 2 name: ");
        String player2Name = scanInput.next();
        Player player2 = new Player(player2Name, newGame,2);
        System.out.println("Let's start!");
        GameController gameController = new GameController(newGame,player1,player2);
        gameController.PlayGame();

    }
}
