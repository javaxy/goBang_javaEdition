package GobongV1_3;

import java.util.ArrayList;

public class ChessManual {

	private int N = 15;
	private ArrayList<int[][]> chessmanual = new ArrayList<int[][]>();

	private chessBoard chessboard;

	public ChessManual(chessBoard chessboard) {
		this.chessboard = chessboard;
	}

	// �����������Ƿ�ɹ�
	public boolean pipeiqipan() {
		// �õ�����
		for (int k = 0; k < chessmanual.size(); k++) {
			int count = 0;// ������
			// ƥ������
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					if (getchessNO() % 2 == 1// ������
							&& getCount(chessmanual.get(k)) % 2 == 0 // ���ַ�Ӯ
							|| getchessNO() % 2 == 0// ��������
							&& getCount(chessmanual.get(k)) % 2 == 1// ���ַ�Ӯ
					)
						if (data.BOARDSTEP[i][j] != 0
								&& chessmanual.get(k)[i][j] != 0) {
							if (chessmanual.get(k)[i][j] == data.BOARDSTEP[i][j]) {
								count++;

							}
						}
				}
			// ����������㣬�Ͱ�������
			int step = getchessNO();
			if (count == step) {
				for (int i = 0; i < 15; i++)
					for (int j = 0; j < 15; j++) {
						if (chessmanual.get(k)[i][j] == (count + 1)) {
							step++;
							data.ARRAY[i][j] = 2;
							data.BOARDSTEP[i][j] = step;
							chessboard.appendText("�ڣ��� " + (i+1) + " �� " + (j+1)
									+ " ���� " + data.BOARDSTEP[i][j]);
						}
					}
				return true;
			}
		}
		return false;
	}

	public int getCount(int board[][]) {
		int count = 0;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (board[i][j] != 0) {
					count++;
				}
			}
		}
		return count;
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

	// ��ȡ�ļ��е����飬������ӵ�chessmanual�н���ƥ��
	public void toArray() {
		ArrayList<Board> step = FileOperation.readFile();
		if (step == null)
			return;
		for (int i = 0; i < step.size(); i++) {
			Board b = step.get(i);
			int array[][] = b.getBoard();
			chessmanual.add(array);
			array = mirsym(array);
			chessmanual.add(array);
			array = horsym(array);
			chessmanual.add(array);
			array = mirsym(array);
			chessmanual.add(array);
			array = versym(array);
			chessmanual.add(array);
			array = mirsym(array);
			chessmanual.add(array);
			array = horsym(array);
			chessmanual.add(array);
			array = mirsym(array);
			chessmanual.add(array);
		}
	}

	// ˮƽ�Գ�
	public int[][] horsym(int[][] array) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = array[N - 1 - i][j];
			}
		}
		return temp;
	}

	// ��ֱ�Գ�
	public int[][] versym(int[][] array) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = array[i][N - 1 - j];
			}
		}
		return temp;
	}

	// ����Գ�
	public int[][] mirsym(int[][] array) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[j][i] = array[i][j];
			}
		}
		return temp;
	}
}
