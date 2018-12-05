package current.executor.cachaThreadPool;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {

        Thread thread = new Thread(r);
        thread.setName("定制线程池中的线程对象名称 "+ Math.random());
        return thread;
    }
}
