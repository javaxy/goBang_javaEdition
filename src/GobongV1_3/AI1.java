package GobongV1_3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class AI1 extends MouseAdapter {

	Random ra = new Random();
	private chessBoard chessBoard;

	public AI1(chessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}

	// ����
	public void mouseClicked(MouseEvent e) {
		// �ж��Ƿ��������,�˻�
		if (GobongV1_3.chessBoard.state && data.MODOL[0]==1) {

			// ʵ�������㺯������
			fun f = new fun();

			// ����ÿ����һ����ֵ
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					data.VALUE[i][j] = 1000;
				}

			// ��õ�ǰλ�ã����°���
			int a = e.getX();
			int b = e.getY();
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					if (a < (35 + i * data.SIZE) && a > (5 + i * data.SIZE)
							&& b > (5 + j * data.SIZE)
							&& b < (35 + j * data.SIZE)) {

						if (data.ARRAY[i][j] == 0) {
							data.ARRAY[i][j] = 1;
							// ��¼��ʱ�µ�λ��
							data.BOARDSTEP[i][j] = getchessNO();
							chessBoard.appendText("�ף��� " + (i + 1) + " �� "
									+ (j + 1) + " ���� " + data.BOARDSTEP[i][j]);
							chessBoard.repaint();
							// �жϰ����Ƿ��ʤ
							judge j1 = new judge();
							j1.judge1();
							if (chessBoard.cm.pipeiqipan()) {
								chessBoard.appendText("ƥ��ɹ�����������");
								j1.judge1();
								return;
							}

							// ������δ��ʤ
							if (GobongV1_3.chessBoard.state) {
								// ��ֵ
								f.value();

								// ����,��������
								search();
								// �жϺ����Ƿ��ʤ

								j1.judge1();
							}
						}

					}
				}
		}
		
		
		// �ж��Ƿ��������,����
		if (GobongV1_3.chessBoard.state && data.MODOL[0]==2) {
			if(getchessNO()%2==0){
			// ��õ�ǰλ�ã����°���
			int a = e.getX();
			int b = e.getY();
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					if (a < (35 + i * data.SIZE) && a > (5 + i * data.SIZE)
							&& b > (5 + j * data.SIZE)
							&& b < (35 + j * data.SIZE)) {

						if (data.ARRAY[i][j] == 0) {
							data.ARRAY[i][j] = 1;
							// ��¼��ʱ�µ�λ��
							data.BOARDSTEP[i][j] = getchessNO();
							chessBoard.appendText("�ף��� " + (i + 1) + " �� "
									+ (j + 1) + " ���� " + data.BOARDSTEP[i][j]);
							chessBoard.repaint();
							// �жϰ����Ƿ��ʤ
							judge j1 = new judge();
							j1.judge1();
						}
					}
				}
			}
			if(getchessNO()%2==1){
				
				// ��õ�ǰλ�ã����º���
				int a = e.getX();
				int b = e.getY();
				for (int i = 0; i < 15; i++)
					for (int j = 0; j < 15; j++) {
						if (a < (35 + i * data.SIZE) && a > (5 + i * data.SIZE)
								&& b > (5 + j * data.SIZE)
								&& b < (35 + j * data.SIZE)) {

							if (data.ARRAY[i][j] == 0) {
								data.ARRAY[i][j] = 2;
								// ��¼��ʱ�µ�λ��
								data.BOARDSTEP[i][j] = getchessNO();
								chessBoard.appendText("�ڣ��� " + (i + 1) + " �� "
										+ (j + 1) + " ���� " + data.BOARDSTEP[i][j]);
								chessBoard.repaint();
								// �жϺ����Ƿ��ʤ
								judge j1 = new judge();
								j1.judge1();
							}
						}
					}
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
				if (q == data.VALUE[i][j]) {
					data.ARRAY[i][j] = 2;
					// ��¼��ʱ�µ�λ��
					data.BOARDSTEP[i][j] = getchessNO();
					chessBoard.appendText("�ڣ��� " + (i + 1) + " �� " + (j + 1)
							+ " ���� " + data.BOARDSTEP[i][j]);
				}
			}
	}

}
