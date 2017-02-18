package cn.Frame;

/**
 * JRadioButton ��ѡ��ť
 */
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 * ���������ǳ����� MouseAdapter��д��mouselistener�е����з����������㲻��ȫ��ʵ�� ��ֻ��Ҫ��д������Ҫ�ķ���
 * 
 * @author Administrator
 * 
 */
public class LoginListener0716 extends MouseAdapter implements ActionListener {
	private String pass, name;
	private JPasswordField jp1;
	private JComboBox co;
	private JFrame qqf;
	// private JButton j5;
	Point P;
	Point orgin = new Point();

	// �õ��رհ�ť��λ��
	// Point pj=j5.getLocation();

	// ��д���Ĺ��췽�������ڴ��ݵ�½������û����������ֵ
	public LoginListener0716(JFrame qqf) {
		this.qqf = qqf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// �ж϶���ִ�еĶ����Ƿ���JButton��ʵ������һ������
		if (e.getSource() instanceof JButton) {
			// System.out.println("fffffffff");
			// ��ӡ����ť������
			System.out.println(e.getActionCommand());
			// �жϰ�ť����������
			if (e.getActionCommand().equals("close")) {
				System.exit(0);
			}

			// ����õ���������ͨ��
			if (e.getActionCommand().equals("pvp")) {
				new startServer().start();
				new startClient().start();
			}

			if (e.getActionCommand().equals("pve")) {
                  new GobangV1_4_0517.chessBoard().initUI();
			}
			if (e.getActionCommand().equals("eve")) {
				cn.AI2AI.chessBoard eve = new cn.AI2AI.chessBoard();
				eve.initUI();
			}
		}
	}

	// �õ���ԭʼ������
	public void mousePressed(MouseEvent e) {
		orgin.x = e.getX();
		orgin.y = e.getY();
		// System.out.print(orgin.x); System.out.println(orgin.y);
	}

	// ����һ���϶��¼�
	public void mouseDragged(MouseEvent e) {
		// ��ȡ����λ��
		Point P1 = qqf.getLocation();
		// �����������λ��
		qqf.setLocation(P1.x + e.getX() - orgin.x, P1.y + e.getY() - orgin.y);
		// qqf.setLocation(e.getX(),e.getY());
	}
}

class startServer extends Thread {

	public void run() {
		new cn.Server.ServerStart(9999);
	}

}

class startClient extends Thread{
	public void run(){
		try {
			Thread.sleep(1000);
			new cn.Client.chessBoard().initUI();
			Thread.sleep(1000);
			new cn.Client.chessBoard().initUI();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}