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
			//�ļ������
			FileOutputStream fos=new FileOutputStream(path);
			//���ļ��������װ�ɿ�д��������͵���
			DataOutputStream dos=new DataOutputStream(fos);
			//��д�����˶��ٲ�
			dos.writeInt(st.size());
			//����ÿһ�������
			for(int j=0;j<st.size();j++){
				EveryStep ev=st.get(j);
				dos.writeInt(ev.bx);
				dos.writeInt(ev.by);
				dos.writeInt(ev.wx);
				dos.writeInt(ev.wy);
			}
			//�������������
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
	//����һ������
	StepList st=new StepList();
		try {
			//�ļ�������
			FileInputStream fos=new FileInputStream(path);
			//���ļ���������װ�ɿ�д��������͵���
			DataInputStream dos=new DataInputStream(fos);
			//�ȶ������˶��ٲ�
			int len=dos.readInt();
			//����ÿһ�������
			for(int j=0;j<len;j++){
				//�������Ӳ�������
				EveryStep ev=new EveryStep();
				//��ȡ��������
				ev.bx=dos.readInt();
				ev.by=dos.readInt();
				ev.wx=dos.readInt();
				ev.wy=dos.readInt();
				//�������������
				st.add(ev);
			}
			
			//�������������
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
