package TicTacToe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayingPiece {
	private static PlayingPieceFactory playingPieceFactory;

	public Piece getPiece(PieceType type) {
		return playingPieceFactory.getPiece(type);
	}
}
