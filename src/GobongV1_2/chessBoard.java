package GobongV1_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ����̳���������Ϊ�˺���д�ػ�ʱ����
 * @author Administrator
 *
 */
public class chessBoard extends JPanel{
	
	//step��¼����
	public static int step=0;
	
	AI1 a;
	public static void main(String[] args){
		chessBoard ch=new chessBoard();
		ch.initUI();
	}

	private void initUI() {
		JFrame jf=new JFrame();
		jf.setTitle("������");
		jf.setSize(650,600);
		jf.setLocation(300,50);
		jf.setDefaultCloseOperation(3);
		
		JPanel jpNorth=new JPanel();
		JButton jb1=new JButton("����");
		JButton jb2=new JButton("����");
		JButton jb3=new JButton("����");
		jpNorth.add(jb1);
		jpNorth.add(jb2);
		jpNorth.add(jb3);
		//���ڲ����������ť�Ӽ�����
		ActionListener ac=new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//�õ���������
				String commond=e.getActionCommand();
				if("����".equals(commond)){
//					System.out.println("����");
					//�����ļ��������
					FileIO fi=new FileIO();
					try {
						fi.save("F:\\java\\����������\\a1.as",data.ARRAY,a.getSt());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if("����".equals(commond)){
					//�����ļ��������
					FileIO fi=new FileIO();
					try {
						StepList st1=fi.read("F:\\java\\����������\\a1.as");
						StepList st=a.getSt();
						for(int i=0;i<st1.size();i++){
							st.add(st1.get(i));
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaint();
				}
				else if("����".equals(commond)){
					//�õ������ÿһ�����ݵĶ���
					StepList st=a.getSt();
					EveryStep ev=st.get();
					data.ARRAY[ev.bx][ev.by]=0;
					data.ARRAY[ev.wx][ev.wy]=0;
					st.delete();
					repaint();
				}
			}};
			jb1.addActionListener(ac);
			jb2.addActionListener(ac);
			jb3.addActionListener(ac);
		jpNorth.setPreferredSize(new Dimension(0,80));
		jpNorth.setBackground(Color.white);
		jf.add(jpNorth,BorderLayout.SOUTH);
		
		this.setBackground(Color.orange);
		jf.add(this,BorderLayout.CENTER);
		
		jf.setVisible(true);
		
		Graphics g=this.getGraphics();
		
		//ʵ����һ�����ӵļ�����
		//chessListener ch=new chessListener(g);
		
		//�����̼�һ�������������ˣ�
		//this.addMouseListener(ch);
		
//		gobangAI0 go=new gobangAI0(g);
//		�����̼�һ�����������˻�0��
//		this.addMouseListener(go);
		 a=new AI1(g);
		this.addMouseListener(a);
		
		g.setColor(Color.black);
		// System.out.println(data.VALUE[i][j]);
		g.fillOval(5 + 7 * data.SIZE, 5 + 7 * data.SIZE, 30, 30);
		data.ARRAY[7][7] = 2;
		chessBoard.step++;
		data.BOARDSTEP[7][7]=chessBoard.step;
	
//		ChessManual ch=new ChessManual(g);
		
	} 
	
	/**
	 * �����ػ�ķ���
	 * ��д�ػ�ķ���
	 * ÿ����ʾ���嶼���Զ����ô˷���
	 */
	public void paint(Graphics g){
		super.paint(g);//���ø���ķ���
		board(g);
		chess(g);
	}
	
	//�������̵ķ���
	public void board(Graphics g){
	   for(int i=0;i<data.ROW;i++){
		   g.drawLine(20, 20+data.SIZE*i, 440, 20+data.SIZE*i);
	   }
	   for(int i=0;i<data.ROW;i++){
		   g.drawLine( 20+data.SIZE*i,20,  20+data.SIZE*i,440);
	   }
	}
	//дһ���ػ����ӵķ���
	public void chess(Graphics g){
		for(int i=0;i<15;i++)
			for(int j=0;j<15;j++){
				if(data.ARRAY[i][j]==1)
				{
					g.setColor(Color.white);
					g.fillOval(5+i*data.SIZE,5+j*data.SIZE,30,30);}
				if(data.ARRAY[i][j]==2)
				{
					g.setColor(Color.black);
					g.fillOval(5+i*data.SIZE,5+j*data.SIZE,30,30);}
			}
	}
	
}
