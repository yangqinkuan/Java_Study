/**
 * FileName: Test
 * Author:   yangqinkuan
 * Date:     2019-12-24 9:00
 * Description:
 */

package JUC.Semaphore;

import java.util.concurrent.Semaphore;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(20);
        semaphore.acquire(2);
        semaphore.release();
    }
}
