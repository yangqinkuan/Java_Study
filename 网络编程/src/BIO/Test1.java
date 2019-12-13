/**
 * FileName: Test1
 * Author:   yangqinkuan
 * Date:     2019-12-11 10:35
 * Description:
 */

package BIO;

import java.io.IOException;

import static BIO.BioServer.start;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {

		new Thread(()-> {
            Client.send("nihao");
        }).start();

    }
}
