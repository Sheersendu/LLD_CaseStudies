package TicTacToe;

import lombok.Getter;

import java.util.List;

@Getter
public class Board {
	private final int totalRows;
	private final int totalColumns;
	public List<List<Cell>> board;

	public Board(int totalRows, int totalColumns)
	{
		this.totalRows = totalRows;
		this.totalColumns = totalColumns;
		for(int row = 0; row<totalRows; row++) {
			for (int col = 0; col < totalColumns; col++) {
				board.get(row).set(col, new Cell());
			}
		}
	}

	public String checkBoardStatus() {
		return "";
	}
}
