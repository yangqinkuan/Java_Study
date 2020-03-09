public class Volatile_Test {
    /**
     * Volatile 作用
     * 1、保证volatile_test的可见性，赋值之后能迅速被别的线程给知道
     * 2、防止指令重排序 volatile_test = new Volatile_Test()存在两个动作，
     *     (1)初始化物理内存中的值
     *     (2)分配物理内存，并将地址赋值给volatileTest
     *     volatile关键字可以保证这两步按正确的顺序执行
     */


    private static volatile Volatile_Test volatile_test;
    private Volatile_Test(){}
    public static Volatile_Test getVolatile_test(){
        if(volatile_test==null){
            synchronized (Volatile_Test.class){
                if(volatile_test==null){
                    volatile_test = new Volatile_Test();
                }
            }
        }
        return volatile_test;
    }
}
