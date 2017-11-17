package cn.com.pip;

import java.io.IOException;
import java.io.PipedInputStream;

class Receive implements Runnable {

	private PipedInputStream pis;// 管道输入流

	public Receive() {
		pis = new PipedInputStream();
	}

	@Override
	public void run() {
		byte[] b = new byte[1024];
		int len = 0;
		try {
			len = pis.read(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			pis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(new String(b, 0, len));
	}

	public PipedInputStream getPis() {
		return pis;
	}
}