package TicTacToe;

import lombok.Getter;

import java.util.ArrayList;
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
		this.board = new ArrayList<>();
		for(int row = 0; row<totalRows; row++) {
			List<Cell> currentRow = new ArrayList<>();
			for (int col = 0; col < totalColumns; col++) {
				currentRow.add(new Cell());
			}
			board.add(currentRow);
		}
	}

	public GameStatus checkBoardStatus() {
		// check for all rows
		for(int row = 0; row<totalRows; row++) {
			Piece firstColumn = this.board.get(row).get(0).getPiece();
			Piece middleColumn = this.board.get(row).get(1).getPiece();
			Piece lastColumn = this.board.get(row).get(2).getPiece();
			if (firstColumn == middleColumn && middleColumn == lastColumn && firstColumn != null && middleColumn != null && lastColumn != null)
			{
				return GameStatus.WIN;
			}
		}
		// check all cols
		for(int col = 0; col<totalColumns; col++) {
			Piece firstRow = this.board.get(0).get(col).getPiece();
			Piece middleRow = this.board.get(1).get(col).getPiece();
			Piece lastRow = this.board.get(2).get(col).getPiece();
			if (firstRow == middleRow && middleRow == lastRow && firstRow != null && middleRow != null && lastRow != null) {
				return GameStatus.WIN;
			}
		}
		// check diagonals
		Piece middlePiece = this.board.get(1).get(1).getPiece();
		Piece topLeft = this.board.get(0).getFirst().getPiece();
		Piece bottomRight = this.board.get(2).get(2).getPiece();
		if (topLeft == middlePiece && middlePiece == bottomRight && topLeft != null && middlePiece != null && bottomRight != null)
		{
			return  GameStatus.WIN;
		}
		Piece topRight = this.board.get(0).getLast().getPiece();
		Piece bottomLeft = this.board.get(2).getFirst().getPiece();
		if (topRight == middlePiece && middlePiece == bottomLeft && topRight != null && middlePiece != null && bottomLeft != null)
		{
			return  GameStatus.WIN;
		}

		// Check for draw status
		int filledCellsCount = 0;
		for(int row = 0; row<totalRows; row++) {
			for (int col = 0; col < totalColumns; col++) {
				if (this.board.get(row).get(col).getPiece() != null)
				{
					filledCellsCount += 1;
				}
			}
		}
		if (filledCellsCount == (totalColumns*totalRows))
		{
			return  GameStatus.DRAW;
		}
		return GameStatus.UNDECIDED;
	}

	public void displayBoard()
	{
		for(int row = 0; row<totalRows; row++) {
			for(int col = 0; col<totalColumns; col++)
			{
				System.out.print(" | ");
				Piece piece = board.get(row).get(col).getPiece();
				if(piece == null) {
					System.out.print(" ");
				}
				else {
					System.out.print(piece.type);
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
	}
}
