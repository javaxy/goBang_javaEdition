package cn.AI2AI;

public interface data {

	int ROW = 15;
	int COL = 15;

	int SIZE = 30;

	// 0ÊÇ¿Õ£¬1ÊÇ°×£¬2ÊÇºÚ
	int ARRAY[][] = new int[ROW][COL];

	int VALUE[][] = new int[ROW][COL];

	int BOARDSTEP[][] = new int[ROW][COL];
	int PREDICT[][] = new int[15][15];

	int FINAL[] = new int[2];

	int MAXK[][] = new int[15][15];

}
