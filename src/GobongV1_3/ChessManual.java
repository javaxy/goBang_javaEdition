package GobongV1_3;

import java.util.ArrayList;

public class ChessManual {

	private int N = 15;
	private ArrayList<int[][]> chessmanual = new ArrayList<int[][]>();

	private chessBoard chessboard;

	public ChessManual(chessBoard chessboard) {
		this.chessboard = chessboard;
	}

	// 返回是棋盘是否成功
	public boolean pipeiqipan() {
		// 得到棋谱
		for (int k = 0; k < chessmanual.size(); k++) {
			int count = 0;// 计数器
			// 匹配棋谱
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					if (getchessNO() % 2 == 1// 人先下
							&& getCount(chessmanual.get(k)) % 2 == 0 // 后手方赢
							|| getchessNO() % 2 == 0// 电脑先下
							&& getCount(chessmanual.get(k)) % 2 == 1// 先手方赢
					)
						if (data.BOARDSTEP[i][j] != 0
								&& chessmanual.get(k)[i][j] != 0) {
							if (chessmanual.get(k)[i][j] == data.BOARDSTEP[i][j]) {
								count++;

							}
						}
				}
			// 如果步数满足，就按棋谱下
			int step = getchessNO();
			if (count == step) {
				for (int i = 0; i < 15; i++)
					for (int j = 0; j < 15; j++) {
						if (chessmanual.get(k)[i][j] == (count + 1)) {
							step++;
							data.ARRAY[i][j] = 2;
							data.BOARDSTEP[i][j] = step;
							chessboard.appendText("黑：横 " + (i+1) + " 竖 " + (j+1)
									+ " 步数 " + data.BOARDSTEP[i][j]);
						}
					}
				return true;
			}
		}
		return false;
	}

	public int getCount(int board[][]) {
		int count = 0;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (board[i][j] != 0) {
					count++;
				}
			}
		}
		return count;
	}

	// 获得棋盘上的步数的个数，返回值为棋盘上棋子子的个数
	public int getchessNO() {
		int step = 0;
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (data.ARRAY[i][j] != 0) {
					step = step + 1;
				}
			}

		return step;
	}

	// 读取文件中的数组，将其添加到chessmanual中进行匹配
	public void toArray() {
		ArrayList<Board> step = FileOperation.readFile();
		if (step == null)
			return;
		for (int i = 0; i < step.size(); i++) {
			Board b = step.get(i);
			int array[][] = b.getBoard();
			chessmanual.add(array);
			array = mirsym(array);
			chessmanual.add(array);
			array = horsym(array);
			chessmanual.add(array);
			array = mirsym(array);
			chessmanual.add(array);
			array = versym(array);
			chessmanual.add(array);
			array = mirsym(array);
			chessmanual.add(array);
			array = horsym(array);
			chessmanual.add(array);
			array = mirsym(array);
			chessmanual.add(array);
		}
	}

	// 水平对称
	public int[][] horsym(int[][] array) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = array[N - 1 - i][j];
			}
		}
		return temp;
	}

	// 垂直对称
	public int[][] versym(int[][] array) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = array[i][N - 1 - j];
			}
		}
		return temp;
	}

	// 镜像对称
	public int[][] mirsym(int[][] array) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[j][i] = array[i][j];
			}
		}
		return temp;
	}
}
