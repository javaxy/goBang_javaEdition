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

	// 下棋
	public void mouseClicked(MouseEvent e) {
		// 判断是否可以下棋,人机
		if (GobongV1_3.chessBoard.state && data.MODOL[0]==1) {

			// 实例化计算函数对象
			fun f = new fun();

			// 赋予每个点一个初值
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					data.VALUE[i][j] = 1000;
				}

			// 获得当前位置，并下白棋
			int a = e.getX();
			int b = e.getY();
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					if (a < (35 + i * data.SIZE) && a > (5 + i * data.SIZE)
							&& b > (5 + j * data.SIZE)
							&& b < (35 + j * data.SIZE)) {

						if (data.ARRAY[i][j] == 0) {
							data.ARRAY[i][j] = 1;
							// 记录此时下的位置
							data.BOARDSTEP[i][j] = getchessNO();
							chessBoard.appendText("白：横 " + (i + 1) + " 竖 "
									+ (j + 1) + " 步数 " + data.BOARDSTEP[i][j]);
							chessBoard.repaint();
							// 判断白棋是否获胜
							judge j1 = new judge();
							j1.judge1();
							if (chessBoard.cm.pipeiqipan()) {
								chessBoard.appendText("匹配成功，哈哈哈！");
								j1.judge1();
								return;
							}

							// 若白棋未获胜
							if (GobongV1_3.chessBoard.state) {
								// 赋值
								f.value();

								// 查找,并下棋子
								search();
								// 判断黑棋是否获胜

								j1.judge1();
							}
						}

					}
				}
		}
		
		
		// 判断是否可以下棋,人人
		if (GobongV1_3.chessBoard.state && data.MODOL[0]==2) {
			if(getchessNO()%2==0){
			// 获得当前位置，并下白棋
			int a = e.getX();
			int b = e.getY();
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					if (a < (35 + i * data.SIZE) && a > (5 + i * data.SIZE)
							&& b > (5 + j * data.SIZE)
							&& b < (35 + j * data.SIZE)) {

						if (data.ARRAY[i][j] == 0) {
							data.ARRAY[i][j] = 1;
							// 记录此时下的位置
							data.BOARDSTEP[i][j] = getchessNO();
							chessBoard.appendText("白：横 " + (i + 1) + " 竖 "
									+ (j + 1) + " 步数 " + data.BOARDSTEP[i][j]);
							chessBoard.repaint();
							// 判断白棋是否获胜
							judge j1 = new judge();
							j1.judge1();
						}
					}
				}
			}
			if(getchessNO()%2==1){
				
				// 获得当前位置，并下黑棋
				int a = e.getX();
				int b = e.getY();
				for (int i = 0; i < 15; i++)
					for (int j = 0; j < 15; j++) {
						if (a < (35 + i * data.SIZE) && a > (5 + i * data.SIZE)
								&& b > (5 + j * data.SIZE)
								&& b < (35 + j * data.SIZE)) {

							if (data.ARRAY[i][j] == 0) {
								data.ARRAY[i][j] = 2;
								// 记录此时下的位置
								data.BOARDSTEP[i][j] = getchessNO();
								chessBoard.appendText("黑：横 " + (i + 1) + " 竖 "
										+ (j + 1) + " 步数 " + data.BOARDSTEP[i][j]);
								chessBoard.repaint();
								// 判断黑棋是否获胜
								judge j1 = new judge();
								j1.judge1();
							}
						}
					}
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
				if (q == data.VALUE[i][j]) {
					data.ARRAY[i][j] = 2;
					// 记录此时下的位置
					data.BOARDSTEP[i][j] = getchessNO();
					chessBoard.appendText("黑：横 " + (i + 1) + " 竖 " + (j + 1)
							+ " 步数 " + data.BOARDSTEP[i][j]);
				}
			}
	}

}
