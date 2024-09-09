package hardCode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
ReentrantLock可以创建多个Condition对象，每个Condition对象可以绑定一个或多个线程，实现对不同线程的精确控制。
我们可以使用一个ReentrantLock对象作为锁，同时创建三个Condition对象，分别绑定A、B、C三个线程。
每个线程在打印字母之前，需要调用对应的Condition对象的await方法，等待被唤醒。
每个线程在打印字母之后，需要调用下一个Condition对象的signal方法，唤醒下一个线程。
 */
public class PrintABC2 {
    // 共享变量，表示当前应该打印哪个字母
    private static int state = 0;

    private static final ReentrantLock lock = new ReentrantLock();

    // 三个条件对象，分别绑定A、B、C三个线程
    private static final Condition A = lock.newCondition();
    private static final Condition B = lock.newCondition();
    private static final Condition C = lock.newCondition();

    // 打印任务类
    static class PrintTask implements Runnable {
        //当前等待室的线程
        private final Condition current;
        //要打印下一个字母的线程
        private final Condition next;
        //标识要打印的字母
        private final char toPrint;

        public PrintTask(Condition current, Condition next, char toPrint) {
            this.current = current;
            this.next = next;
            this.toPrint = toPrint;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    lock.lock();
                    try {
                        while (state % 3 != (toPrint - 'A')) {
                            current.await();
                        }
                        System.out.println(toPrint);
                        state++;
                        //唤醒下一个等待室的线程
                        next.signal();
                    } finally {
                        lock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 创建三个打印任务
        Runnable printA = new PrintTask(A, B, 'A');
        Runnable printB = new PrintTask(B, C, 'B');
        Runnable printC = new PrintTask(C, A, 'C');

        // 创建三个线程
        Thread threadA = new Thread(printA);
        Thread threadB = new Thread(printB);
        Thread threadC = new Thread(printC);

        // 启动三个线程
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
