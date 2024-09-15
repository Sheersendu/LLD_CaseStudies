package TicTacToe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
	public String name;
	public Piece piece;
	public Board board;

	public void play(int rowIndex, int columnIndex) throws Exception {
		if (validatePlayerMove(rowIndex, columnIndex))
		{
			this.board.getBoard().get(rowIndex).get(columnIndex).setPiece(piece);
		}
		throw new Exception("Invalid move! Game over!");
	}

	private boolean validatePlayerMove(int rowIndex, int columnIndex)
	{
		if (rowIndex < 0 || rowIndex >= board.getTotalRows() || columnIndex < 0 || columnIndex >= board.getTotalColumns())
		{
			return this.board.getBoard().get(rowIndex).get(columnIndex) == null;
		}
		return true;
	}
}
