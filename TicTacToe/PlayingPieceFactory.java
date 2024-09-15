package TicTacToe;

public class PlayingPieceFactory {
	public Piece getPiece(PieceType pieceType) {
		if (pieceType.equals(PieceType.X))
		{
			return new Piece(pieceType);
		} else if (pieceType.equals(PieceType.O)) {
			return new Piece(pieceType);
		}
		else {
			return null;
		}
	}
}
