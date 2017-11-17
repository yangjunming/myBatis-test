package cn.com;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * @author :
 * @version 创建时间：2017年11月14日 下午2:10:48 类说明
 */
public class IOTest {

	public static void main(String[] arg) throws IOException {
		// ByteIOTest();
//		CharIOTest();
		test();
	}

	private static void test() throws IOException {
		String str = "HELLO WORLD";
		InputStream input = new ByteArrayInputStream(str.getBytes());
		OutputStream out = new ByteArrayOutputStream();
		int temp = 0;
		while ((temp = input.read()) != -1) {
			out.write(Character.toLowerCase(temp));
		}
		input.close();
		out.close();
		System.out.println(out.toString());
	}

	private static void CharIOTest() throws IOException {
		File f = new File("C:\\file\\test.txt");
		Writer out = new FileWriter(f);
		// Writer out1=new OutputStreamWriter(new FileOutputStream(f));
		// Reader input=new InputStreamReader(new FileInputStream(f));
		String str = "Hahaha u are sb";
		out.write(str);
		out.close();
		Reader re = new FileReader(f);
		char[] c = new char[1024];
		int temp = 0;
		int len = 0;
		while ((temp = re.read()) != -1) {
			c[len] = (char) temp;
			len++;
		}
		re.close();
		System.out.println(new String(c, 0, len));
	}

	private static void ByteIOTest() throws IOException {
		File f = new File("C:\\file\\test.txt");
		OutputStream out = new FileOutputStream(f);
		String s = "Hello World";
		byte[] b = s.getBytes();
		out.write(b);
		out.close();
		OutputStream out1 = new FileOutputStream(f, true);
		out1.write(b);
		out1.close();
		InputStream in = new FileInputStream(f);
		byte[] b1 = new byte[1024];
		int temp = 0;
		int len = 0;
		while ((temp = in.read()) != -1) {
			b1[len] = (byte) temp;
			len++;
		}
		in.close();
		System.out.println(new String(b1, 0, len));
	}

}
