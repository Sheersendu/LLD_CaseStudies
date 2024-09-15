package TicTacToe;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Cell {
	@Getter
	public Piece piece;
	public Cell()
	{
		piece = null;
	}
}
