package GobongV1_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;

public class gobangAI0 extends MouseAdapter {

	private Graphics g;
	private boolean k = true;
	Random r = new Random(2);

	public gobangAI0(Graphics g) {
		this.g = g;
	}

	public void mouseClicked(MouseEvent e) {
		int a = e.getX();
		int b = e.getY();

		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (a < (35 + i * data.SIZE) && a > (5 + i * data.SIZE)
						&& b > (5 + j * data.SIZE) && b < (35 + j * data.SIZE)) {

					// ÅÐ¶ÏÎ»ÖÃÊÇ·ñÎª¿Õ£¬ÊÇ·ñÊÇºÚÆå»ò°×Æå
					if (k && data.ARRAY[i][j] == 0) {
						g.setColor(Color.white);
						g.fillOval(5 + i * data.SIZE, 5 + j * data.SIZE, 30, 30);

						data.ARRAY[i][j] = 1;
						int w = r.nextInt(3) - 1;
						int c = r.nextInt(3) - 1;
						int w1 = r.nextInt(5) - 2;
						int c1 = r.nextInt(5) - 2;
						int w2 = r.nextInt(7) - 3;
						int c2 = r.nextInt(7) - 3;

						if (data.ARRAY[i + c][j + w] == 0) {
							g.setColor(Color.black);
							g.fillOval(5 + (i + c) * data.SIZE, 5 + (j + w)
									* data.SIZE, 30, 30);

							data.ARRAY[i + c][j + w] = 2;
						} else if (data.ARRAY[i + c1][j + w1] == 0) {
							g.setColor(Color.black);
							g.fillOval(5 + (i + c1) * data.SIZE, 5 + (j + w1)
									* data.SIZE, 30, 30);

							data.ARRAY[i + c1][j + w1] = 2;
						} else if (data.ARRAY[i + c2][j + w2] == 0) {
							g.setColor(Color.black);
							g.fillOval(5 + (i + c2) * data.SIZE, 5 + (j + w2)
									* data.SIZE, 30, 30);

							data.ARRAY[i + c2][j + w2] = 2;
						}

						// ÏÔÊ¾Í¼Æ¬
						judge j1 = new judge(g);
						j1.judge1();
					}

				}
			}

	}

}
