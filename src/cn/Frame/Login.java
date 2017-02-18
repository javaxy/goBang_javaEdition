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
		this.setTitle("请选择游戏模式");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Font font = new Font("微软雅黑", Font.BOLD, 15);
		JButton war = new JButton("人机对战演示");
		war.setFont(font);
		war.setPreferredSize(new Dimension(0, 56));
		this.add(war, BorderLayout.NORTH);

		JButton ai = new JButton("机机对战演示");
		ai.setFont(font);
		this.add(ai, BorderLayout.CENTER);

		JButton soc = new JButton("远程对战演示");
		soc.setFont(font);
		soc.setPreferredSize(new Dimension(0, 56));
		this.add(soc, BorderLayout.SOUTH);

		this.setVisible(true);
	}
}
