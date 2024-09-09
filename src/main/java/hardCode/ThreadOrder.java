package hardCode;

public class ThreadOrder {
    static Object lock = new Object();
    //标识当前要打印的是哪个字符
    //比如cur=1时打印A，cur=2时打印B，cur=3时打印C
    static int cur = 1;

    static class CharPrinter implements Runnable {
        String charToPrint;
        int order;


        public CharPrinter(String charToPrint, int order) {
            this.charToPrint = charToPrint;
            this.order = order;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (cur != order) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(charToPrint);
                    cur++;//表示该打印下一个字符了
                    if (cur > 3) {
                        cur = 1;
                    }
                    lock.notifyAll();
                }
            }

        }
    }
}

class ThreadOrderMain {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadOrder.CharPrinter("A", 1));
        Thread thread2 = new Thread(new ThreadOrder.CharPrinter("B", 2));
        Thread thread3 = new Thread(new ThreadOrder.CharPrinter("C", 3));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


