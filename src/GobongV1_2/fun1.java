package GobongV1_2;

public class fun1 {

	int WWIN = 1200;
	int BWIN = 1500;
	int WINB = 3300;
	int WINW = 3000;
	int TWO = 200;

	// 加入线程
	// public void run(){
	// five();
	// eight();
	// twotwo();
	// }
	// 判断四字在一条直线的情况,中间是否是否空了一个
	public void five() {

		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {
				// 判断横排是否有5个
				if (i < 11) {
					if (judge2(i, k) || judge1(i, k) || judge3(i, k)) {

						if (data.ARRAY[i][k] == 1) {
							// System.out.println("hi");
							data.VALUE[i + 1][k] += WINW;
							data.VALUE[i + 2][k] += WINW;
							data.VALUE[i + 3][k] += WINW;
							// data.VALUE[i + 4][k] += WIN;
							data.VALUE[i][k] += WINW;
						}

						if (data.ARRAY[i][k] == 2) {
							data.VALUE[i][k] += WINB;
							data.VALUE[i + 1][k] += WINB;
							data.VALUE[i + 2][k] += WINB;
							data.VALUE[i + 3][k] += WINB;
							// data.VALUE[i + 4][k] += WIN;
						}

					}
				}
				// 判断竖排是否有5个
				if (k < 11) {
					if (judge4(i, k) || judge5(i, k) || judge6(i, k))

					{
						if (data.ARRAY[i][k] == 1) {
							data.VALUE[i][k] += WINW;
							data.VALUE[i][k + 1] += WINW;
							data.VALUE[i][k + 2] += WINW;
							data.VALUE[i][k + 3] += WINW;
							// data.VALUE[i][k + 4] += WIN;
						}

						if (data.ARRAY[i][k] == 2) {
							data.VALUE[i][k + 1] += WINB;
							data.VALUE[i][k + 2] += WINB;
							data.VALUE[i][k + 3] += WINB;
							// data.VALUE[i][k + 4] += WIN;
							data.VALUE[i][k] += WINB;
						}
					}
				}

				// 判断右斜排是否有5个
				if (i < 11 && k < 11) {
					if (judge7(i, k) || judge8(i, k) || judge9(i, k)) {
						if (data.ARRAY[i][k] == 1) {
							data.VALUE[i + 2][k + 2] += WINW;
							data.VALUE[i + 3][k + 3] += WINW;
							// data.VALUE[i + 4][k + 4] += WIN;
							data.VALUE[i + 1][k + 1] += WINW;
							data.VALUE[i][k] += WINW;
						}

						if (data.ARRAY[i][k] == 2) {
							data.VALUE[i + 2][k + 2] += WINB;
							data.VALUE[i + 3][k + 3] += WINB;
							// data.VALUE[i + 4][k + 4] += WIN;
							data.VALUE[i + 1][k + 1] += WINB;
							data.VALUE[i][k] += WINB;
						}
					}
				}
				// 判断左斜排是否有5个

				if (i > 3 && k < 11) {
					{
						if (judge10(i, k) || judge11(i, k) || judge12(i, k)) {
							if (data.ARRAY[i][k] == 1) {
								data.VALUE[i][k] += WINW;
								data.VALUE[i - 1][k + 1] += WINW;
								data.VALUE[i - 2][k + 2] += WINW;
								data.VALUE[i - 3][k + 3] += WINW;
								// data.VALUE[i - 4][k + 4] += WIN;
							}

							if (data.ARRAY[i][k] == 2) {
								data.VALUE[i][k] += WINB;
								data.VALUE[i - 1][k + 1] += WINB;
								data.VALUE[i - 2][k + 2] += WINB;
								data.VALUE[i - 3][k + 3] += WINB;
								// data.VALUE[i - 4][k + 4] += WIN;
							}
						}
					}
				}
			}
	}

	// 判断中间有两个的情况

	public void twotwo() {
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {
				// 判断横排是否有3个
				if (i < 12 && i > 0) {
					if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
							&& data.ARRAY[i + 2][k] == data.ARRAY[i][k]
							&& data.ARRAY[i + 3][k] == 0

							&& data.ARRAY[i - 1][k] == 0) {

						if (data.ARRAY[i][k] == 1) {
							// System.out.println("hi");
							data.VALUE[i + 1][k] += TWO;
							data.VALUE[i + 2][k] += TWO;

							data.VALUE[i][k] += TWO;
						}

						if (data.ARRAY[i][k] == 2) {
							data.VALUE[i][k] += TWO;
							data.VALUE[i + 1][k] += TWO;
							data.VALUE[i + 2][k] += TWO;

						}

					}
				}
				// 判断竖排是否有3个
				if (k < 12 && k > 0) {
					if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
							&& data.ARRAY[i][k + 2] == data.ARRAY[i][k]
							&& data.ARRAY[i][k + 3] == 0

							&& data.ARRAY[i][k - 1] == 0)

					{
						if (data.ARRAY[i][k] == 1) {
							data.VALUE[i][k] += TWO;
							data.VALUE[i][k + 1] += TWO;
							data.VALUE[i][k + 2] += TWO;

						}

						if (data.ARRAY[i][k] == 2) {
							data.VALUE[i][k + 1] += TWO;
							data.VALUE[i][k + 2] += TWO;

							data.VALUE[i][k] += TWO;
						}
					}
				}

