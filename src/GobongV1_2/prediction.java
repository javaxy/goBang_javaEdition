package GobongV1_2;

public class prediction {

	fun f = new fun();

	int NX;
	int NY;
	int NBXX;
	int NBYY;

	public void pre(int n) {
		if (n == 0) {
			return;
		}
		int MAX = 0;
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {

				if (data.VALUE[i][j] > MAX) {
					MAX = data.VALUE[i][j];

					data.FINAL[0] = i;
					//System.out.println();
					NX = i;
					data.FINAL[1] = j;
					NY = j;
					//System.out.println(data.FINAL[0] + " hihi       "
							//+ data.FINAL[1]);
					// System.out.println(data.FINAL[0]+"   "+data.FINAL[1]);
				}
			}

		// 先判断白棋，因为要堵白子的双三
		if (MAX < 1500) {

			// 假设白棋下的地方
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {

					// 找到没下的点
					if (data.ARRAY[i][j] == 0) {
						// 重置权值点
						for (int i2 = 0; i2 < 15; i2++)
							for (int j2 = 0; j2 < 15; j2++) {
								data.VALUE[i2][j2] = 1000;
							}
						int k = 0;

						// 假设白子下的地方
						data.ARRAY[i][j] = 1;
						f.value();
						// 遍历找极大值
						for (int i1 = 0; i1 < 15; i1++)
							for (int j1 = 0; j1 < 15; j1++) {
								if (data.VALUE[i1][j1] > 1700
										&& data.VALUE[i1][j1] < 2600) {
									k++;
									// System.out.println(k);
								}
								if (data.VALUE[i1][j1] > 2800) {
									k += 3;
									// System.out.println(k);
								}
							}
						// 存储极大值的全指点
						data.MAXK[i][j] = k;

						int MAX2 = 0;
						for (int i1 = 0; i1 < 15; i1++)
							for (int j1 = 0; j1 < 15; j1++) {
								if (data.MAXK[i1][j1] > MAX2) {
									MAX2 = data.MAXK[i1][j1];
									NBXX = i1;
									NBYY = j1;
								}
							}

						// 如果它的极值点有两个,
						// System.out.println(k);
						if (MAX2 > 3 && data.VALUE[NBXX][NBYY] > 0) {
							//System.out.println(NBXX + "  " + NBYY);
							//System.out.println(data.VALUE[NBXX][NBYY]);
							data.FINAL[0] = NBXX;
							data.FINAL[1] = NBYY;
							//System.out.println(MAX2);
							//System.out.println("HAHA" + data.FINAL[0]
								//	+ data.FINAL[1]);
							MAX2 = 0;
						} else {
							pre(n - 1);
						}

						// 把假设的白子去掉
						data.ARRAY[i][j] = 0;

					}

				}

		}

		// 后判断黑棋，因为要保证黑棋先赢
		if (MAX < 1500) {
			// 假设黑棋下的地方
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					// 重置权值点
					for (int i2 = 0; i2 < 15; i2++)
						for (int j2 = 0; j2 < 15; j2++) {
							data.VALUE[i2][j2] = 1000;
						}
					int k = 0;
					// 找到没下的点
					if (data.ARRAY[i][j] == 0) {
						// 假设黑子下的地方
						data.ARRAY[i][j] = 2;

						f.value();
						// 遍历找极大值
						for (int i1 = 0; i1 < 15; i1++)
							for (int j1 = 0; j1 < 15; j1++) {
								if (data.VALUE[i1][j1] > 1700
										&& data.VALUE[i1][j1] < 2600) {
									k++;
								}
								if (data.VALUE[i1][j1] > 2600) {
									k += 3;
								}

							}

						int MAX2 = 0;// 最大K值点
						for (int i1 = 0; i1 < 15; i1++)
							for (int j1 = 0; j1 < 15; j1++) {
								if (data.MAXK[i1][j1] > MAX2) {
									MAX2 = data.MAXK[i1][j1];
									NBXX = i1;
									NBYY = j1;
								}
							}
						// 如果它的极值点有两个,
						// System.out.println(k);
						if (MAX2 > 3 && data.VALUE[NBXX][NBYY] > 0) {
							//System.out.println(k);
							data.FINAL[0] = NBXX;
							data.FINAL[1] = NBYY;
							//System.out.println("LALA");
							MAX2 = 0;
						} else {
							pre(n - 1);
						}

						// 把假设的黑子去掉
						data.ARRAY[i][j] = 0;
					}

				}

		}

	}
}
