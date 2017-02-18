package GobongV1_2;

import java.util.ArrayList;

public class ChessManual {

	public static final int N = 15;

	public static ArrayList<int[][]> chessmanual = new ArrayList();

	public ChessManual() {
		cm1();
		cm2();
		cm3();
		cm4();
		cm5();
		cm6();
		cm7();
		cm8();
		cm9();
		cm10();
		// for (int i = 0; i < N; i++) {
		// for (int j = 0; j < N; j++) {
		// System.out.print(chessmanual.get(21)[i][j] + "  ");
		// }
		// System.out.println();
		// }
	}

	private void cm1() {
		int[][] array = new int[N][N];
		int[][] temp = { { 7, 7 }, { 7, 6 }, { 8, 6 }, { 6, 6 }, { 6, 8 },
				{ 5, 9 }, { 9, 7 }, { 9, 5 }, { 8, 7 }, { 10, 7 }, { 8, 8 },
				{ 8, 9 }, { 7, 9 }, { 6, 10 }, { 5, 7 } };
		for (int i = 0; i < temp.length; i++) {
			array[temp[i][0]][temp[i][1]] = i + 1;
		}
		addcm(array);
	}

	private void cm2() {
		int[][] array = new int[N][N];
		int[][] temp = { { 7, 7 }, { 7, 6 }, { 8, 6 }, { 6, 6 }, { 6, 8 },
				{ 5, 9 }, { 9, 7 }, { 9, 5 }, { 8, 7 }, { 6, 7 }, { 8, 5 },
				{ 8, 4 }, { 10, 6 }, { 8, 8 }, { 10, 8 }, { 7, 5 }, { 10, 7 } };
		for (int i = 0; i < temp.length; i++) {
			array[temp[i][0]][temp[i][1]] = i + 1;
		}
		addcm(array);
	}

	private void cm3() {
		int[][] array = new int[N][N];
		int[][] temp = { { 7, 7 }, { 7, 6 }, { 8, 6 }, { 6, 6 }, { 6, 8 },
				{ 5, 9 }, { 9, 7 }, { 9, 5 }, { 8, 7 }, { 6, 7 }, { 8, 5 },
				{ 8, 8 }, { 7, 4 }, { 9, 6 }, { 6, 4 }, { 7, 5 }, { 8, 4 } };
		for (int i = 0; i < temp.length; i++) {
			array[temp[i][0]][temp[i][1]] = i + 1;
		}
		addcm(array);
	}

	private void cm4() {
		int[][] array = new int[N][N];
		int[][] temp = { { 7, 7 }, { 7, 6 }, { 8, 6 }, { 6, 6 }, { 6, 8 },
				{ 5, 9 }, { 9, 7 }, { 9, 5 }, { 8, 7 }, { 6, 7 }, { 8, 5 },
				{ 8, 8 }, { 6, 4 }, { 7, 5 }, { 7, 4 } };
		for (int i = 0; i < temp.length; i++) {
			array[temp[i][0]][temp[i][1]] = i + 1;
		}
		addcm(array);
	}

	private void cm5() {
		int[][] array = new int[N][N];
		int[][] temp = { { 7, 7 }, { 7, 6 }, { 8, 6 }, { 6, 6 }, { 6, 8 },
				{ 5, 9 }, { 9, 7 }, { 9, 5 }, { 8, 7 }, { 6, 7 }, { 10, 8 },
				{ 11, 9 }, { 8, 8 }, { 8, 5 } };
		for (int i = 0; i < temp.length; i++) {
			array[temp[i][0]][temp[i][1]] = i + 1;
		}
		addcm(array);
	}

	private void cm6() {
		int[][] array = new int[N][N];
		int[][] temp = { { 7, 7 }, { 7, 6 }, { 8, 6 }, { 6, 6 }, { 6, 8 },
				{ 5, 9 }, { 9, 7 }, { 9, 5 }, { 8, 7 }, { 6, 7 }, { 10, 8 },
				{ 11, 9 }, { 8, 8 }, { 8, 9 }, { 10, 5 } };
		for (int i = 0; i < temp.length; i++) {
			array[temp[i][0]][temp[i][1]] = i + 1;
		}
		addcm(array);
	}

