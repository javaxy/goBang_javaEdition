package GobongV1_2;

public class StepList {
	private EveryStep[] st=new  EveryStep[0];
	
	public void add(EveryStep ev){
		EveryStep[] dest=new EveryStep[st.length+1];
		dest[st.length]=ev;
		for(int i=0;i<st.length;i++){
			dest[i]=st[i];
		}
		st=dest;
	}
	//ɾ�����һ��
	public void delete(){
		EveryStep[] dest=new EveryStep[st.length-1];
		for(int i=0;i<st.length-1;i++){
			dest[i]=st[i];
		}
		st=dest;
	}
	//�õ����һ����
	public EveryStep get(){
		EveryStep Step=st[st.length-1];
		return Step;
	}
	//�õ�����λ�õ�
	public EveryStep get(int index){
		return st[index];
	}
	
	//�õ����еĳ���
	public int size(){
		return st.length;
	}
	//���ö���
//	public void set(EveryStep[] st1){
//		st=st1;
//	}
}
