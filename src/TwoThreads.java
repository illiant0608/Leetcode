import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//实现两个进程交替打印奇偶数
public class TwoThreads {
    private int start = 1;

    private volatile boolean flag = false;

    private final static Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        TwoThreads twoThreads = new TwoThreads();
        Thread t1 = new Thread(new OddNum(twoThreads));
        t1.setName("t1");
        Thread t2 = new Thread(new EvenNum(twoThreads));
        t2.setName("t2");

        t1.start();
        t2.start();
    }

    public static class EvenNum implements Runnable {
        private TwoThreads number;

        public EvenNum(TwoThreads number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 1000) {
                if (number.flag) {
                    try {
                        LOCK.lock();
                        System.out.println(Thread.currentThread().getName() + "+-+" + number.start);
                        number.start++;
                        number.flag = false;
                    } finally {
                        LOCK.unlock();
                    }
                }
            }
        }
    }


    public static class OddNum implements Runnable {
        private TwoThreads number;

        public OddNum(TwoThreads number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 1000) {
                if (!number.flag) {
                    try {
                        LOCK.lock();
                        System.out.println(Thread.currentThread().getName() + "+-+" + number.start);
                        number.start++;
                        number.flag = false;
                    } finally {
                        LOCK.unlock();
                    }
                }
            }
        }
    }
}
