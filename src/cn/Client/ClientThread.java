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
		cb.appendText("您进入游戏");
		while (client.isConnected()) {
			int k = readInt();
			switch (k) {
			case 0:
				int kt = readInt();
				cb.appendText("第" + kt + "个玩家进入游戏");
				break;
			case 1:
				int ti = readInt();
				int x = readInt();
				int y = readInt();
				int f = readInt();
				data.ARRAY[x][y] = f;
				String st = (f == 1) ? "黑棋" : "白棋";
				cb.appendText("第" + ti + "个玩家在(" + x + "," + y + ")" + "下了"
						+ st);
				cb.repaint();
				break;
			case 2:
				String whi = (readInt() == 1) ? "黑" : "白";
				cb.appendText(whi + "棋获胜！");
				JOptionPane.showMessageDialog(cb, whi + "棋获胜！");
				break;
			case 3:
				cb.appendText("已于服务器断开连接，欢迎下次再连~");
				try {
					client.close();
				} catch (IOException e) {
					System.out.println("断开连接");
				}
				return;
			}
		}
	}

	public int readInt() {
		try {
			return dis.readInt();
		} catch (Exception e) {
			System.out.println("读取整型失败");
		}
		return -1;
	}

	public void writeInt(int k) {
		try {
			dos.writeInt(k);
		} catch (Exception e) {
			System.out.println("写入整型失败");
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
