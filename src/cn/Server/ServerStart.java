package cn.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 开启服务器
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
			System.out.println("服务器开启成功，等待玩家进入……");
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
			System.out.println("服务器创建失败了！");
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
			System.out.println("写整型失败了！");
		}
	}
}
