package GobangV1_4_0517;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class chessListener extends MouseAdapter implements ActionListener {

	private Tree tree;
	private chessBoard cb;
	private fun fun;
	private int mode;
	private judge panduan;
	private boolean flag;

	public chessListener(chessBoard cb) {
		tree = new Tree();
		fun = new fun(cb);
		panduan = new judge();
		this.cb = cb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("保存到文件")) {// 保存到文件
			try {
				tree.saveFile();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (e.getActionCommand().equals("录入棋盘")) {
			tree.initRoot();
			clearBoard();
			data.ARRAY[7][7] = 1;
			cb.repaint();
			mode = 1;
		}
		if (e.getActionCommand().equals("人机对战")) {
			tree.initRoot();
			clearBoard();
			data.ARRAY[7][7] = 1;
			cb.repaint();
			cb.appendText("遍历为：");
			printTree(tree.getRoot());
			mode = 2;
			flag = true;
		}
		if(e.getActionCommand().equals("删除节点")){
			tree.deleteNode();
			System.out.println("hi");
		}
	}

	public void printTree(Node node) {
		if (node != null) {
			cb.appendText(node.getX() + " " + node.getY());
			printTree(node.getChild());
			printTree(node.getBrother());
		}
	}

	public void mousePressed(MouseEvent e) {
		int a = e.getX();
		int b = e.getY();
		for (int i = 0; i < data.COL; i++) {
			for (int j = 0; j < data.ROW; j++) {
				if (a < (35 + i * data.SIZE) && a > (5 + i * data.SIZE)
						&& b > (5 + j * data.SIZE) && b < (35 + j * data.SIZE)) {
					if (data.ARRAY[i][j] == 0) {
						if (mode == 1) {
							data.ARRAY[i][j] = (getchessNO() % 2 == 1) ? 2 : 1;
							panduan.judge1();
							cb.repaint();
							tree.addtoTree(i, j);
							cb.appendText("tempNode所在位置为\n"
									+ tree.getTempNode().getX() + " "
									+ tree.getTempNode().getY() + " "
									+ tree.getTempNode().getWhich());
						}
						if (mode == 2) {
							data.ARRAY[i][j] = (getchessNO() % 2 == 1) ? 2 : 1;
							panduan.judge1();
							//第一次下棋判断无关项
							if(getchessNO()==2&&((i<=4||i>=10)||(j<=4||j>=10)))
							{
								Node node = tree.getTempNode();
								node = node.getChild();
								// 假设棋谱一定有黑胜利的情况
								node = node.getChild();
								tree.setTempNode(node);
								i = node.getX();
								j = node.getY();
								data.ARRAY[i][j] = (getchessNO() % 2 == 1) ? 2 : 1;
								panduan.judge1();
								cb.repaint();
								cb.appendText("tempNode所在位置为\n" + tree.getTempNode().getX() + " "
										+ tree.getTempNode().getY() + " "
										+ tree.getTempNode().getWhich());
							}
							else{
							if (flag) {
								putdown(i, j);
							} else {
								fun.putdown();
							}}
						}
					}
				}
			}
		}

	}

	public void putdown(int i, int j) {
		Node node = tree.getTempNode();
		node = node.getChild();
		if (node == null) {
			flag = false;
			fun.putdown();
			return;
		}
	
		while (node.getX() != i || node.getY() != j) {
			if (node.getBrother() == null) {
				flag = false;
				fun.putdown();
				return;
			}
			node = node.getBrother();
		}
		// 假设棋谱一定有黑胜利的情况
		node = node.getChild();
		tree.setTempNode(node);
		i = node.getX();
		j = node.getY();
		if (data.ARRAY[i][j]!=0) {
			flag = false;
			fun.putdown();
			return;
		}
		data.ARRAY[i][j] = (getchessNO() % 2 == 1) ? 2 : 1;
		panduan.judge1();
		cb.repaint();
		cb.appendText("tempNode所在位置为\n" + tree.getTempNode().getX() + " "
				+ tree.getTempNode().getY() + " "
				+ tree.getTempNode().getWhich());
	}

	// 获得棋盘上的步数的个数，返回值为棋盘上棋子子的个数
	public int getchessNO() {
		int step = 0;
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				if (data.ARRAY[i][j] != 0) {
					step = step + 1;
				}
			}
		return step;
	}

	public void clearBoard() {
		for (int i = 0; i < data.COL; i++) {
			for (int j = 0; j < data.ROW; j++) {
				data.ARRAY[i][j] = 0;
			}
		}
	}
}