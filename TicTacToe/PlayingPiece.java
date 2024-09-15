package TicTacToe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayingPiece {
	private PlayingPieceFactory playingPieceFactory;

	public Piece getPiece(PieceType type) {
		return playingPieceFactory.getPiece(type);
	}
}
