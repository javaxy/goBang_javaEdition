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
 * 在这继承面板对象是为了后面写重绘时方便
 * @author Administrator
 *
 */
public class chessBoard extends JPanel{
	
	//step记录步数
	public static int step=0;
	
	AI1 a;
	public static void main(String[] args){
		chessBoard ch=new chessBoard();
		ch.initUI();
	}

	private void initUI() {
		JFrame jf=new JFrame();
		jf.setTitle("五子棋");
		jf.setSize(650,600);
		jf.setLocation(300,50);
		jf.setDefaultCloseOperation(3);
		
		JPanel jpNorth=new JPanel();
		JButton jb1=new JButton("保存");
		JButton jb2=new JButton("读出");
		JButton jb3=new JButton("悔棋");
		jpNorth.add(jb1);
		jpNorth.add(jb2);
		jpNorth.add(jb3);
		//用内部类给两个按钮加监听器
		ActionListener ac=new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//得到动作命令
				String commond=e.getActionCommand();
				if("保存".equals(commond)){
//					System.out.println("保存");
					//创建文件输出对象
					FileIO fi=new FileIO();
					try {
						fi.save("F:\\java\\保存五子棋\\a1.as",data.ARRAY,a.getSt());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if("读出".equals(commond)){
					//创建文件输入对象
					FileIO fi=new FileIO();
					try {
						StepList st1=fi.read("F:\\java\\保存五子棋\\a1.as");
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
				else if("悔棋".equals(commond)){
					//得到下棋的每一步数据的队列
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
		
		//实例化一个棋子的监听器
		//chessListener ch=new chessListener(g);
		
		//给棋盘加一个监听器（人人）
		//this.addMouseListener(ch);
		
//		gobangAI0 go=new gobangAI0(g);
//		给棋盘加一个监听器（人机0）
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
	 * 调用重绘的方法
	 * 重写重绘的方法
	 * 每次显示窗体都会自动调用此方法
	 */
	public void paint(Graphics g){
		super.paint(g);//调用父类的方法
		board(g);
		chess(g);
	}
	
	//绘制棋盘的方法
	public void board(Graphics g){
	   for(int i=0;i<data.ROW;i++){
		   g.drawLine(20, 20+data.SIZE*i, 440, 20+data.SIZE*i);
	   }
	   for(int i=0;i<data.ROW;i++){
		   g.drawLine( 20+data.SIZE*i,20,  20+data.SIZE*i,440);
	   }
	}
	//写一个重绘棋子的方法
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
