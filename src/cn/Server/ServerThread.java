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
		ss.writeInt(0);// 第几个玩家进入了游戏
		ss.writeInt(i);
		while (client.isConnected()) {
			switch (readInt()) {
			case 1:
				int x = this.readInt();
				int y = this.readInt();// 读入坐标
				int f = this.readInt();// 读入黑白棋
				ss.writeInt(1);// 下棋
				ss.writeInt(i);// 第几个玩家下的
				ss.writeInt(x);
				ss.writeInt(y);
				ss.writeInt(f);
				data.ARRAY[x][y] = f;
				judge.judge1();// 判断输赢
				break;// 玩家下子
			default:
//				System.out.println("收到错误信息");
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
			System.out.println("获取流失败了！");
		}
	}

	public int readInt() {
		try {
			return dis.readInt();
		} catch (Exception e) {
//			System.out.println("读取整型失败！");
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
