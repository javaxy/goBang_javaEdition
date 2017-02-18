package cn.Client;

import java.net.Socket;

public class ClientStart {

	private String ip = "localhost";
	private int port = 9999;
	private Socket client;
	public ClientThread ct;
	private chessBoard cb;

	public ClientStart(chessBoard cb) {
		this.cb = cb;
	}

	public void con2Server() {
		try {
			client = new Socket(ip, port);
			ct = new ClientThread(client, cb);
			ct.start();
		} catch (Exception e) {
			System.out.println("û���Ϸ�����");
		}
	}

	public Socket getClient() {
		return client;
	}

	public ClientThread getCt() {
		return ct;
	}

}
