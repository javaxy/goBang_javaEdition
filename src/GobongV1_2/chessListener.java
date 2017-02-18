package GobongV1_2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class chessListener extends MouseAdapter{

	private Graphics g;
	boolean k=true;
	
	

	public chessListener(Graphics g) {
		this.g=g;
	}
	
	public void mouseClicked(MouseEvent e) {
		int a=e.getX();
		int b=e.getY();
//		System.out.println(a+"   "+b);
//		System.out.println(data.ARRAY[0][0]);
		for(int i=0;i<15;i++)
			for(int j=0;j<15;j++){
				if(a<(35+i*data.SIZE)&&a>(5+i*data.SIZE)&&b>(5+j*data.SIZE)&&b<(35+j*data.SIZE)){
//					if(data.ARRAY[i][j]==0){
//					data.ARRAY[i][j]=1;}
//					System.out.println(data.ARRAY[i][j]);
//					System.out.println(i+"   "+j);
					//ÅÐ¶ÏÎ»ÖÃÊÇ·ñÎª¿Õ£¬ÊÇ·ñÊÇºÚÆå»ò°×Æå
					if(k&&data.ARRAY[i][j]==0){
					g.drawOval(5+i*data.SIZE,5+j*data.SIZE,30,30);
					k=false;
					data.ARRAY[i][j]=1;
					}
					if(k==false&&data.ARRAY[i][j]==0){
						g.fillOval(5+i*data.SIZE,5+j*data.SIZE,30,30);
					k=true;
					data.ARRAY[i][j]=2;
					}
				}
			}
		
		//ÏÔÊ¾Í¼Æ¬
		judge j1=new judge(g);
		j1.judge1();
		
		
	}
	
	
	

}
