package cn.com;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author :
 * @version 创建时间：2017年11月14日 下午4:01:05 类说明
 */
public class ImageTest {

	public static void main(String[] args) throws IOException {
		 File f = new File("C:\\file\\hadoop.png");
		 InputStream input = new FileInputStream(f);
		 byte[] b = new byte[1024];
		 int temp = 0;
		 File f1 = new File("C:\\file\\hadoop1.png");
		 OutputStream out = new FileOutputStream(f1);
		 while ((temp = input.read(b, 0, 1000)) != -1) {
		 out.write(b, 0, temp);
		 }
		 input.close();
		 out.close();
//		test();
	}

	private static void test() throws IOException {
		File _file = new File("C:\\file\\hadoop.png"); // 读入文件
		Image src = ImageIO.read(_file); // 构造Image对象
		int wideth = src.getWidth(null); // 得到源图宽
		int height = src.getHeight(null); // 得到源图长

		/*
		 * //绘制缩小后的图 BufferedImage tag = new
		 * BufferedImage(wideth/2,height/2,BufferedImage.TYPE_INT_RGB);
		 * tag.getGraphics().drawImage(src,0,0,wideth/2,height/2,null);
		 * //绘制缩小后的图
		 */

		BufferedImage tag = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(src, 0, 0, wideth, height, null);
		FileOutputStream out = new FileOutputStream("C:\\file\\hadoop2.png"); // 输出到文件流
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(tag); // JPEG编码
		out.close();
	}

}
