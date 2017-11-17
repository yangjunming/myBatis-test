package cn.com.pip;

import java.io.IOException;
import java.io.PipedOutputStream;

class Send implements Runnable {

	private PipedOutputStream pos;// 管道输出流

	public Send() {
		pos = new PipedOutputStream();
	}

	@Override
	public void run() {
		String str = "Hello World!";
		try {
			pos.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			pos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PipedOutputStream getPos() {
		return pos;
	}
}