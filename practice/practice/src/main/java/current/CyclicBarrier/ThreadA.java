package current.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadA extends Thread {

    private CyclicBarrier cbRef;

    public ThreadA(CyclicBarrier cbRef) {
        this.cbRef = cbRef;
    }

    @Override
    public void run() {


        try {

                Thread.sleep((int)(Math.random()*1000));
                System.out.println(Thread.currentThread().getName() + "到了 ！" + System.currentTimeMillis());


                cbRef.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
