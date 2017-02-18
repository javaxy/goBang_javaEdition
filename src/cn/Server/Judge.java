package cn.Server;

import java.io.IOException;

public class Judge {

	private ServerThread st;

	public Judge(ServerThread st) {
		this.st = st;
	}

	// ÅĞ¶ÏÊäÓ®µÄ·½·¨
	public void judge1() {
		int j = 0;
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {

				// ÅĞ¶ÏºáÅÅÊÇ·ñÓĞ5¸ö
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
				// ÅĞ¶ÏÊúÅÅÊÇ·ñÓĞ5¸ö
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

				// ÅĞ¶ÏÓÒĞ±ÅÅÊÇ·ñÓĞ5¸ö
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
				// ÅĞ¶Ï×óĞ±ÅÅÊÇ·ñÓĞ5¸ö

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

		if (j == 8 || j == 9) {
			st.getSs().writeInt(2);
			st.getSs().writeInt((j == 9) ? 1 : 2);// j=9°×ÆåÊ¤Àû,j=8ºÚÆåÊ¤Àû
			st.getSs().writeInt(3);
			try {
				st.getClient().close();
			} catch (IOException e) {
				System.out.println("·şÎñÆ÷¹Ø±Õ´íÎó£¡");
			}
			try {
				st.getClient().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
