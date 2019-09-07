import java.io.*;

public class File2And {
	public void and() throws Exception {

		BufferedInputStream input1 = new BufferedInputStream(
				new FileInputStream(new File("E:\\misc\\1.mp3"))); // 路径格式：D://java//1.MP3
		BufferedInputStream input2 = new BufferedInputStream(
				new FileInputStream(new File("E:\\misc\\2.mp3")));
		BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream(new File("E:\\misc\\3.mp3")));
		byte[] byt = new byte[1024];
		int len;
		while ((len = input1.read(byt)) != -1) {
			out.write(byt, 0, byt.length);
			out.flush();

		}
		while ((len = input2.read(byt)) != -1) {
			out.write(byt, 0, byt.length);
			out.flush();
		}
		input1.close();
		input2.close();
		out.close();
	}

	public static void main(String[] args) throws Exception {
		new File2And().and();
	}
}
