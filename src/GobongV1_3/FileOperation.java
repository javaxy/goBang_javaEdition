package GobongV1_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * 实现文件的保存和读取
 */
public class FileOperation {

	/**
	 * 将队列存入文件
	 * 
	 * @param Board
	 */
	public static void saveFile(ArrayList<Board> Board) {
		try {
			File file = new File("index.wzq");
			if (!file.exists()) {
				file.createNewFile();
			}
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(Board);
			oos.close();
			os.close();
			System.out.println("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得文件中的队列
	 * 
	 * @return ArrayList对象
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Board> readFile() {
		try {
			File file = new File("index.wzq");
			if (file.exists()) {
				InputStream is = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(is);
				ArrayList<Board> Board = (ArrayList<Board>) ois.readObject();
				ois.close();
				is.close();
				return Board;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void addBoard(Board board) {
		ArrayList<Board> b = readFile();//将原来的文件数据读取出来
		if (b == null) {
			b = new ArrayList<Board>();
		}
		b.add(board);//将新的棋谱写入序列
		saveFile(b);//再次将文件读出
	}

	
}
