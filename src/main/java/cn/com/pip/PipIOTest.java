package cn.com.pip;

import java.io.IOException;

/**
 * @author :
 * @version 创建时间：2017年11月15日 上午10:05:51 类说明
 */
public class PipIOTest {

	public static void main(String[] args) {
		Send send = new Send();
		Receive receive = new Receive();
		try {
			send.getPos().connect(receive.getPis());// 连接管道
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(send).start();// 启动线程
		new Thread(receive).start();// 启动线程
	}

}
