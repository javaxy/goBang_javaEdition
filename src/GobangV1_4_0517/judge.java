package GobangV1_4_0517;

import javax.swing.JOptionPane;

public class judge {

	// 判断输赢的方法
	public boolean judge1() {
		int j = 0;
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {

				// 判断横排是否有5个
				if (i < 11 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k] == data.ARRAY[i][k]
						&& data.ARRAY[i + 2][k] == data.ARRAY[i][k]
						&& data.ARRAY[i + 3][k] == data.ARRAY[i][k]
						&& data.ARRAY[i + 4][k] == data.ARRAY[i][k]) {
					// System.out.println("*******************");
					if (data.ARRAY[i][k] == 1)
						j = 9;
					if (data.ARRAY[i][k] == 2)
						j = 8;
				}
				// 判断竖排是否有5个
				if (k < 11 && (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i][k + 2]
						&& data.ARRAY[i][k + 3] == data.ARRAY[i][k]
						&& data.ARRAY[i][k + 4] == data.ARRAY[i][k]) {
					// System.out.println("*******************");
					if (data.ARRAY[i][k] == 1)
						j = 9;
					if (data.ARRAY[i][k] == 2)
						j = 8;
				}

				// 判断右斜排是否有5个
				if (i < 11 && k < 11
						&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i + 1][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i + 2][k + 2]
						&& data.ARRAY[i + 3][k + 3] == data.ARRAY[i][k]
						&& data.ARRAY[i + 4][k + 4] == data.ARRAY[i][k]) {
					if (data.ARRAY[i][k] == 1)
						j = 9;
					if (data.ARRAY[i][k] == 2)
						j = 8;
				}
				// 判断左斜排是否有5个

				if (i > 3 && k < 11
						&& (data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
						&& data.ARRAY[i - 1][k + 1] == data.ARRAY[i][k]
						&& data.ARRAY[i][k] == data.ARRAY[i - 2][k + 2]
						&& data.ARRAY[i - 3][k + 3] == data.ARRAY[i][k]
						&& data.ARRAY[i - 4][k + 4] == data.ARRAY[i][k]) {
					// System.out.println("*******************");
					if (data.ARRAY[i][k] == 1)
						j = 9;
					if (data.ARRAY[i][k] == 2)
						j = 8;
				}
			}

		// 显示图片
		if (j == 9) {
			JOptionPane.showMessageDialog(null, "black win！", "Game Over", 1);// 白棋胜利
			return false;
			// FileOperation.addBoard(new Board(data.BOARDSTEP));
		}
		if (j == 8) {
			JOptionPane.showMessageDialog(null, "white win！", "Game Over", 1);// 黑棋胜利
			return false;
			// FileOperation.addBoard(new Board(data.BOARDSTEP));
		}
		return true;

	}

}
