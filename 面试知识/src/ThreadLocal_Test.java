public class ThreadLocal_Test {
    static ThreadLocal<String> threadLocalA = new ThreadLocal();
    public static void main(String[] args) {
        new Thread(new MyRunnable("第一个线程")).start();
        new Thread(new MyRunnable("第二个线程")).start();
    }


}
class MyRunnable implements Runnable{

    private String name;

    public MyRunnable(String name){
        this.name = name;
    }

    @Override
    public void run() {
        ThreadLocal_Test.threadLocalA.set(this.name);
        System.out.println(this.name+"="+ThreadLocal_Test.threadLocalA.get());
    }
}
