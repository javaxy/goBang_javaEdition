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
	//删除最后一步
	public void delete(){
		EveryStep[] dest=new EveryStep[st.length-1];
		for(int i=0;i<st.length-1;i++){
			dest[i]=st[i];
		}
		st=dest;
	}
	//得到最后一步棋
	public EveryStep get(){
		EveryStep Step=st[st.length-1];
		return Step;
	}
	//得到任意位置的
	public EveryStep get(int index){
		return st[index];
	}
	
	//得到队列的长度
	public int size(){
		return st.length;
	}
	//设置队列
//	public void set(EveryStep[] st1){
//		st=st1;
//	}
}
