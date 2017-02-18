package cn.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientThread extends Thread {

	private Socket client;
	private DataInputStream dis;
	private DataOutputStream dos;
	private int i = 0;
	private chessBoard cb = null;

	public ClientThread(Socket client, chessBoard cb) {
		this.client = client;
		this.cb = cb;
	}

	public void run() {
		getStream();
		readInt();
		i = readInt();
		cb.appendText("��������Ϸ");
		while (client.isConnected()) {
			int k = readInt();
			switch (k) {
			case 0:
				int kt = readInt();
				cb.appendText("��" + kt + "����ҽ�����Ϸ");
				break;
			case 1:
				int ti = readInt();
				int x = readInt();
				int y = readInt();
				int f = readInt();
				data.ARRAY[x][y] = f;
				String st = (f == 1) ? "����" : "����";
				cb.appendText("��" + ti + "�������(" + x + "," + y + ")" + "����"
						+ st);
				cb.repaint();
				break;
			case 2:
				String whi = (readInt() == 1) ? "��" : "��";
				cb.appendText(whi + "���ʤ��");
				JOptionPane.showMessageDialog(cb, whi + "���ʤ��");
				break;
			case 3:
				cb.appendText("���ڷ������Ͽ����ӣ���ӭ�´�����~");
				try {
					client.close();
				} catch (IOException e) {
					System.out.println("�Ͽ�����");
				}
				return;
			}
		}
	}

	public int readInt() {
		try {
			return dis.readInt();
		} catch (Exception e) {
			System.out.println("��ȡ����ʧ��");
		}
		return -1;
	}

	public void writeInt(int k) {
		try {
			dos.writeInt(k);
		} catch (Exception e) {
			System.out.println("д������ʧ��");
		}
	}

	public void getStream() {
		try {
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("��ȡ��ʧ���ˣ�");
		}
	}

	public DataOutputStream getDos() {
		return dos;
	}

	public DataInputStream getDis() {
		return dis;
	}

	public int getI() {
		return i;
	}

}
