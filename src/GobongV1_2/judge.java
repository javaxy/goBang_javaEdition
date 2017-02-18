package GobongV1_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class judge {

	private Graphics g;

	public judge(Graphics g) {
		this.g = g;
	}

	// 判断输赢的方法
	public void judge1() {
		int j = 0, l = 0;
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {
				// System.out.println(i+"   "+k);
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

		// System.out.println(j);

		ImageIcon im = new ImageIcon("images/2.png");
		Image i = im.getImage();
		if (j == 9)
			g.drawImage(i, 0, 0, null);

		ImageIcon im1 = new ImageIcon("images/1.png");
		Image i1 = im1.getImage();
		if (j == 8)

			g.drawImage(i1, 0, 0, null);
	}

}