	private void cm7() {
		int[][] array = new int[N][N];
		int[][] temp = { { 7, 7 }, { 7, 6 }, { 8, 6 }, { 8, 5 }, { 6, 8 },
				{ 9, 5 }, { 6, 7 }, { 6, 5 }, { 7, 5 }, { 9, 8 }, { 8, 7 },
				{ 9, 7 }, { 5, 7 }, { 4, 7 }, { 9, 6 } };
		for (int i = 0; i < temp.length; i++) {
			array[temp[i][0]][temp[i][1]] = i + 1;
		}
		addcm(array);
	}

	private void cm8() {
		int[][] array = new int[N][N];
		int[][] temp = { { 7, 7 }, { 8, 6 }, { 8, 8 }, { 6, 6 }, { 9, 7 },
				{ 10, 6 }, { 9, 9 }, { 9, 8 }, { 8, 9 } };
		for (int i = 0; i < temp.length; i++) {
			array[temp[i][0]][temp[i][1]] = i + 1;
		}
		addcm(array);
	}

	private void cm9() {
		int[][] array = new int[N][N];
		int[][] temp = { { 7, 7 }, { 8, 6 }, { 8, 8 }, { 6, 6 }, { 9, 7 },
				{ 7, 9 }, { 9, 6 }, { 10, 7 }, { 10, 5 }, { 9, 5 }, { 11, 4 },
				{ 12, 3 }, { 9, 8 }, { 7, 8 }, { 12, 7 }, { 11, 6 }, { 12, 8 } };
		for (int i = 0; i < temp.length; i++) {
			array[temp[i][0]][temp[i][1]] = i + 1;
		}
		addcm(array);
	}

	private void cm10() {
		int[][] array = new int[N][N];
		int[][] temp = { { 7, 7 }, { 8, 6 }, { 8, 8 }, { 6, 6 }, { 9, 7 },
				{ 7, 9 }, { 9, 6 }, { 10, 7 }, { 10, 5 }, { 9, 5 }, { 11, 4 },
				{ 12, 3 }, { 9, 8 }, { 7, 8 }, { 12, 7 }, { 11, 8 }, { 11, 6 },
				{ 9, 4 }, { 12, 6 } };
		for (int i = 0; i < temp.length; i++) {
			array[temp[i][0]][temp[i][1]] = i + 1;
		}
		addcm(array);
		
		
	}

	public void addcm(int[][] array) {
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

	/**
	 * 水平对称
	 */
	public int[][] horsym(int[][] array) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = array[N - 1 - i][j];
			}
		}
		return temp;
	}

	/**
	 * 垂直对称
	 */
	public int[][] versym(int[][] array) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = array[i][N - 1 - j];
			}
		}
		return temp;
	}

	public int[][] mirsym(int[][] array) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[j][i] = array[i][j];
			}
		}
		return temp;
	}

	// static Graphics g;
	//
	// public ChessManual(Graphics g){
	// this.g=g;
	// }

	// 返回是棋盘是否成功
	public boolean pipeiqipan() {

		// 得到棋谱
		for (int k = 0; k <chessmanual.size() ; k++) {

			int count = 0;// 计数器
			// 匹配棋谱
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {

					if (data.BOARDSTEP[i][j] != 0
							&& chessmanual.get(k)[i][j] != 0) {

						if (chessmanual.get(k)[i][j] == data.BOARDSTEP[i][j]) {
							// System.out.println(data.BOARDSTEP[i][j]);
							count++;
							// System.out.println(count);
						}

					}
				}
			// 如果步数满足，就按棋谱下

			// System.out.println();
			if (count == chessBoard.step) {
				for (int i = 0; i < 15; i++)
					for (int j = 0; j < 15; j++) {
						if (chessmanual.get(k)[i][j] == (count + 1)) {
							chessBoard.step++;
							data.ARRAY[i][j] = 2;
							data.BOARDSTEP[i][j] = chessBoard.step;
						}
					}
				System.out.println("执行");
				System.out.println(k);
				System.out.println(count);
				System.out.println(chessBoard.step);
				return true;

			}

		}

		return false;

	}
}
