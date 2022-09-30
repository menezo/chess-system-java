package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Print source: ");
			ChessPosition source = UI.readChessPosition(sc);
			System.out.print("Print target: ");
			ChessPosition target = UI.readChessPosition(sc);
			chessMatch.performChessMove(source, target);
		}

	}

}
