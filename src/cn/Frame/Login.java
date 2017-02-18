package cn.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Login();
	}

	public Login() {
		this.setTitle("��ѡ����Ϸģʽ");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Font font = new Font("΢���ź�", Font.BOLD, 15);
		JButton war = new JButton("�˻���ս��ʾ");
		war.setFont(font);
		war.setPreferredSize(new Dimension(0, 56));
		this.add(war, BorderLayout.NORTH);

		JButton ai = new JButton("������ս��ʾ");
		ai.setFont(font);
		this.add(ai, BorderLayout.CENTER);

		JButton soc = new JButton("Զ�̶�ս��ʾ");
		soc.setFont(font);
		soc.setPreferredSize(new Dimension(0, 56));
		this.add(soc, BorderLayout.SOUTH);

		this.setVisible(true);
	}
}
