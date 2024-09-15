package TicTacToe;

public class GameManager {
	public static void main(String[] args) {
		Game game = new Game();
		try {
			game.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
	}
}
