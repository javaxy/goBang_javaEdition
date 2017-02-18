package cn.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QQ130710 extends JPanel{
	//定义一个全局变量的监听器类
	LoginListener0716 lo;
	JFrame qqf;
	JButton j1;
	JButton j3;
	JButton j5;
	JButton j4;
	JPanel jpin;
	Image ii;
	JButton jb1;
	
	/**
	 * 主程序入口
	 */
	
	//犯了个大错误不能在主函数写太多   TAT
	public static void main(String[] args) {
		// 实例化一个对象
		QQ130710 qq = new QQ130710();
		qq.Frame();
	}

	// 定义一个获得下方面板的方法
	public JPanel getSouth() {
		// 实例化一个新面板
		JPanel jp = new JPanel();
		//加入两个按钮两个透明的标签
		jp.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		ImageIcon i1=new ImageIcon("images/8.png");
		//ImageIcon i1=new ImageIcon(this.getClass().getResource("8.png"));
		//如果想要把打包成图片，
		ImageIcon i2=new ImageIcon("images/9.png");
		//多账号登陆
		 j1=new JButton(i1);
		//二维码按钮
		JButton j2=new JButton(i2);
		JLabel jl1=new JLabel();
		JLabel jl2=new JLabel();
		jl1.setPreferredSize(new Dimension(65,1));
		jl2.setPreferredSize(new Dimension(70,1));
		j1.setPreferredSize(new Dimension(52,45));
		j2.setPreferredSize(new Dimension(24,25));
		j1.setOpaque(false);
		j2.setOpaque(false);
		//去除按钮边框
		j1.setBorderPainted(false);
		
		//给多账号登陆加一个监听器,实现其切换图片效果（内部类）
		MouseAdapter qb8=new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				
				j1.setIcon(new ImageIcon("images/8(1).png"));
			}
			
			public void mouseExited(MouseEvent e) {
				j1.setIcon(new ImageIcon("images/8.png"));
			}
		};
		
		
	
	j1.addMouseListener(qb8);
		Font font=new Font("微软雅黑",Font.BOLD,20);
		//实例化一个按钮对象
		JLabel jb=new JLabel("Dawn      V1_4");
		jb.setFont(font);
	//	jb.setActionCommand("login");
		//设置按钮的属性
		jb.setPreferredSize(new Dimension(150,33));
	//	jb.setBorderPainted(false);
	//设置按钮的位置
			jp.setLocation(118, 247);
			//给按钮加上监听器
		//添加按钮到画板上
			jp.add(j1);
			jp.add(jl1);
		jp.add(jb);
		jp.add(jl2);
		jp.add(j2);
		
		
		//因为是面板所以直接将其设为透明
		jp.setOpaque(false);
		
		return jp;
	}

	// 定义一个获得中间面板的方法
	public JPanel getCenter() {
		lo=new LoginListener0716(qqf);
		// 实例化一个新面板
		JPanel jp = new JPanel();
		//设置面板内的流体布局从左对齐
		jp.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		  ImageIcon i1=new ImageIcon("images/333.png");
			JButton j1=new JButton(i1);
			//二维码按钮
			j1.setPreferredSize(new Dimension(81,81));
			j1.setContentAreaFilled(false);
			//j1.setOpaque(false);
			//去除按钮边框
			j1.setBorderPainted(false);
			j1.setActionCommand("pvp");
			j1.addActionListener(lo);
			
			
			ImageIcon i2=new ImageIcon("images/111.png");
			JButton j2=new JButton(i2);
			//二维码按钮
			j2.setPreferredSize(new Dimension(81,81));
			j2.setContentAreaFilled(false);
		//	j2.setOpaque(false);
			//去除按钮边框
			j2.setBorderPainted(false);
			j2.setActionCommand("pve");
			j2.addActionListener(lo);
			
			ImageIcon i3=new ImageIcon("images/222.png");
			JButton j3=new JButton(i3);
			//二维码按钮
			j3.setPreferredSize(new Dimension(81,81));
			j3.setContentAreaFilled(false);
			//j3.setOpaque(false);
			//去除按钮边框
			j3.setBorderPainted(false);
			j3.setActionCommand("eve");
			j3.addActionListener(lo);
		
		
		//实例化一个监听器用于传递用户名和密码
		lo=new LoginListener0716(qqf);
		
		
		

		//因为是面板所以直接将其设为透明
		jp.setOpaque(false);
		jp.add(j2);
		jp.add(j1);
		jp.add(j3);
		
		return jp;
	}

	// 定义一个获得左边面板的方法
	public JPanel getWest() {

		// 实例化一个新面板
		JPanel jp = new JPanel();
		//设置面板内的流体布局从右对齐
		jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
        ImageIcon i1=new ImageIcon("images/333.png");
		JButton j1=new JButton(i1);
		//二维码按钮
		j1.setPreferredSize(new Dimension(81,81));
		j1.setContentAreaFilled(false);
		j1.setOpaque(false);
		//去除按钮边框
		j1.setBorderPainted(false);
		
		
		jp.add(j1);
		

		//因为是面板所以直接将其设为透明
		
		jp.setOpaque(false);
		return jp;
	}

	// 定义一个获得上方面板的方法
	public JPanel getNorth() {
		// 实例化一个新面板
		JPanel jp = new JPanel();
		// 设置面板的属性
		jp.setPreferredSize(new Dimension(0, 130));
		jp.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		// 实例化一个图形对象
		ImageIcon ii3 = new ImageIcon("images/3.png");
	    //设置
		 j3=new JButton(ii3);
		 
		//给设置加一个监听器,实现其切换图片效果
			MouseAdapter qb3=new MouseAdapter(){
				public void mouseEntered(MouseEvent e) {
					
					j3.setIcon(new ImageIcon("images/3(1).png"));
				}
				
				public void mouseExited(MouseEvent e) {
					j3.setIcon(new ImageIcon("images/3.png"));
				}
			};
			j3.addMouseListener(qb3);
		
		ImageIcon ii4 = new ImageIcon("images/4.png");
		//最小化
		j4=new JButton(ii4);
		
		//用内部类定义一个最小化的按钮
		ActionListener q1=new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				qqf.setExtendedState(qqf.ICONIFIED); //最小化
				
			}
			
		};
		j4.addActionListener(q1);
		
		//给最小化加一个监听器,实现其切换图片效果
		MouseAdapter qb4=new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				
				j4.setIcon(new ImageIcon("images/4(1).png"));
			}
			
			public void mouseExited(MouseEvent e) {
				j4.setIcon(new ImageIcon("images/4.png"));
			}
		};
		
		
	
	j4.addMouseListener(qb4);
		
		ImageIcon ii5 = new ImageIcon("images/5.png");
		//关闭
		

		j5=new JButton(ii5);
		//设置命令为close
		j5.setActionCommand("close");

		//在这里我们新定义了一个监听器
		//虽然我还不知道为什么如果不新定义一个监听器
		LoginListener0716 ll = new LoginListener0716( qqf);
		//给关闭加一个监听器
		j5.addActionListener(ll);
		//给关闭加一个监听器,实现其切换图片效果
		MouseAdapter qb=new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				j5.setIcon(new ImageIcon("images/5(1).png"));
			}
			
			public void mouseExited(MouseEvent e) {
				j5.setIcon(new ImageIcon("images/5.png"));
			}
		};
		
		
	
	j5.addMouseListener(qb);
		
		//因为是面板所以直接将其设为透明
		jp.setOpaque(false);
		
		jp.add(j3);
		jp.add(j4);
		jp.add(j5);
		//将按钮置于右上方
	//	j5.setBounds(343, 0, 37, 15);
	//	j5.setOpaque(true);
		j3.setPreferredSize(new Dimension(28,15));
		j4.setPreferredSize(new Dimension(28,15));
		j5.setPreferredSize(new Dimension(35,15));
		
		//去除按钮边框
		j3.setBorderPainted(false);
		j4.setBorderPainted(false);
		j5.setBorderPainted(false);
		
		
		
		return jp;
	}

	// 定义一个初始化QQ窗体的方法
	public void  Frame() {
		// 创建一个新的窗体对象
		 qqf = new JFrame();
		// 设置对象的各个属性
		 qqf.setTitle("QQ");
		 qqf.setSize(378, 290);
//		 qqf.setLocation(500, 250);
		 qqf.setLocation(new Point(500,200));
		 qqf.setResizable(false);
		 qqf.setDefaultCloseOperation(2);
		
		
		//JFrame 的默认布局是边框布局

		// 设置它的边框布局管理器
		
		// 把上方的面板加到QQ窗体上
		qqf.add(getNorth(), BorderLayout.NORTH);

		// 把左边的面板加到QQ窗体上
//		JPanel qqfw=getWest();
//		qqf.add(qqfw, BorderLayout.WEST);

		// 把中间的面板加到QQ窗体上
		qqf.add(getCenter(), BorderLayout.CENTER);

		// 把下方的面板加到QQ窗体上
		qqf.add(getSouth(), BorderLayout.SOUTH);
		
		/**
		 * 因为JFrame上有一个图层
		 * 一个图层又分为好多层
		 * 然后有些图层是不透明的
		 * 所以我们的思路就是
		 * 把BackgrounPicture置于JFrame最底层
		 * 然后再将面板一一设为透明的即可
		 */
		
		//给QQ窗体加入背景
		ImageIcon im=new ImageIcon("images/13.png");
		//转换为一个标签对象
		JLabel JP=new JLabel(im);
		//设置填充区域
		JP.setBounds(0, 0, im.getIconWidth(),im.getIconHeight());
		//将图片置于JLayeredPane面板的最底层
		qqf.getLayeredPane().add(JP,new Integer(Integer.MIN_VALUE));
		//获取ContentPane面板（就是那个不透明的家伙）
		JPanel opacity=(JPanel) qqf.getContentPane();
		//把它设为透明的
		opacity.setOpaque(false);
		
		//为了模仿的更像 去除掉它的边框吧
		qqf.setUndecorated(true);
		//对界面加入监听器，使其能拖动
		qqf.addMouseMotionListener(lo);
		//实现不同的方法应该加入不同的监听器
		qqf.addMouseListener(lo);
	

		qqf.setVisible(true);
		
	
		
	}



}
