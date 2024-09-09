package hardCode;

import java.util.concurrent.Semaphore;

/*
Semaphore是Java中的一个类，用于实现信号量机制。信号量是一种计数器，用于控制对共享资源的访问。
Semaphore可以创建多个信号量对象，每个信号量对象可以绑定一个或多个线程，实现对不同线程的精确控制。
我们可以使用三个Semaphore对象，分别初始化为1、0、0，表示A、B、C三个线程的初始许可数。
每个线程在打印字母之前，需要调用对应的Semaphore对象的acquire方法，获取许可。每个线程在打印字母之后，需要调用下一个Semaphore对象的release方法，释放许可。
 */
public class PrintABC3 {

    // 三个信号量对象，分别表示A、B、C三个线程的初始许可数
    private static final Semaphore A = new Semaphore(1);
    private static final Semaphore B = new Semaphore(0);
    private static final Semaphore C = new Semaphore(0);

    // 打印任务类
    static class PrintTask implements Runnable {
        private final Semaphore current;
        private final Semaphore next;
        private final char toPrint;

        public PrintTask(Semaphore current, Semaphore next, char toPrint) {
            this.current = current;
            this.next = next;
            this.toPrint = toPrint;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    //当使用Semaphore类时，acquire方法用于获取一个许可。
                    // 如果信号量当前有可用的许可，则立即返回并减少一个许可。
                    // 如果信号量中没有可用的许可，则当前线程将阻塞直到有许可可用。
                    current.acquire();
                    System.out.println(toPrint);
                    //release方法（通常命名为release）用于增加信号量的许可数，这通常发生在当前线程完成对共享资源的访问后。增加许可数后，其他正在等待许可的线程可以获取许可并继续执行。
                    next.release();
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
