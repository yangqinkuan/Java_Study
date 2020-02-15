/**
 * FileName: TestFutrueTask
 * Author:   yangqinkuan
 * Date:     2019-12-16 10:16
 * Description:
 */

package JUC.futureTask;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestFutrueTask {

    public void test(){
        Lock lock = new ReentrantLock();

        Condition read = lock.newCondition();
        Condition write = lock.newCondition();
        lock.lock();
    }


    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        UpdateCallable utask = new UpdateCallable(6000);
        InsertCallable itask = new InsertCallable(12000);
        FutureTask<Boolean> UfutureTask = new FutureTask<Boolean>(utask);
        FutureTask<Boolean> IfutureTask = new FutureTask<Boolean>(itask);

        threadPool.submit(UfutureTask);
        threadPool.submit(IfutureTask);
        try {
            System.out.println("wait on 1tine");
            threadPool.shutdown();//直到线程执行完毕
            System.out.println("wait on 2tine");
            boolean flag = true;
            while(flag){
                System.out.println("wait on 3tine");
                if(UfutureTask.get()&&IfutureTask.get()){
                    flag = false;
                    System.out.println("is over!");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

 class InsertCallable implements Callable<Boolean> {
    private Integer time = 3000;

    public InsertCallable(Integer time) {
        super();
        this.time = time;
    }

    public Boolean call() throws Exception {
        System.out.println("InsertCallable sleep time:" + time);
        Thread.sleep(time);
        System.out.println("InsertCallable up");
        return true;
    }
}


 class UpdateCallable implements Callable<Boolean> {
    private Integer time = 3000;

    public UpdateCallable(Integer time) {
        super();
        this.time = time;
    }

    public Boolean call() throws Exception {
        System.out.println("UpdateCallable sleep time:" + time);
        Thread.sleep(time);
        System.out.println("UpdateCallable up");
        return true;
    } }