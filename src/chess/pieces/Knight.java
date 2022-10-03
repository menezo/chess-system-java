package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "N";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		p.setValues(position.getRow(), position.getColumn());

		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				if (i != 0 && j != 0 && i != j && (i + j != 0)) {
					p.setValues(position.getRow() + i, position.getColumn() + j);
					if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
						mat[p.getRow()][p.getColumn()] = true;
					} else if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
						mat[p.getRow()][p.getColumn()] = true;
					}					
				}
			}
		}
		return mat;
	}
}
