package cn.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

	private int i;
	private Socket client;
	private DataOutputStream dos;
	private DataInputStream dis;
	private ServerStart ss;

	public ServerThread(int i, Socket client, ServerStart ss) {
		this.i = i;
		this.client = client;
		this.ss = ss;
	}

	public void run() {
		getStream();
		Judge judge = new Judge(this);
		ss.writeInt(0);// �ڼ�����ҽ�������Ϸ
		ss.writeInt(i);
		while (client.isConnected()) {
			switch (readInt()) {
			case 1:
				int x = this.readInt();
				int y = this.readInt();// ��������
				int f = this.readInt();// ����ڰ���
				ss.writeInt(1);// ����
				ss.writeInt(i);// �ڼ�������µ�
				ss.writeInt(x);
				ss.writeInt(y);
				ss.writeInt(f);
				data.ARRAY[x][y] = f;
				judge.judge1();// �ж���Ӯ
				break;// �������
			default:
//				System.out.println("�յ�������Ϣ");
				break;
			}
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

	public int readInt() {
		try {
			return dis.readInt();
		} catch (Exception e) {
//			System.out.println("��ȡ����ʧ�ܣ�");
		}
		return -1;
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

	public ServerStart getSs() {
		return ss;
	}

	public Socket getClient() {
		return client;
	}

}
