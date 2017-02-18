package GobongV1_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class AI1 extends MouseAdapter {
	int K;
	int bx;
	int by;
	int wx;
	int wy;
	StepList st = new StepList();

	Random ra = new Random();
	private Graphics g;

	public AI1(Graphics g) {
		this.g = g;
	}

	// // �����µ�һ��
	// public void mousePressed(MouseEvent e) {
	//
	// }

	// ����
	public void mouseClicked(MouseEvent e) {
		ChessManual ch = new ChessManual();

		// ����Ȩֵ��
		K = 0;
		// �����������ж��ٸ�����
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (data.ARRAY[i][j] != 0)
					K++;
			}

		// System.out.println(K);
		fun f = new fun();
		prediction pr = new prediction();

		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				data.VALUE[i][j] = 1000;
			}
		int a = e.getX();
		int b = e.getY();
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (a < (35 + i * data.SIZE) && a > (5 + i * data.SIZE)
						&& b > (5 + j * data.SIZE) && b < (35 + j * data.SIZE)) {

					if (data.ARRAY[i][j] == 0) {

						g.setColor(Color.white);
						g.fillOval(5 + i * data.SIZE, 5 + j * data.SIZE, 30, 30);
						data.ARRAY[i][j] = 1;
						chessBoard.step++;
						data.BOARDSTEP[i][j] = chessBoard.step;

						wx = i;
						wy = j;

						// ��ֵ

						f.value();

						// Ԥ���Ƿ���˫��
						if (K > 8) {
							pr.pre(1);
						}

						if (K <= 8 && ch.pipeiqipan()) {
							for (int i1 = 0; i1 < 15; i1++)
								for (int j1 = 0; j1 < 15; j1++) {
									if (data.ARRAY[i1][j1] == 2) {
										g.setColor(Color.black);
										g.fillOval(5 + i1 * data.SIZE, 5 + j1
												* data.SIZE, 30, 30);
										bx = i1;
										by = j1;
									}
								}
						}

						else {
							// ����,��������
							search();
						}
						// ��¼��һ�����˺͵����µ�����
						EveryStep ev = new EveryStep(bx, by, wx, wy);
						// ���뵽����
						st.add(ev);
					}

					// ��ʾͼƬ
					judge j1 = new judge(g);
					j1.judge1();
				}
			}

	}

	public StepList getSt() {
		return st;
	}

	public void setSt(StepList st) {
		this.st = st;
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
					// System.out.println(data.VALUE[i][j]);
				}
			}

		// ȡ����µĵ�
		int q = ra.nextInt(k);

		if (K > 14) {
			// System.out.println("hi");
			g.setColor(Color.black);
			// System.out.println(data.FINAL[0] + "          " + data.FINAL[1]);
			g.fillOval(5 + data.FINAL[0] * data.SIZE, 5 + data.FINAL[1]
					* data.SIZE, 30, 30);
			data.ARRAY[data.FINAL[0]][data.FINAL[1]] = 2;

			chessBoard.step++;
			data.BOARDSTEP[data.FINAL[0]][data.FINAL[1]] = chessBoard.step;

			bx = data.FINAL[0];
			by = data.FINAL[1];
		}

		else {

			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					if (q == data.VALUE[i][j]) {
						g.setColor(Color.black);
						g.fillOval(5 + i * data.SIZE, 5 + j * data.SIZE, 30, 30);
						chessBoard.step++;
						data.BOARDSTEP[i][j] = chessBoard.step;
						data.ARRAY[i][j] = 2;
						// System.out.println(chessBoard.step);
						for (int i1 = 0; i1 < 15; i1++) {
							// System.out.println();
							for (int j1 = 0; j1 < 15; j1++) {
								// System.out.print(data.BOARDSTEP[i1][j1]+"   ");
							}
						}
						bx = i;
						by = j;
					}
				}

		}
	}

}
