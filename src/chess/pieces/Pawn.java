package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		int i = 1;

		if (getColor() == Color.WHITE) {
			i = -1;
		}
		p.setValues(position.getRow() + i, position.getColumn());
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		Position p2 = new Position(position.getRow() + i, position.getColumn());
		p.setValues(position.getRow() + i * 2, position.getColumn());
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
				&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setValues(position.getRow() + i, position.getColumn() + i);
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		p.setValues(position.getRow() + i, position.getColumn() + i * -1);
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// #specialmove en passant
		if (getColor() == Color.WHITE) {
			if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right)
						&& getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
			}}
			if (getColor() == Color.BLACK) {
				if (position.getRow() == 4) {
					Position left = new Position(position.getRow(), position.getColumn() - 1);
					if (getBoard().positionExists(left) && isThereOpponentPiece(left)
							&& getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
						mat[left.getRow() + 1][left.getColumn()] = true;
					}
					Position right = new Position(position.getRow(), position.getColumn() + 1);
					if (getBoard().positionExists(right) && isThereOpponentPiece(right)
							&& getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
						mat[right.getRow() + 1][right.getColumn()] = true;
					}
				}
			}


		return mat;
	}}
