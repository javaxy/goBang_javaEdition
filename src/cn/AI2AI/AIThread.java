package cn.AI2AI;

public class AIThread extends Thread {

	private chessBoard cb;

	public AIThread(chessBoard cb) {
		this.cb = cb;
	}

	public void run() {
		try {
			startBat();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startBat() throws Exception {
		fun f = new fun(cb);
		judge ju = new judge();
		while (ju.judge1()) {
			// 赋予每个点一个初值
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					data.VALUE[i][j] = 1000;
				}
			f.putdown();
			Thread.sleep(300);
		}
	}

}
