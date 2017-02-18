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
 * ʵ���ļ��ı���Ͷ�ȡ
 */
public class FileOperation {

	/**
	 * �����д����ļ�
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
			System.out.println("����ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����ļ��еĶ���
	 * 
	 * @return ArrayList����
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
		ArrayList<Board> b = readFile();//��ԭ�����ļ����ݶ�ȡ����
		if (b == null) {
			b = new ArrayList<Board>();
		}
		b.add(board);//���µ�����д������
		saveFile(b);//�ٴν��ļ�����
	}

	
}
