package TicTacToe;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Player {
	@Getter
	public String name;
	public Piece piece;
	public Board board;

	public boolean play(int rowIndex, int columnIndex) {
		if (validatePlayerMove(rowIndex, columnIndex))
		{
			this.board.getBoard().get(rowIndex).get(columnIndex).setPiece(piece);
			return true;
		}
		return false;
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
