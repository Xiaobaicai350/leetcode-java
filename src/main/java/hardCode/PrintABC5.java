package hardCode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
CyclicBarrier是Java中的一个类，用于实现多个线程之间的屏障。
CyclicBarrier可以创建一个屏障对象，指定一个参与等待线程数和一个到达屏障点时的动作。
当所有线程都到达屏障点时，会执行屏障动作，然后继续执行各自的任务。CyclicBarrier可以重复使用，即当所有线程都通过一次屏障后，可以再次等待所有线程到达下一次屏障。

我们可以使用一个CyclicBarrier对象，指定三个线程为参与等待数，以及一个打印字母的到达屏障点动作。
每个线程在执行完自己的任务后，需要调用CyclicBarrier对象的await方法，等待其他线程到达屏障点。
当所有线程都到达屏障点时，会执行打印字母的屏障动作，并根据state的值判断应该打印哪个字母。
 */
public class PrintABC5 {
    // 共享变量，表示当前应该打印哪个字母
    private static int state = 0;

    // 参与线程数量
    private static int threadNum = 3;

    // 循环屏障，指定三个线程为屏障点，以及一个打印字母的屏障动作
    //当所有线程都到达屏障点时，会执行屏障动作
    private static final CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {//到达屏障点时的动作
        @Override
        public void run() {
            // 根据state的值判断应该打印哪个字母
            switch (state) {
                case 0:
                    System.out.println("A");
                    break;
                case 1:
                    System.out.println("B");
                    break;
                case 2:
                    System.out.println("C");
                    break;
            }
            // 修改状态
            state = (state + 1) % 3;
        }
    });

    public static void main(String[] args) {
        // 创建三个线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < threadNum * 10; i++) {
                        //执行自己的任务
                        //。。。。
                        // 等待其他线程到达屏障点
                        barrier.await();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < threadNum * 10; i++) {
                        // 等待其他线程到达屏障点
                        barrier.await();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < threadNum * 10; i++) {
                        // 等待其他线程到达屏障点
                        barrier.await();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动三个线程
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
