/**
 * FileName: Test
 * Author:   yangqinkuan
 * Date:     2019-12-18 16:00
 * Description:
 */

package JUC.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        cyclicBarrier.await();
        cyclicBarrier.reset();
    }
}
