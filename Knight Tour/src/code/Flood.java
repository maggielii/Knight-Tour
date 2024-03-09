package code;

public class Flood {

	public static void main(String[] args) {
		
		Board chessboard = new Board(5);

		chessboard.display();
		
		chessboard.findKnightTours();
		
	}

}
