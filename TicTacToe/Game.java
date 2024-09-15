package TicTacToe;

import java.util.*;

public class Game {
	private Board board;
	private List<Player> playerList;
	private int currentPlayerIndex;
	private PlayingPiece playingPiece;
	private Player currentPlayer;
	private final Scanner scanner;
	private GameStatus gameStatus;
//	private final Map<Piece, Player> piecePlayerMap;

	public Game()
	{
		scanner = new Scanner(System.in);
		System.out.println("------Welcome to TicTacToe Game------");
		board = new Board(3, 3);
		playingPiece = new PlayingPiece(new PlayingPieceFactory());
		playerList = new ArrayList<>();
		gameStatus = GameStatus.UNDECIDED;
//		piecePlayerMap = new HashMap<>();

		// Player 1 Setup
		System.out.println("Enter your name Player 1: ");
		String player1Name = scanner.nextLine();
		System.out.println("Choose your Piece(X, O): ");
		PieceType player1PieceType = PieceType.valueOf(scanner.nextLine());
		Piece player1Piece = playingPiece.getPiece(player1PieceType);
		Player player1 = new Player(player1Name, player1Piece, board);
		playerList.add(player1);
//		piecePlayerMap.put(player1Piece, player1);
		currentPlayerIndex = 0;

		// Player 2 Setup
		System.out.println("Enter your name Player 2: ");
		String player2Name = scanner.nextLine();
		System.out.println("Choose your Piece(X, O): ");
		PieceType player2PieceType = PieceType.valueOf(scanner.nextLine());
		Piece player2Piece = playingPiece.getPiece(player2PieceType);
		Player player2 = new Player(player2Name, player2Piece, board);
		playerList.add(player2);
//		piecePlayerMap.put(player2Piece, player2);
	}

	public void start() throws Exception {
		while(true) {
			switch (gameStatus) {
				case UNDECIDED -> {
					nextTurn();
					System.out.println(currentPlayer.getName() + " make your move (row,col): ");
					String[] userInput = scanner.nextLine().split(",");
					int userInputRow = Integer.parseInt(userInput[0]);
					int userInputColumn = Integer.parseInt(userInput[1]);
					if (currentPlayer.play(userInputRow, userInputColumn)) {
						gameStatus = checkStatus();
					}
					else{
						throw new Exception("Invalid move! Game over!");
					}
				}
				case WIN -> {
					System.out.println("Winner is :" + currentPlayer.getName());
					return;
				}
				case DRAW -> {
					System.out.println("Its a draw!");
					return;
				}
			}
		}
	}

	public void nextTurn()
	{
		currentPlayer = playerList.get(currentPlayerIndex);
		currentPlayerIndex ^= 1;
	}

	public GameStatus checkStatus()
	{
		return this.board.checkBoardStatus();
	}
}
