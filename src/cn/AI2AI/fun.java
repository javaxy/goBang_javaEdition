package cn.AI2AI;

import java.util.Random;

/**
 * �����帳ֵ�㷨
 * 
 * @author Administrator ����һ��BUG���Ǻ��������������ĵط���G
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

	// Ѱ��Ȩֵ���ĵ� ����������
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

		// ȡ����µĵ�
		int q = ra.nextInt(k);
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (q == data.VALUE[i][j] && data.ARRAY[i][j] == 0) {
					// ��¼��ʱ�µ�λ��
					data.BOARDSTEP[i][j] = getchessNO();
					if (getchessNO() % 2 == 1) {
						data.ARRAY[i][j] = 2;
						chessBoard
								.appendText("�ף��� " + (i + 1) + " �� " + (j + 1)
										+ " ���� " + (data.BOARDSTEP[i][j] + 1));
					} else {
						data.ARRAY[i][j] = 1;
						chessBoard
								.appendText("�ڣ��� " + (i + 1) + " �� " + (j + 1)
										+ " ���� " + (data.BOARDSTEP[i][j] + 1));
					}
					chessBoard.repaint();
				}
			}
	}

	// ��������ϵĲ����ĸ���������ֵΪ�����������ӵĸ���
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

	// �ж��Ƿ�������
	public void in() {
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (data.ARRAY[i][j] != 0) {
					data.VALUE[i][j] = -1;
				}
			}
	}

	// �ж��Ƿ�������
	public void four() {
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {

				// �����Ƿ�4��
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

				// �ж������Ƿ���4��
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

				// �ж���б���Ƿ���4��
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
				// �ж���б���Ƿ���4��

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

	// �ж��Ƿ�3����
	public void three() {
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {

				// �����Ƿ�3��
				if (i < 13 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k] == data.ARRAY[i][k]
						&& data.ARRAY[i + 2][k] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						if (i == 0) {
							data.VALUE[i + 3][k] += NOTHREE;
						} else if (i == 12) {
							data.VALUE[i - 1][k] += NOTHREE;
						}
						// �ж��Ƿ��ǻ�3
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
						// �ж��Ƿ��ǻ�3
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
				// �ж������Ƿ���3��
				if (k < 13 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i][k + 2]) {
					if (data.ARRAY[i][k] == 1) {
						if (k == 0) {
							data.VALUE[i][k + 3] += NOTHREE;
						} else if (k == 12) {
							data.VALUE[i][k - 1] += NOTHREE;
						}
						// �ж��Ƿ��ǻ�3
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
						// �ж��Ƿ��ǻ�3
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

				// �ж���б���Ƿ���3��
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
				// �ж���б���Ƿ���3��

				if (i > 1 && k < 13
						&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i - 1][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i - 2][k + 2]) {

					if (data.ARRAY[i][k] == 1) {
						// �������½ǵĵ�
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
						// �������½ǵĵ�
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

	// �ж��Ƿ�����
	public void two() {

		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {

				// �����Ƿ�2��
				if (i < 13 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						if (i == 0) {
							data.VALUE[i + 2][k] += NOTWO;
						} else if (i == 13) {
							data.VALUE[i - 1][k] += NOTWO;
						}
						// �ж��Ƿ��ǻ�2
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
						// �ж��Ƿ��ǻ�2
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
				// �ж������Ƿ���3��
				if (k < 13 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i][k + 1] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1) {
						if (k == 0) {
							data.VALUE[i][k + 2] += NOTWO;
						} else if (k == 13) {
							data.VALUE[i][k - 1] += NOTWO;
						}
						// �ж��Ƿ��ǻ�3
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
						// �ж��Ƿ��ǻ�3
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

				// �ж���б���Ƿ���TWO��
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
				// �ж���б���Ƿ���2��

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

	// �ж��Ƿ�Ϊһ��

	public void one() {
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {

				// ���м�ĵ�
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

				// ���м�ĵ�
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

	// �ж�������һ��ֱ�ߵ����
	public void five() {
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {
				// �жϺ����Ƿ���5��
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
				// �ж������Ƿ���5��
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

				// �ж���б���Ƿ���5��
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
				// �ж���б���Ƿ���5��

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
