package GobongV1_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
	public void save(String path,int[][] a,StepList st) throws IOException{
		
		try {
			//文件输出流
			FileOutputStream fos=new FileOutputStream(path);
			//将文件输出流包装成可写入基本类型的流
			DataOutputStream dos=new DataOutputStream(fos);
			//先写入走了多少步
			dos.writeInt(st.size());
			//存入每一步的情况
			for(int j=0;j<st.size();j++){
				EveryStep ev=st.get(j);
				dos.writeInt(ev.bx);
				dos.writeInt(ev.by);
				dos.writeInt(ev.wx);
				dos.writeInt(ev.wy);
			}
			//将棋盘情况存入
			for(int i=0;i<15;i++)
			for(int j=0;j<15;j++){
				try {
					dos.writeInt(a[i][j]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
public StepList read(String path) throws IOException{
	//创建一个队列
	StepList st=new StepList();
		try {
			//文件输入流
			FileInputStream fos=new FileInputStream(path);
			//将文件输入流包装成可写入基本类型的流
			DataInputStream dos=new DataInputStream(fos);
			//先读出走了多少步
			int len=dos.readInt();
			//存入每一步的情况
			for(int j=0;j<len;j++){
				//创建棋子步数对象
				EveryStep ev=new EveryStep();
				//读取数据类型
				ev.bx=dos.readInt();
				ev.by=dos.readInt();
				ev.wx=dos.readInt();
				ev.wy=dos.readInt();
				//将步数存入队列
				st.add(ev);
			}
			
			//将棋盘情况读出
			for(int i=0;i<15;i++)
			for(int j=0;j<15;j++){
				try {
				
					data.ARRAY[i][j]=dos.readInt();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
}
