package current.Semaphore;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreListPool {

    private int poolMaxSize = 3;
    private int semaphorePermits = 5;
    private ArrayList<String> list = new ArrayList<>();
    private Semaphore semaphore = new Semaphore(semaphorePermits);
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public SemaphoreListPool() {

        super();
        for (int i = 0; i < poolMaxSize; i++) {

            list.add(" semaphore . . 字符串池 " + i);
        }
    }

    public String get(){

        String getString = null;

        try {
            semaphore.acquire();
            lock.lock();
            while (list.size() == 0){

                condition.await();
            }
            getString = list.remove(0);
            lock.unlock();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getString;
    }

    public void  put(String stringValue){

        lock.lock();
        list.add(stringValue);
        condition.signalAll();
        lock.unlock();

        semaphore.release();
    }
}