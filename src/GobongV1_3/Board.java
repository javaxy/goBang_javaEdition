package GobongV1_3;

@SuppressWarnings("serial")
public class Board implements java.io.Serializable {

	private int board[][];

	public Board(int[][] board) {
		this.board = board;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

}
