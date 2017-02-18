package cn.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * ����������
 */
public class ServerStart {

	private static int port = 9999;
	private ArrayList<ServerThread> list;
	private boolean flag = true;

	public static void main(String[] args) {
		new ServerStart(port);
	}

	public ServerStart(int port) {
		list = new ArrayList<ServerThread>();
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("�����������ɹ����ȴ���ҽ��롭��");
			int i = 1;
			while (flag) {
				Socket client = server.accept();
				ServerThread st = new ServerThread(i, client, this);
				list.add(st);
				st.start();
				i++;
			}
			server.close();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("����������ʧ���ˣ�");
		}
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void writeInt(int k) {
		try {
			for (int i = 0; i < list.size(); i++) {
				ServerThread st = list.get(i);
				st.getDos().writeInt(k);
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("д����ʧ���ˣ�");
		}
	}
}
