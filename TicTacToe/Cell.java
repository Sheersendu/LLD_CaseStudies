package TicTacToe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
	public Piece piece;
	public Cell()
	{
		piece = null;
	}
}
