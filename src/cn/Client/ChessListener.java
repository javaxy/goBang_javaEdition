package cn.Client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessListener extends MouseAdapter {

	ClientStart cs;

	public ChessListener(ClientStart cs) {
		this.cs = cs;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ClientThread ct = cs.getCt();
		if (ct.getI() > 2) {
			return;
		}
		int a = e.getX();
		int b = e.getY();
		for (int i = 0; i < data.COL; i++) {
			for (int j = 0; j < data.ROW; j++) {
				if (a < (35 + i * data.SIZE) && a > (5 + i * data.SIZE)
						&& b > (5 + j * data.SIZE) && b < (35 + j * data.SIZE)) {
					if (data.ARRAY[i][j] == 0 && candown()) {
						ct.writeInt(1);
						ct.writeInt(i);
						ct.writeInt(j);
						ct.writeInt(ct.getI());
					}
				}
			}
		}
	}

	/**
	 * �ж��Ƿ��������
	 */
	private boolean candown() {
		ClientThread ct = cs.getCt();
		int count[] = new int[3];
		for (int i = 0; i < data.COL; i++) {
			for (int j = 0; j < data.ROW; j++) {
				if (data.ARRAY[i][j] != 0) {
					count[data.ARRAY[i][j]]++;
				}
			}
		}
		if (ct.getI() == 1 && count[1] == count[2]) {// �Լ�ִ����
			return true;
		}
		if (ct.getI() == 2 && count[1] == count[2] + 1) {// �Լ�ִ����
			return true;
		}
		return false;
	}
}
