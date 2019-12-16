/**
 * FileName: Test
 * Author:   yangqinkuan
 * Date:     2019-12-16 8:50
 * Description:
 */

package JUC.CAS;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    private static final long valueOffset;
    private static final Unsafe unsafe;
    private volatile int value = 1;
    static {
        try {
            Field field=Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe=(Unsafe)field.get(null);
            valueOffset = unsafe.objectFieldOffset
                    (Test.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }
    public final int getAndIncrement() {
        return unsafe.getAndAddInt(this, valueOffset, 1);
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.value = 2;
        test.getAndIncrement();
    }
}
