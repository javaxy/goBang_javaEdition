package GobangV1_4_0517;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Tree {

	private Node root;// 根节点

	public Tree() {
		if (!readFile()) {
			root = new Node(null, null, 7, 7, 1);// 第一步下在中心位置
			System.out.println("读取文件失败");
		}
		this.initRoot();
	}

	/**
	 * 遍历树
	 * 
	 * @param node
	 *            根节点
	 */
	public void printTree(Node node) {
		if (node != null) {
			System.out.println(node.getX() + " " + node.getY());
			printTree(node.getChild());
			printTree(node.getBrother());
		}
	}

	private Node tempNode;// 当前位置所在节点

	public void deleteNode(){
		tempNode.setChild(null);
	
	}
	
	
	public void addtoTree(int i, int j) {
		if (tempNode.getChild() == null) {// 如果孩子节点为空
			Node child = new Node(null, null, i, j, data.ARRAY[i][j]);
			tempNode.setChild(child);
			tempNode = tempNode.getChild();
			return;
		}
		tempNode = tempNode.getChild();
		while (tempNode.getX() != i || tempNode.getY() != j) {
			if (tempNode.getBrother() == null) {
				Node brother = new Node(null, null, i, j, data.ARRAY[i][j]);
				tempNode.setBrother(brother);
				tempNode = tempNode.getBrother();
				break;
			}
			tempNode = tempNode.getBrother();
		}
	}

	public boolean readFile() {
		try {
			File file = new File("save.txt");
			FileInputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			root = (Node) ois.readObject();
			ois.close();
			is.close();
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return false;
	}

	public void saveFile() throws Exception {
		File file = new File("save.txt");
		FileOutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(root);
		oos.close();
		os.close();
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void initRoot() {
		tempNode = root;
	}

	public Node getTempNode() {
		return tempNode;
	}

	public void setTempNode(Node tempNode) {
		this.tempNode = tempNode;
	}

}
