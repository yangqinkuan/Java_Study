package BIO;

import java.io.IOException;

import static BIO.BioServer.start;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			try {
				start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
		Thread.sleep(200);
		/*new Thread(()-> {
            Client.send("nihao");
        }).start();*/

	}
}