				// 判断右斜排是否有3个
				if (i < 12 && k < 12 && i > 0 && k > 0) {
					if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
							&& data.ARRAY[i + 2][k + 2] == data.ARRAY[i][k]
							&& data.ARRAY[i + 3][k + 3] == 0
							&& data.ARRAY[i - 1][k - 1] == 0) {
						if (data.ARRAY[i][k] == 1) {
							data.VALUE[i + 2][k + 2] += TWO;

							data.VALUE[i + 1][k + 1] += TWO;
							data.VALUE[i][k] += TWO;
						}

						if (data.ARRAY[i][k] == 2) {
							data.VALUE[i + 2][k + 2] += TWO;

							data.VALUE[i + 1][k + 1] += TWO;
							data.VALUE[i][k] += TWO;
						}
					}
				}
				// 判断左斜排是否有3个

				if (i > 3 && k < 12 && k > 0 && i < 12) {
					{
						if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
								&& data.ARRAY[i - 2][k + 2] == data.ARRAY[i][k]
								&& data.ARRAY[i - 3][k + 3] == 0

								&& data.ARRAY[i + 1][k - 1] == 0) {
							if (data.ARRAY[i][k] == 1) {
								data.VALUE[i][k] += TWO;
								data.VALUE[i - 1][k + 1] += TWO;
								data.VALUE[i - 2][k + 2] += TWO;

							}

							if (data.ARRAY[i][k] == 2) {
								data.VALUE[i][k] += TWO;
								data.VALUE[i - 1][k + 1] += TWO;
								data.VALUE[i - 2][k + 2] += TWO;

							}
						}
					}
				}
			}
	}

	public boolean judge1(int i, int k) {

		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i + 2][k] == data.ARRAY[i][k]
				&& data.ARRAY[i + 3][k] == data.ARRAY[i][k]
				&& data.ARRAY[i + 4][k] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge2(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i + 1][k] == data.ARRAY[i][k]
				&& data.ARRAY[i + 3][k] == data.ARRAY[i][k]
				&& data.ARRAY[i + 4][k] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge3(int i, int k) {

		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i + 1][k] == data.ARRAY[i][k]
				&& data.ARRAY[i + 2][k] == data.ARRAY[i][k]
				&& data.ARRAY[i + 4][k] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;

	}

	public boolean judge4(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i][k] == data.ARRAY[i][k + 2]
				&& data.ARRAY[i][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i][k + 4] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge5(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i][k + 1] == data.ARRAY[i][k]
				&& data.ARRAY[i][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i][k + 4] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge6(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i][k + 1] == data.ARRAY[i][k]
				&& data.ARRAY[i][k] == data.ARRAY[i][k + 2]
				&& data.ARRAY[i][k + 4] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge7(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)

		&& data.ARRAY[i][k] == data.ARRAY[i + 2][k + 2]
				&& data.ARRAY[i + 3][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i + 4][k + 4] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge8(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i + 1][k + 1] == data.ARRAY[i][k]
				// && data.ARRAY[i][k] == data.ARRAY[i + 2][k + 2]
				&& data.ARRAY[i + 3][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i + 4][k + 4] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge9(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i + 1][k + 1] == data.ARRAY[i][k]
				&& data.ARRAY[i][k] == data.ARRAY[i + 2][k + 2]
				// && data.ARRAY[i + 3][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i + 4][k + 4] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge10(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				// && data.ARRAY[i - 1][k + 1] == data.ARRAY[i][k]
				&& data.ARRAY[i][k] == data.ARRAY[i - 2][k + 2]
				&& data.ARRAY[i - 3][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i - 4][k + 4] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge11(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i - 1][k + 1] == data.ARRAY[i][k]
				// && data.ARRAY[i][k] == data.ARRAY[i - 2][k + 2]
				&& data.ARRAY[i - 3][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i - 4][k + 4] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge12(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i - 1][k + 1] == data.ARRAY[i][k]
				&& data.ARRAY[i][k] == data.ARRAY[i - 2][k + 2]
				// && data.ARRAY[i - 3][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i - 4][k + 4] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	// 判断3字在一条直线的情况,中间是否是否空了一个
	public void eight() {

		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {
				// 判断横排是否有3个
				if (i < 11 && i > 0) {
					if (judge22(i, k) || judge13(i, k)) {

						if (data.ARRAY[i][k] == 1) {
							// System.out.println("hi");
							data.VALUE[i + 1][k] += WWIN;
							data.VALUE[i + 2][k] += WWIN;
							data.VALUE[i + 3][k] += WWIN;

							data.VALUE[i][k] += WWIN;
						}

						if (data.ARRAY[i][k] == 2) {
							data.VALUE[i][k] += BWIN;
							data.VALUE[i + 1][k] += BWIN;
							data.VALUE[i + 2][k] += BWIN;
							data.VALUE[i + 3][k] += BWIN;

						}

					}
				}
				// 判断竖排是否有3个
				if (k < 11 && k > 0) {
					if (judge42(i, k) || judge52(i, k))

					{
						if (data.ARRAY[i][k] == 1) {
							data.VALUE[i][k] += WWIN;
							data.VALUE[i][k + 1] += WWIN;
							data.VALUE[i][k + 2] += WWIN;
							data.VALUE[i][k + 3] += WWIN;

						}

						if (data.ARRAY[i][k] == 2) {
							data.VALUE[i][k + 1] += BWIN;
							data.VALUE[i][k + 2] += BWIN;
							data.VALUE[i][k + 3] += BWIN;

							data.VALUE[i][k] += BWIN;
						}
					}
				}

				// 判断右斜排是否有3个
				if (i < 11 && k < 11 && i > 0 && k > 0) {
					if (judge72(i, k) || judge82(i, k)) {
						if (data.ARRAY[i][k] == 1) {
							data.VALUE[i + 2][k + 2] += WWIN;
							data.VALUE[i + 3][k + 3] += WWIN;

							data.VALUE[i + 1][k + 1] += WWIN;
							data.VALUE[i][k] += WWIN;
						}

						if (data.ARRAY[i][k] == 2) {
							data.VALUE[i + 2][k + 2] += BWIN;
							data.VALUE[i + 3][k + 3] += BWIN;

							data.VALUE[i + 1][k + 1] += BWIN;
							data.VALUE[i][k] += BWIN;
						}
					}
				}
				// 判断左斜排是否有3个

				if (i > 3 && k < 11 && i < 14 && k > 0) {
					{
						if (judge102(i, k) || judge112(i, k)) {

							if (data.ARRAY[i][k] == 1) {
								data.VALUE[i][k] += WWIN;
								data.VALUE[i - 1][k + 1] += WWIN;
								data.VALUE[i - 2][k + 2] += WWIN;
								data.VALUE[i - 3][k + 3] += WWIN;

							}

							if (data.ARRAY[i][k] == 2) {
								data.VALUE[i][k] += BWIN;
								data.VALUE[i - 1][k + 1] += BWIN;
								data.VALUE[i - 2][k + 2] += BWIN;
								data.VALUE[i - 3][k + 3] += BWIN;

							}
						}
					}
				}
			}
	}

	public boolean judge13(int i, int k) {

		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i + 2][k] == data.ARRAY[i][k]
				&& data.ARRAY[i + 3][k] == data.ARRAY[i][k]
				&& data.ARRAY[i + 4][k] == 0 && data.ARRAY[i - 1][k] == 0) {
			return true;
		} else
			return false;
	}

	public boolean judge22(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i + 1][k] == data.ARRAY[i][k]
				&& data.ARRAY[i + 3][k] == data.ARRAY[i][k]
				&& data.ARRAY[i + 4][k] == 0 && data.ARRAY[i - 1][k] == 0) {
			return true;
		} else
			return false;
	}

	public boolean judge42(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i][k] == data.ARRAY[i][k + 2]
				&& data.ARRAY[i][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i][k + 4] == 0 && data.ARRAY[i][k - 1] == 0) {
			return true;
		} else
			return false;
	}

	public boolean judge52(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i][k + 1] == data.ARRAY[i][k]
				&& data.ARRAY[i][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i][k + 4] == 0 && data.ARRAY[i][k - 1] == 0) {
			return true;
		} else
			return false;
	}

	public boolean judge72(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)

		&& data.ARRAY[i][k] == data.ARRAY[i + 2][k + 2]
				&& data.ARRAY[i + 3][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i + 4][k + 4] == 0
				&& data.ARRAY[i - 1][k - 1] == 0) {
			return true;
		} else
			return false;
	}

	public boolean judge82(int i, int k) {
		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i + 1][k + 1] == data.ARRAY[i][k]
				// && data.ARRAY[i][k] == data.ARRAY[i + 2][k + 2]
				&& data.ARRAY[i + 3][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i + 4][k + 4] == 0
				&& data.ARRAY[i - 1][k - 1] == 0) {
			return true;
		} else
			return false;
	}

	public boolean judge102(int i, int k) {

		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)

		&& data.ARRAY[i][k] == data.ARRAY[i - 2][k + 2]
				&& data.ARRAY[i - 3][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i - 4][k + 4] == 0
				&& data.ARRAY[i + 1][k - 1] == 0) {
			return true;

		} else
			return false;
	}

	public boolean judge112(int i, int k) {

		if ((data.ARRAY[i][k] == 1 || data.ARRAY[i][k] == 2)
				&& data.ARRAY[i - 1][k + 1] == data.ARRAY[i][k]
				// && data.ARRAY[i][k] == data.ARRAY[i - 2][k + 2]
				&& data.ARRAY[i - 3][k + 3] == data.ARRAY[i][k]
				&& data.ARRAY[i - 4][k + 4] == 0
				&& data.ARRAY[i + 1][k - 1] == 0) {
			return true;

		} else
			return false;
	}

}
