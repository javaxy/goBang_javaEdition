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

		// ���жϰ��壬��ΪҪ�°��ӵ�˫��
		if (MAX < 1500) {

			// ��������µĵط�
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {

					// �ҵ�û�µĵ�
					if (data.ARRAY[i][j] == 0) {
						// ����Ȩֵ��
						for (int i2 = 0; i2 < 15; i2++)
							for (int j2 = 0; j2 < 15; j2++) {
								data.VALUE[i2][j2] = 1000;
							}
						int k = 0;

						// ��������µĵط�
						data.ARRAY[i][j] = 1;
						f.value();
						// �����Ҽ���ֵ
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
						// �洢����ֵ��ȫָ��
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

						// ������ļ�ֵ��������,
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

						// �Ѽ���İ���ȥ��
						data.ARRAY[i][j] = 0;

					}

				}

		}

		// ���жϺ��壬��ΪҪ��֤������Ӯ
		if (MAX < 1500) {
			// ��������µĵط�
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) {
					// ����Ȩֵ��
					for (int i2 = 0; i2 < 15; i2++)
						for (int j2 = 0; j2 < 15; j2++) {
							data.VALUE[i2][j2] = 1000;
						}
					int k = 0;
					// �ҵ�û�µĵ�
					if (data.ARRAY[i][j] == 0) {
						// ��������µĵط�
						data.ARRAY[i][j] = 2;

						f.value();
						// �����Ҽ���ֵ
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

						int MAX2 = 0;// ���Kֵ��
						for (int i1 = 0; i1 < 15; i1++)
							for (int j1 = 0; j1 < 15; j1++) {
								if (data.MAXK[i1][j1] > MAX2) {
									MAX2 = data.MAXK[i1][j1];
									NBXX = i1;
									NBYY = j1;
								}
							}
						// ������ļ�ֵ��������,
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

						// �Ѽ���ĺ���ȥ��
						data.ARRAY[i][j] = 0;
					}

				}

		}

	}
}
