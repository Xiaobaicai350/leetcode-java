package hardCode;

import java.util.concurrent.atomic.AtomicInteger;

/*
AtomicInteger是Java中的一个类，用于实现原子性的整数操作。CAS是一种无锁的算法，全称为Compare And Swap，即比较并交换。
CAS操作需要三个参数：一个内存地址，一个期望值，一个新值。如果内存地址的值与期望值相等，就将其更新为新值，否则不做任何操作。
我们可以使用一个AtomicInteger对象来表示当前应该打印哪个字母，初始值为0。
当state为0时，表示轮到A线程打印；
当state为1时，表示轮到B线程打印；
当state为2时，表示轮到C线程打印。
每个线程在打印完字母后，需要使用CAS操作将state加1，并对3取模，以便循环。
 */
public class PrintABC4 {
    // 共享变量，表示当前应该打印哪个字母
    private static AtomicInteger state = new AtomicInteger(0);

    // 打印任务类
    static class PrintTask implements Runnable {
        private final char toPrint;
        private final int targetState;

        public PrintTask(char toPrint, int targetState) {
            this.toPrint = toPrint;
            this.targetState = targetState;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                // 使用CAS操作确保原子性地更新状态
                int currentState = state.get();
                if (currentState % 3 == targetState - 1) {
                    System.out.println(toPrint);
                    // 尝试将状态更新为下一个线程的targetState
                    state.compareAndSet(currentState, (currentState + 1) % 3);
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建三个打印任务
        Runnable printA = new PrintTask('A', 1);
        Runnable printB = new PrintTask('B', 2);
        Runnable printC = new PrintTask('C', 3);

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

