package hardCode;

public class InterruptFullUsageDemo {

    // 中断处于阻塞状态（如 sleep、wait 等）的线程
    public static void interruptBlockedThread() {
        Thread blockedThread = new Thread(() -> {
            try {
                System.out.println("阻塞线程开始休眠");
                Thread.sleep(5000); // 线程休眠 5 秒
                System.out.println("阻塞线程休眠结束");
            } catch (InterruptedException e) {
                System.out.println("阻塞线程被中断: " + e.getMessage());
            }
        });
        blockedThread.start();

        // 主线程等待 1 秒后中断阻塞线程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        blockedThread.interrupt();
    }

    // 中断正常运行的线程
    public static void interruptNormalThread() {
        Thread normalThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("正常线程正在运行");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("正常线程被中断，退出循环: " + e.getMessage());
                    // 重新设置中断标志
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("正常线程停止运行");
        });
        normalThread.start();

        // 主线程等待 2 秒后中断正常线程
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        normalThread.interrupt();
    }

    // 检查线程是否被中断
    public static void checkThreadInterruption() {
        Thread checkingThread = new Thread(() -> {
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("检查线程检测到中断，清除中断标志并退出");
                    break;
                }
                System.out.println("检查线程正在运行");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("检查线程在休眠时被中断，设置中断标志");
                    Thread.currentThread().interrupt();
                }
            }
        });
        checkingThread.start();

        // 主线程等待 2 秒后中断检查线程
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkingThread.interrupt();
    }

    public static void main(String[] args) {
        System.out.println("------ 开始测试中断阻塞线程 ------");
        interruptBlockedThread();

        try {
            // 等待阻塞线程示例执行完，方便观察结果
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------ 开始测试中断正常运行线程 ------");
        interruptNormalThread();

        try {
            // 等待正常线程示例执行完，方便观察结果
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------ 开始测试检查线程中断状态 ------");
        checkThreadInterruption();
    }
}