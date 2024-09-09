package hardCode;

public class PrintABC1 {
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
                            //wait方法会让当前线程释放锁，并进入等待状态，直到被其他线程唤醒。
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
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

class PrintABC1Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintABC1.CharPrinter("A", 1));
        Thread thread2 = new Thread(new PrintABC1.CharPrinter("B", 2));
        Thread thread3 = new Thread(new PrintABC1.CharPrinter("C", 3));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


