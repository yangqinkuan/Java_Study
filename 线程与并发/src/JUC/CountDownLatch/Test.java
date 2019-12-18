/**
 * FileName: Test
 * Author:   yangqinkuan
 * Date:     2019-12-18 14:31
 * Description:
 */

package JUC.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        countDownLatch.countDown();
        countDownLatch.await();

    }
}
