package cn.Server;

import java.io.IOException;

public class Judge {

	private ServerThread st;

	public Judge(ServerThread st) {
		this.st = st;
	}

	// �ж���Ӯ�ķ���
	public void judge1() {
		int j = 0;
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {

				// �жϺ����Ƿ���5��
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
				// �ж������Ƿ���5��
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

				// �ж���б���Ƿ���5��
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
				// �ж���б���Ƿ���5��

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
			st.getSs().writeInt((j == 9) ? 1 : 2);// j=9����ʤ��,j=8����ʤ��
			st.getSs().writeInt(3);
			try {
				st.getClient().close();
			} catch (IOException e) {
				System.out.println("�������رմ���");
			}
			try {
				st.getClient().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
