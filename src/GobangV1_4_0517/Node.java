package GobangV1_4_0517;

public class Node implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Node brother;
	private Node child;
	private int x;
	private int y;
	private int which;

	public Node() {
	}

	public Node(Node brother, Node child) {
		this.brother = brother;
		this.child = child;
	}

	public Node(Node brother, Node child, int x, int y, int which) {
		this.brother = brother;
		this.child = child;
		this.x = x;
		this.y = y;
		this.which = which;
	}

	public Node getBrother() {
		return brother;
	}

	public void setBrother(Node brother) {
		this.brother = brother;
	}

	public Node getChild() {
		return child;
	}

	public void setChild(Node child) {
		this.child = child;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWhich() {
		return which;
	}

	public void setWhich(int which) {
		this.which = which;
	}

}
