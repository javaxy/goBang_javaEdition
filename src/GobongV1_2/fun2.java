package GobongV1_2;

public class fun2 {
	
	int ONE=-15;
	int TWO=-31;
	int THREE=-400;
	int FOUR=-1000;
	//����������
	int FIVE=150;
	int SIX=200;
	
	//�����߳�
//	public void run(){
//		seven();
//		six();
//	}
	
	public void seven(){
		for(int i=0;i<data.ROW;i++)
			for(int k=0;k<data.ROW;k++){
				
				//�ж���Χ���ӵ����
				if(i<=4||i>=10||k<=4||k>=10){
					data.VALUE[i][k]-=FIVE;
				}
				if(i==0||i==14||k==0||k==14){
					data.VALUE[i][k]-=SIX;
				}
			}
	}

	//�ж�5��֮���Ƿ��а�������
	public void six(){
		
		
		for (int i = 0; i < data.ROW; i++)
			for (int k = 0; k < (data.ROW); k++) {
				// �жϺ����Ƿ��ж���İ���
				if (i < 10) {
					

						if (judge11(i, k)) {
							data.VALUE[i + 1][k] += FOUR;
						}
						
						if (judge12(i, k)) {
							data.VALUE[i + 1][k] += THREE;
  						    data.VALUE[i + 2][k] += THREE;

						}
						
						if (judge13(i, k)) {
							data.VALUE[i + 1][k] += TWO;
							data.VALUE[i + 2][k] += TWO;
							data.VALUE[i + 3][k] += TWO;
						}
						
						if (judge14(i, k)) {
							data.VALUE[i + 1][k] += ONE;
							data.VALUE[i + 2][k] += ONE;
							data.VALUE[i + 3][k] += ONE;
							data.VALUE[i + 4][k] += ONE;
						


					}
				}
				// �ж������Ƿ���5��
				if (k < 10) {
					if (judge21(i, k)) {
						//System.out.println("hi");
						data.VALUE[i ][k+1] += FOUR;
					}
					
					if (judge22(i, k)) {
						//System.out.println("hi");
						data.VALUE[i ][k+ 1] += THREE;
						    data.VALUE[i ][k+ 2] += THREE;

					}
					
					if (judge23(i, k)) {
						//System.out.println("hi");
						data.VALUE[i ][k+ 1] += TWO;
						data.VALUE[i ][k+ 2] += TWO;
						data.VALUE[i ][k+ 3] += TWO;
					}
					
					if (judge24(i, k)) {
						//System.out.println("hi");
						data.VALUE[i ][k+ 1] += ONE;
						data.VALUE[i][k + 2] += ONE;
						data.VALUE[i][k + 3] += ONE;
						data.VALUE[i][k + 4] += ONE;
					}
				}

				// �ж���б���Ƿ���5��
				if (i < 10 && k < 10) {
					if (judge31(i, k)) {
						data.VALUE[i+1 ][k+1] += FOUR;
					}
					
					if (judge32(i, k)) {
						data.VALUE[i+ 1 ][k+ 1] += THREE;
						    data.VALUE[i + 2][k+ 2] += THREE;

					}
					
					if (judge33(i, k)) {
						data.VALUE[i + 1][k+ 1] += TWO;
						data.VALUE[i+ 2 ][k+ 2] += TWO;
						data.VALUE[i + 3][k+ 3] += TWO;
					}
					
					if (judge34(i, k)) {
						data.VALUE[i+ 1 ][k+ 1] += ONE;
						data.VALUE[i+ 2][k + 2] += ONE;
						data.VALUE[i+ 3][k + 3] += ONE;
						data.VALUE[i+ 4][k + 4] += ONE;
					}
					
				}
				// �ж���б���Ƿ���5��

				if (i > 4 && k < 10) {
					if (judge41(i, k)) {
						data.VALUE[i-1 ][k+1] += FOUR;
					}
					
					if (judge42(i, k)) {
						data.VALUE[i- 1 ][k+ 1] += THREE;
						    data.VALUE[i -2][k+ 2] += THREE;

					}
					
					if (judge43(i, k)) {
						data.VALUE[i - 1][k+ 1] += TWO;
						data.VALUE[i- 2 ][k+ 2] += TWO;
						data.VALUE[i - 3][k+ 3] += TWO;
					}
					
					if (judge44(i, k)) {
						data.VALUE[i- 1 ][k+ 1] += ONE;
						data.VALUE[i- 2][k + 2] += ONE;
						data.VALUE[i- 3][k + 3] += ONE;
						data.VALUE[i- 4][k + 4] += ONE;
					
					}
				}
			}
	}

	public boolean judge11(int i, int k) {

		if ((data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i + 2][k] == data.ARRAY[i][k]
				) {
			return true;
		} else
			return false;
	}

	public boolean judge12(int i, int k) {
		if ((data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i + 3][k] == data.ARRAY[i][k]
				) {
			return true;
		} else
			return false;
	}

	public boolean judge13(int i, int k) {

		if ((data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i + 4][k] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;

	}
	public boolean judge14(int i, int k) {

		if ((data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i + 5][k] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;

	}

	public boolean judge21(int i, int k) {
		if ((data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i][k] == data.ARRAY[i][k + 2]
				) {
			return true;
		} else
			return false;
	}

	public boolean judge22(int i, int k) {
		if ((data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i][k + 3] == data.ARRAY[i][k]
			) {
			return true;
		} else
			return false;
	}

	public boolean judge23(int i, int k) {
		if ((data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i][k + 4] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}
	
	public boolean judge24(int i, int k) {
		if ((data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i][k + 5] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge31(int i, int k) {
		if ((data.ARRAY[i][k] == 1 )

		&& data.ARRAY[i][k] == data.ARRAY[i + 2][k + 2]
				) {
			return true;
		} else
			return false;
	}

	public boolean judge32(int i, int k) {
		if ((data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i + 3][k + 3] == data.ARRAY[i][k]
				) {
			return true;
		} else
			return false;
	}

	public boolean judge33(int i, int k) {
		if ((data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i + 4][k + 4] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}
	
	public boolean judge34(int i, int k) {
		if ((data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i + 5][k + 5] == data.ARRAY[i][k]) {
			return true;
		} else
			return false;
	}

	public boolean judge41(int i,int k){
	 if
	 ( (data.ARRAY[i][k] == 1 )
			&& data.ARRAY[i][k] == data.ARRAY[i - 2][k + 2]
			){
			return true;
	} else
		return false;}
	
	 public boolean judge42(int i,int k){
		 if
		 ( (data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i - 3][k + 3] == data.ARRAY[i][k]
			){
				return true;
		} else
			return false;
	 }
	 
	 public boolean judge43(int i,int k){
		 if
		 ( (data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i - 4][k + 4] == data.ARRAY[i][k]){
				return true;
		} else
			return false;
	 }
		
	 public boolean judge44(int i,int k){
		 if
		 ( (data.ARRAY[i][k] == 1 )
				&& data.ARRAY[i - 5][k + 5] == data.ARRAY[i][k]){
				return true;
		} else
			return false;
	 }
			
		
		
		
	}

