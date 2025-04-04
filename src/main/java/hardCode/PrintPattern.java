package hardCode;

public class PrintPattern {
    /*
    打印
-*-
*-*
-*-
    */
    public static void printPattern(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("-");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 2;
        printPattern(n);
    }
}