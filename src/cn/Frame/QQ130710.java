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
	//����һ��ȫ�ֱ����ļ�������
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
	 * ���������
	 */
	
	//���˸����������������д̫��   TAT
	public static void main(String[] args) {
		// ʵ����һ������
		QQ130710 qq = new QQ130710();
		qq.Frame();
	}

	// ����һ������·����ķ���
	public JPanel getSouth() {
		// ʵ����һ�������
		JPanel jp = new JPanel();
		//����������ť����͸���ı�ǩ
		jp.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		ImageIcon i1=new ImageIcon("images/8.png");
		//ImageIcon i1=new ImageIcon(this.getClass().getResource("8.png"));
		//�����Ҫ�Ѵ����ͼƬ��
		ImageIcon i2=new ImageIcon("images/9.png");
		//���˺ŵ�½
		 j1=new JButton(i1);
		//��ά�밴ť
		JButton j2=new JButton(i2);
		JLabel jl1=new JLabel();
		JLabel jl2=new JLabel();
		jl1.setPreferredSize(new Dimension(65,1));
		jl2.setPreferredSize(new Dimension(70,1));
		j1.setPreferredSize(new Dimension(52,45));
		j2.setPreferredSize(new Dimension(24,25));
		j1.setOpaque(false);
		j2.setOpaque(false);
		//ȥ����ť�߿�
		j1.setBorderPainted(false);
		
		//�����˺ŵ�½��һ��������,ʵ�����л�ͼƬЧ�����ڲ��ࣩ
		MouseAdapter qb8=new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				
				j1.setIcon(new ImageIcon("images/8(1).png"));
			}
			
			public void mouseExited(MouseEvent e) {
				j1.setIcon(new ImageIcon("images/8.png"));
			}
		};
		
		
	
	j1.addMouseListener(qb8);
		Font font=new Font("΢���ź�",Font.BOLD,20);
		//ʵ����һ����ť����
		JLabel jb=new JLabel("Dawn      V1_4");
		jb.setFont(font);
	//	jb.setActionCommand("login");
		//���ð�ť������
		jb.setPreferredSize(new Dimension(150,33));
	//	jb.setBorderPainted(false);
	//���ð�ť��λ��
			jp.setLocation(118, 247);
			//����ť���ϼ�����
		//��Ӱ�ť��������
			jp.add(j1);
			jp.add(jl1);
		jp.add(jb);
		jp.add(jl2);
		jp.add(j2);
		
		
		//��Ϊ���������ֱ�ӽ�����Ϊ͸��
		jp.setOpaque(false);
		
		return jp;
	}

	// ����һ������м����ķ���
	public JPanel getCenter() {
		lo=new LoginListener0716(qqf);
		// ʵ����һ�������
		JPanel jp = new JPanel();
		//��������ڵ����岼�ִ������
		jp.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		  ImageIcon i1=new ImageIcon("images/333.png");
			JButton j1=new JButton(i1);
			//��ά�밴ť
			j1.setPreferredSize(new Dimension(81,81));
			j1.setContentAreaFilled(false);
			//j1.setOpaque(false);
			//ȥ����ť�߿�
			j1.setBorderPainted(false);
			j1.setActionCommand("pvp");
			j1.addActionListener(lo);
			
			
			ImageIcon i2=new ImageIcon("images/111.png");
			JButton j2=new JButton(i2);
			//��ά�밴ť
			j2.setPreferredSize(new Dimension(81,81));
			j2.setContentAreaFilled(false);
		//	j2.setOpaque(false);
			//ȥ����ť�߿�
			j2.setBorderPainted(false);
			j2.setActionCommand("pve");
			j2.addActionListener(lo);
			
			ImageIcon i3=new ImageIcon("images/222.png");
			JButton j3=new JButton(i3);
			//��ά�밴ť
			j3.setPreferredSize(new Dimension(81,81));
			j3.setContentAreaFilled(false);
			//j3.setOpaque(false);
			//ȥ����ť�߿�
			j3.setBorderPainted(false);
			j3.setActionCommand("eve");
			j3.addActionListener(lo);
		
		
		//ʵ����һ�����������ڴ����û���������
		lo=new LoginListener0716(qqf);
		
		
		

		//��Ϊ���������ֱ�ӽ�����Ϊ͸��
		jp.setOpaque(false);
		jp.add(j2);
		jp.add(j1);
		jp.add(j3);
		
		return jp;
	}

	// ����һ�����������ķ���
	public JPanel getWest() {

		// ʵ����һ�������
		JPanel jp = new JPanel();
		//��������ڵ����岼�ִ��Ҷ���
		jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
        ImageIcon i1=new ImageIcon("images/333.png");
		JButton j1=new JButton(i1);
		//��ά�밴ť
		j1.setPreferredSize(new Dimension(81,81));
		j1.setContentAreaFilled(false);
		j1.setOpaque(false);
		//ȥ����ť�߿�
		j1.setBorderPainted(false);
		
		
		jp.add(j1);
		

		//��Ϊ���������ֱ�ӽ�����Ϊ͸��
		
		jp.setOpaque(false);
		return jp;
	}

	// ����һ������Ϸ����ķ���
	public JPanel getNorth() {
		// ʵ����һ�������
		JPanel jp = new JPanel();
		// ������������
		jp.setPreferredSize(new Dimension(0, 130));
		jp.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		// ʵ����һ��ͼ�ζ���
		ImageIcon ii3 = new ImageIcon("images/3.png");
	    //����
		 j3=new JButton(ii3);
		 
		//�����ü�һ��������,ʵ�����л�ͼƬЧ��
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
		//��С��
		j4=new JButton(ii4);
		
		//���ڲ��ඨ��һ����С���İ�ť
		ActionListener q1=new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				qqf.setExtendedState(qqf.ICONIFIED); //��С��
				
			}
			
		};
		j4.addActionListener(q1);
		
		//����С����һ��������,ʵ�����л�ͼƬЧ��
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
		//�ر�
		

		j5=new JButton(ii5);
		//��������Ϊclose
		j5.setActionCommand("close");

		//�����������¶�����һ��������
		//��Ȼ�һ���֪��Ϊʲô������¶���һ��������
		LoginListener0716 ll = new LoginListener0716( qqf);
		//���رռ�һ��������
		j5.addActionListener(ll);
		//���رռ�һ��������,ʵ�����л�ͼƬЧ��
		MouseAdapter qb=new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				j5.setIcon(new ImageIcon("images/5(1).png"));
			}
			
			public void mouseExited(MouseEvent e) {
				j5.setIcon(new ImageIcon("images/5.png"));
			}
		};
		
		
	
	j5.addMouseListener(qb);
		
		//��Ϊ���������ֱ�ӽ�����Ϊ͸��
		jp.setOpaque(false);
		
		jp.add(j3);
		jp.add(j4);
		jp.add(j5);
		//����ť�������Ϸ�
	//	j5.setBounds(343, 0, 37, 15);
	//	j5.setOpaque(true);
		j3.setPreferredSize(new Dimension(28,15));
		j4.setPreferredSize(new Dimension(28,15));
		j5.setPreferredSize(new Dimension(35,15));
		
		//ȥ����ť�߿�
		j3.setBorderPainted(false);
		j4.setBorderPainted(false);
		j5.setBorderPainted(false);
		
		
		
		return jp;
	}

	// ����һ����ʼ��QQ����ķ���
	public void  Frame() {
		// ����һ���µĴ������
		 qqf = new JFrame();
		// ���ö���ĸ�������
		 qqf.setTitle("QQ");
		 qqf.setSize(378, 290);
//		 qqf.setLocation(500, 250);
		 qqf.setLocation(new Point(500,200));
		 qqf.setResizable(false);
		 qqf.setDefaultCloseOperation(2);
		
		
		//JFrame ��Ĭ�ϲ����Ǳ߿򲼾�

		// �������ı߿򲼾ֹ�����
		
		// ���Ϸ������ӵ�QQ������
		qqf.add(getNorth(), BorderLayout.NORTH);

		// ����ߵ����ӵ�QQ������
//		JPanel qqfw=getWest();
//		qqf.add(qqfw, BorderLayout.WEST);

		// ���м�����ӵ�QQ������
		qqf.add(getCenter(), BorderLayout.CENTER);

		// ���·������ӵ�QQ������
		qqf.add(getSouth(), BorderLayout.SOUTH);
		
		/**
		 * ��ΪJFrame����һ��ͼ��
		 * һ��ͼ���ַ�Ϊ�ö��
		 * Ȼ����Щͼ���ǲ�͸����
		 * �������ǵ�˼·����
		 * ��BackgrounPicture����JFrame��ײ�
		 * Ȼ���ٽ����һһ��Ϊ͸���ļ���
		 */
		
		//��QQ������뱳��
		ImageIcon im=new ImageIcon("images/13.png");
		//ת��Ϊһ����ǩ����
		JLabel JP=new JLabel(im);
		//�����������
		JP.setBounds(0, 0, im.getIconWidth(),im.getIconHeight());
		//��ͼƬ����JLayeredPane������ײ�
		qqf.getLayeredPane().add(JP,new Integer(Integer.MIN_VALUE));
		//��ȡContentPane��壨�����Ǹ���͸���ļһ
		JPanel opacity=(JPanel) qqf.getContentPane();
		//������Ϊ͸����
		opacity.setOpaque(false);
		
		//Ϊ��ģ�µĸ��� ȥ�������ı߿��
		qqf.setUndecorated(true);
		//�Խ�������������ʹ�����϶�
		qqf.addMouseMotionListener(lo);
		//ʵ�ֲ�ͬ�ķ���Ӧ�ü��벻ͬ�ļ�����
		qqf.addMouseListener(lo);
	

		qqf.setVisible(true);
		
	
		
	}



}
