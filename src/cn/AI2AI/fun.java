package cn.AI2AI;

import java.util.Random;

/**
 * 五子棋赋值算法
 * 
 * @author Administrator 还有一个BUG就是黑棋会往白棋堵死的地方下G
 */
public class fun {

	Random ra = new Random();
	private chessBoard chessBoard;

	int ONE = 16;
	int NOONE = 5;
	int TWO = 136;
	int BTHREE = 1300;
	int NOTWO = 10;
	int THREE = 1000;
	int NOTHREE = 130;
	int WWIN = 3000;
	int BWIN = 3300;
	fun1 hu1 = new fun1();

	public fun(chessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}

	public fun() {
	}

	public void putdown() {
		if (getchessNO() % 2 == 1) {
			value();
		} else {
			value2();
		}
		search();
	}

	// 寻找权值最大的点 ，并下棋子
	public void search() {
		int MAX = 0;
		int k = 0;

		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {

				if (data.VALUE[i][j] > MAX) {
					MAX = data.VALUE[i][j];

				}
			}

		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (data.VALUE[i][j] == MAX) {
					// System.out.println(MAX);
					data.VALUE[i][j] = k;
					k++;
				}
			}

		// 取随机下的点
		int q = ra.nextInt(k);
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (q == data.VALUE[i][j] && data.ARRAY[i][j] == 0) {
					// 记录此时下的位置
					data.BOARDSTEP[i][j] = getchessNO();
					if (getchessNO() % 2 == 1) {
						data.ARRAY[i][j] = 2;
						chessBoard
								.appendText("白：横 " + (i + 1) + " 竖 " + (j + 1)
										+ " 步数 " + (data.BOARDSTEP[i][j] + 1));
					} else {
						data.ARRAY[i][j] = 1;
						chessBoard
								.appendText("黑：横 " + (i + 1) + " 竖 " + (j + 1)
										+ " 步数 " + (data.BOARDSTEP[i][j] + 1));
					}
					chessBoard.repaint();
				}
			}
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

	public void value() {
		four();
		three();
		two();
		one();
		hu1.five();
		hu1.eight();
		hu1.twotwo();
		in();
	}

	public void value2() {
		three();
		two();
		one();
		in();
	}

	// 判断是否有棋子
	public void in() {
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (data.ARRAY[i][j] != 0) {
					data.VALUE[i][j] = -1;
				}
			}
	}

	// 判断是否四子了
	public void four() {
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {

				// 横排是否4个
				if (i < 12 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k] == data.ARRAY[i][k]
						&& data.ARRAY[i + 2][k] == data.ARRAY[i][k]
						&& data.ARRAY[i + 3][k] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						if (i == 0) {
							data.VALUE[i + 4][k] += WWIN;
						} else if (i == 11) {
							data.VALUE[i - 1][k] += WWIN;
						} else {
							data.VALUE[i + 4][k] += WWIN;
							data.VALUE[i - 1][k] += WWIN;
						}

					}
					if (data.ARRAY[i][k] == 2) {
						if (i == 0) {
							data.VALUE[i + 4][k] += BWIN;
						} else if (i == 11) {
							data.VALUE[i - 1][k] += BWIN;
						} else {
							data.VALUE[i + 4][k] += BWIN;
							data.VALUE[i - 1][k] += BWIN;
						}

					}
				}

				// 判断竖排是否有4个
				if (k < 12 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i][k + 2]
						&& data.ARRAY[i][k + 3] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						if (k == 0) {
							data.VALUE[i][k + 4] += WWIN;
						} else if (k == 11) {
							data.VALUE[i][k - 1] += WWIN;
						} else {
							data.VALUE[i][k + 4] += WWIN;
							data.VALUE[i][k - 1] += WWIN;
						}

					}

					if (data.ARRAY[i][k] == 2) {
						if (k == 0) {
							data.VALUE[i][k + 4] += BWIN;
						} else if (k == 11) {
							data.VALUE[i][k - 1] += BWIN;
						} else {
							data.VALUE[i][k + 4] += BWIN;
							data.VALUE[i][k - 1] += BWIN;
						}

					}
				}

				// 判断右斜排是否有4个
				if (i < 12 && k < 12
						&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i + 2][k + 2]
						&& data.ARRAY[i + 3][k + 3] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						if (i == 0 || k == 0) {
							data.VALUE[i + 4][k + 4] += WWIN;
						} else if (i == 11 || k == 11) {
							data.VALUE[i - 1][k - 1] += WWIN;
						} else {
							data.VALUE[i + 4][k + 4] += WWIN;
							data.VALUE[i - 1][k - 1] += WWIN;
						}

					}

					if (data.ARRAY[i][k] == 2) {
						if (i == 0 || k == 0) {
							data.VALUE[i + 4][k + 4] += BWIN;
						} else if (i == 11 || k == 11) {
							data.VALUE[i - 1][k - 1] += BWIN;
						} else {
							data.VALUE[i + 4][k + 4] += BWIN;
							data.VALUE[i - 1][k - 1] += BWIN;
						}

					}
				}
				// 判断左斜排是否有4个

				if (i > 2 && k < 12
						&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i - 1][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i - 2][k + 2]
						&& data.ARRAY[i - 3][k + 3] == data.ARRAY[i][k]) {
					if ((k == 10 && i == 14) || (k == 11 && i == 13)
							&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)) {
						data.VALUE[14][10] += WWIN;
						data.VALUE[10][14] += WWIN;
					}

					if ((i > 10 && k > 10) == false) {
						if (data.ARRAY[i][k] == 1) {
							if ((k == 0 || i == 14) && i >= 4) {
								data.VALUE[i - 4][k + 4] += WWIN;
							} else if (k == 11 || i == 3) {
								data.VALUE[i + 1][k - 1] += WWIN;
							}

							else {
								data.VALUE[i - 4][k + 4] += WWIN;
								data.VALUE[i + 1][k - 1] += WWIN;
							}
						}
					}

					if ((i > 10 && k > 10) == false) {
						if (data.ARRAY[i][k] == 2) {
							if (k == 0 || i == 14) {
								data.VALUE[i - 4][k + 4] += BWIN;
							} else if (k == 11 || i == 3) {
								data.VALUE[i + 1][k - 1] += BWIN;
							} else {
								data.VALUE[i - 4][k + 4] += BWIN;
								data.VALUE[i + 1][k - 1] += BWIN;
							}
						}

					}
				}

			}
	}

	// 判断是否3子了
	public void three() {
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {

				// 横排是否3个
				if (i < 13 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k] == data.ARRAY[i][k]
						&& data.ARRAY[i + 2][k] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						if (i == 0) {
							data.VALUE[i + 3][k] += NOTHREE;
						} else if (i == 12) {
							data.VALUE[i - 1][k] += NOTHREE;
						}
						// 判断是否是活3
						else if (data.ARRAY[i - 1][k] == 0
								&& data.ARRAY[i + 3][k] == 0) {
							data.VALUE[i + 3][k] += THREE;
							data.VALUE[i - 1][k] += THREE;
						} else {
							data.VALUE[i + 3][k] += NOTHREE;
							data.VALUE[i - 1][k] += NOTHREE;
						}

					}
					if (data.ARRAY[i][k] == 2) {
						if (i == 0) {
							data.VALUE[i + 3][k] += NOTHREE;
						} else if (i == 12) {
							data.VALUE[i - 1][k] += NOTHREE;
						}
						// 判断是否是活3
						else if (data.ARRAY[i - 1][k] == 0
								&& data.ARRAY[i + 3][k] == 0) {
							data.VALUE[i + 3][k] += BTHREE;
							data.VALUE[i - 1][k] += BTHREE;
						} else {
							data.VALUE[i + 3][k] += NOTHREE;
							data.VALUE[i - 1][k] += NOTHREE;
						}

					}
				}
				// 判断竖排是否有3个
				if (k < 13 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i][k + 2]) {
					if (data.ARRAY[i][k] == 1) {
						if (k == 0) {
							data.VALUE[i][k + 3] += NOTHREE;
						} else if (k == 12) {
							data.VALUE[i][k - 1] += NOTHREE;
						}
						// 判断是否是活3
						else if (data.ARRAY[i][k - 1] == 0
								&& data.ARRAY[i][k + 3] == 0) {
							data.VALUE[i][k + 3] += THREE;
							data.VALUE[i][k - 1] += THREE;
						} else {
							data.VALUE[i][k + 3] += NOTHREE;
							data.VALUE[i][k - 1] += NOTHREE;
						}
					}

					if (data.ARRAY[i][k] == 2) {
						if (k == 0) {
							data.VALUE[i][k + 3] += NOTHREE;
						} else if (k == 12) {
							data.VALUE[i][k - 1] += NOTHREE;
						}
						// 判断是否是活3
						else if (data.ARRAY[i][k - 1] == 0
								&& data.ARRAY[i][k + 3] == 0) {
							data.VALUE[i][k + 3] += BTHREE;
							data.VALUE[i][k - 1] += BTHREE;
						} else {
							data.VALUE[i][k + 3] += NOTHREE;
							data.VALUE[i][k - 1] += NOTHREE;
						}
					}

				}

				// 判断右斜排是否有3个
				if (i < 12 && k < 12
						&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i + 2][k + 2]) {
					if (data.ARRAY[i][k] == 1) {
						if (i == 0 || k == 0) {
							data.VALUE[i + 3][k + 3] += NOTHREE;
						} else if (i == 12 || k == 12) {
							data.VALUE[i - 1][k - 1] += NOTHREE;
						} else if (data.ARRAY[i - 1][k - 1] == 0
								&& data.ARRAY[i + 3][k + 3] == 0) {
							data.VALUE[i + 3][k + 3] += THREE;
							data.VALUE[i - 1][k - 1] += THREE;
						} else {
							data.VALUE[i + 3][k + 3] += NOTHREE;
							data.VALUE[i - 1][k - 1] += NOTHREE;
						}

					}

					if (data.ARRAY[i][k] == 2) {
						if (i == 0 || k == 0) {
							data.VALUE[i + 3][k + 3] += NOTHREE;
						} else if (i == 12 || k == 12) {
							data.VALUE[i - 1][k - 1] += NOTHREE;
						} else if (data.ARRAY[i - 1][k - 1] == 0
								&& data.ARRAY[i + 3][k + 3] == 0) {
							data.VALUE[i + 3][k + 3] += BTHREE;
							data.VALUE[i - 1][k - 1] += BTHREE;
						} else {
							data.VALUE[i + 3][k + 3] += NOTHREE;
							data.VALUE[i - 1][k - 1] += NOTHREE;
						}

					}
				}
				// 判断左斜排是否有3个

				if (i > 1 && k < 13
						&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i - 1][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i - 2][k + 2]) {

					if (data.ARRAY[i][k] == 1) {
						// 考虑左下角的点
						if ((i > 10 && k > 10) == false) {
							if (k == 0 && i < 4) {

							}

							else if (((k == 0 && i > 2) || (i == 14 && k < 12))) {
								data.VALUE[i - 3][k + 3] += NOTHREE;
							} else if ((i == 2 && k > 0) || (k == 12 && i < 14)) {
								data.VALUE[i + 1][k - 1] += NOTHREE;
							}

							else if ((data.ARRAY[i + 1][k - 1] == 0 && i > 2
									&& k > 0 && i < 14)
									&& (data.ARRAY[i - 3][k + 3] == 0 && i > 2
											&& k > 0 && i < 14)) {
								data.VALUE[i - 3][k + 3] += THREE;
								data.VALUE[i + 1][k - 1] += THREE;
							} else {
								data.VALUE[i - 3][k + 3] += NOTHREE;
								data.VALUE[i + 1][k - 1] += NOTHREE;
							}

						}
					}

					if (data.ARRAY[i][k] == 2) {
						// 考虑左下角的点
						if ((i > 10 && k > 10) == false) {
							if (k == 0 && i < 4) {

							}

							else if ((k == 0 || i == 14)) {
								data.VALUE[i - 3][k + 3] += NOTHREE;
							} else if ((i == 2 && k > 0) || (k == 12 && i < 14)) {
								data.VALUE[i + 1][k - 1] += NOTHREE;
							} else if ((data.ARRAY[i + 1][k - 1] == 0 && i > 2
									&& k > 0 && i < 14)
									&& (data.ARRAY[i - 3][k + 3] == 0 && i > 2
											&& k > 0 && i < 14)) {
								data.VALUE[i - 3][k + 3] += BTHREE;
								data.VALUE[i + 1][k - 1] += BTHREE;
							} else {
								data.VALUE[i - 3][k + 3] += NOTHREE;
								data.VALUE[i + 1][k - 1] += NOTHREE;
							}

						}
					}
				}
			}
	}

	// 判断是否两字
	public void two() {

		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {

				// 横排是否2个
				if (i < 13 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						if (i == 0) {
							data.VALUE[i + 2][k] += NOTWO;
						} else if (i == 13) {
							data.VALUE[i - 1][k] += NOTWO;
						}
						// 判断是否是活2
						else if (data.ARRAY[i - 1][k] == 0
								&& data.ARRAY[i + 2][k] == 0) {
							data.VALUE[i + 2][k] += TWO;
							data.VALUE[i - 1][k] += TWO;
						} else {
							data.VALUE[i + 2][k] += NOTWO;
							data.VALUE[i - 1][k] += NOTWO;
						}

					}

					if (data.ARRAY[i][k] == 2) {
						if (i == 0) {
							data.VALUE[i + 2][k] += NOTWO;
						} else if (i == 13) {
							data.VALUE[i - 1][k] += NOTWO;
						}
						// 判断是否是活2
						else if (data.ARRAY[i - 1][k] == 0
								&& data.ARRAY[i + 2][k] == 0) {
							data.VALUE[i + 2][k] += TWO;
							data.VALUE[i - 1][k] += TWO;
						} else {
							data.VALUE[i + 2][k] += NOTWO;
							data.VALUE[i - 1][k] += NOTWO;
						}

					}
				}
				// 判断竖排是否有3个
				if (k < 13 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i][k + 1] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						if (k == 0) {
							data.VALUE[i][k + 2] += NOTWO;
						} else if (k == 13) {
							data.VALUE[i][k - 1] += NOTWO;
						}
						// 判断是否是活3
						else if (data.ARRAY[i][k - 1] == 0
								&& data.ARRAY[i][k + 2] == 0) {
							data.VALUE[i][k + 2] += TWO;
							data.VALUE[i][k - 1] += TWO;
						} else {
							data.VALUE[i][k + 2] += NOTWO;
							data.VALUE[i][k - 1] += NOTWO;
						}
					}

					if (data.ARRAY[i][k] == 2) {
						if (k == 0) {
							data.VALUE[i][k + 2] += NOTWO;
						} else if (k == 13) {
							data.VALUE[i][k - 1] += NOTWO;
						}
						// 判断是否是活3
						else if (data.ARRAY[i][k - 1] == 0
								&& data.ARRAY[i][k + 2] == 0) {
							data.VALUE[i][k + 2] += TWO;
							data.VALUE[i][k - 1] += TWO;
						} else {
							data.VALUE[i][k + 2] += NOTWO;
							data.VALUE[i][k - 1] += NOTWO;
						}
					}

				}

				// 判断右斜排是否有TWO个
				if (i < 13 && k < 13
						&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k + 1] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						if (i == 0 || k == 0) {
							data.VALUE[i + 2][k + 2] += NOTWO;
						} else if (i == 13 || k == 13) {
							data.VALUE[i - 1][k - 1] += NOTWO;
						} else if (data.ARRAY[i - 1][k - 1] == 0
								&& data.ARRAY[i + 2][k + 2] == 0) {
							data.VALUE[i + 2][k + 2] += TWO;
							data.VALUE[i - 1][k - 1] += TWO;
						} else {
							data.VALUE[i + 2][k + 2] += NOTWO;
							data.VALUE[i - 1][k - 1] += NOTWO;
						}

					}

					if (data.ARRAY[i][k] == 2) {
						if (i == 0 || k == 0) {
							data.VALUE[i + 2][k + 2] += NOTWO;
						} else if (i == 13 || k == 13) {
							data.VALUE[i - 1][k - 1] += NOTWO;
						} else if (data.ARRAY[i - 1][k - 1] == 0
								&& data.ARRAY[i + 2][k + 2] == 0) {
							data.VALUE[i + 2][k + 2] += TWO;
							data.VALUE[i - 1][k - 1] += TWO;
						} else {
							data.VALUE[i + 2][k + 2] += NOTWO;
							data.VALUE[i - 1][k - 1] += NOTWO;
						}

					}
				}
				// 判断左斜排是否有2个

				if (i > 1 && k < 13
						&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i - 1][k + 1] == data.ARRAY[i][k]) {

					if (data.ARRAY[i][k] == 1) {
						if ((i > 10 && k > 10) == false) {
							if ((k == 1 && i > 0) || (i == 13 && k < 14)) {
								data.VALUE[i - 1][k + 1] += NOTWO;
							} else if ((i == 1 && k > 0) || (k == 13 && i < 14)) {
								data.VALUE[i + 1][k - 1] += NOTWO;
							} else if (i == 14) {
								data.VALUE[i - 2][k + 2] += NOTWO;
							} else if ((k == 0 && i > 1)) {
								data.VALUE[i - 2][k + 2] += NOTWO;
							} else if (data.ARRAY[i + 1][k - 1] == 0
									&& data.ARRAY[i - 2][k + 2] == 0) {
								data.VALUE[i - 2][k + 2] += TWO;
								data.VALUE[i + 1][k - 1] += TWO;
							} else {
								data.VALUE[i - 2][k + 2] += NOTWO;
								data.VALUE[i + 1][k - 1] += NOTWO;
							}

						}
					}

					if (data.ARRAY[i][k] == 2) {
						if ((i > 10 && k > 10) == false) {
							if ((k == 1 && i > 0) || (i == 13 && k < 14)) {
								data.VALUE[i - 1][k + 1] += NOTWO;
							} else if ((i == 1 && k > 0) || (k == 13 && i < 14)) {
								data.VALUE[i + 1][k - 1] += NOTWO;
							} else if (i == 14) {
								data.VALUE[i - 2][k + 2] += NOTWO;
							} else if (k == 0) {
								data.VALUE[i - 2][k + 2] += NOTWO;
							} else if (data.ARRAY[i + 1][k - 1] == 0
									&& data.ARRAY[i - 2][k + 2] == 0) {
								data.VALUE[i - 2][k + 2] += TWO;
								data.VALUE[i + 1][k - 1] += TWO;
							} else {
								data.VALUE[i - 2][k + 2] += NOTWO;
								data.VALUE[i + 1][k - 1] += NOTWO;
							}

						}
					}
				}
			}

	}

	// 判断是否为一子

	public void one() {
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {

				// 算中间的点
				if (data.ARRAY[i][k] == 1) {
					if (i > 0 && i < 14 && k > 0 && k < 14) {

						for (int w = -1; w < 1; w++)
							for (int q = -1; q < 2; q++) {
								if ((w == 0 && q == 1) == false) {

									if (data.ARRAY[i + q][k + w] == 2) {
										data.VALUE[i - q][k - w] += NOONE;
									} else {
										data.VALUE[i - q][k - w] += ONE;
										data.VALUE[i + q][k + w] += ONE;
									}
								}
							}
					}
				}

				// 算中间的点
				if (data.ARRAY[i][k] == 2) {
					if (i > 0 && i < 14 && k > 0 && k < 14) {

						for (int w = -1; w < 1; w++)
							for (int q = -1; q < 2; q++) {
								if ((w == 0 && q == 1) == false) {

									if (data.ARRAY[i + q][k + w] == 2) {
										data.VALUE[i - q][k - w] += NOONE;
									} else {
										data.VALUE[i - q][k - w] += ONE;
										data.VALUE[i + q][k + w] += ONE;
									}
								}
							}
					}
				}
			}
	}

	// 判断四字在一条直线的情况
	public void five() {
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {
				// 判断横排是否有5个
				if (i < 11 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k] == data.ARRAY[i][k]
						&& data.ARRAY[i + 2][k] == data.ARRAY[i][k]
						&& data.ARRAY[i + 3][k] == data.ARRAY[i][k]
						&& data.ARRAY[i + 4][k] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						data.VALUE[i + 1][k] += WWIN;
						data.VALUE[i + 2][k] += WWIN;
						data.VALUE[i + 3][k] += WWIN;
						data.VALUE[i + 4][k] += WWIN;
						data.VALUE[i][k] += WWIN;
					}

					if (data.ARRAY[i][k] == 2) {
						data.VALUE[i][k] += BWIN;
						data.VALUE[i + 1][k] += BWIN;
						data.VALUE[i + 2][k] += BWIN;
						data.VALUE[i + 3][k] += BWIN;
						data.VALUE[i + 4][k] += BWIN;
					}

				}
				// 判断竖排是否有5个
				if (k < 11 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i][k + 2]
						&& data.ARRAY[i][k + 3] == data.ARRAY[i][k]
						&& data.ARRAY[i][k + 4] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						data.VALUE[i][k] += WWIN;
						data.VALUE[i][k + 1] += WWIN;
						data.VALUE[i][k + 2] += WWIN;
						data.VALUE[i][k + 3] += WWIN;
						data.VALUE[i][k + 4] += WWIN;
					}

					if (data.ARRAY[i][k] == 2) {
						data.VALUE[i][k + 1] += BWIN;
						data.VALUE[i][k + 2] += BWIN;
						data.VALUE[i][k + 3] += BWIN;
						data.VALUE[i][k + 4] += BWIN;
						data.VALUE[i][k] += BWIN;
					}
				}

				// 判断右斜排是否有5个
				if (i < 11 && k < 11
						&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i + 2][k + 2]
						&& data.ARRAY[i + 3][k + 3] == data.ARRAY[i][k]
						&& data.ARRAY[i + 4][k + 4] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						data.VALUE[i + 2][k + 2] += WWIN;
						data.VALUE[i + 3][k + 3] += WWIN;
						data.VALUE[i + 4][k + 4] += WWIN;
						data.VALUE[i + 1][k + 1] += WWIN;
						data.VALUE[i][k] += WWIN;
					}

					if (data.ARRAY[i][k] == 2) {
						data.VALUE[i + 2][k + 2] += BWIN;
						data.VALUE[i + 3][k + 3] += BWIN;
						data.VALUE[i + 4][k + 4] += BWIN;
						data.VALUE[i + 1][k + 1] += BWIN;
						data.VALUE[i][k] += BWIN;
					}
				}
				// 判断左斜排是否有5个

				if (i > 3 && k < 11
						&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i - 1][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i - 2][k + 2]
						&& data.ARRAY[i - 3][k + 3] == data.ARRAY[i][k]
						&& data.ARRAY[i - 4][k + 4] == data.ARRAY[i][k]) {
					// System.out.println("*******************");
					if (data.ARRAY[i][k] == 1) {
						data.VALUE[i][k] += WWIN;
						data.VALUE[i - 1][k + 1] += WWIN;
						data.VALUE[i - 2][k + 2] += WWIN;
						data.VALUE[i - 3][k + 3] += WWIN;
						data.VALUE[i - 4][k + 4] += WWIN;
					}

					if (data.ARRAY[i][k] == 2) {
						data.VALUE[i][k] += BWIN;
						data.VALUE[i - 1][k + 1] += BWIN;
						data.VALUE[i - 2][k + 2] += BWIN;
						data.VALUE[i - 3][k + 3] += BWIN;
						data.VALUE[i - 4][k + 4] += BWIN;
					}
				}
			}
	}
}
