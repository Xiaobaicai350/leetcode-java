package writtenExamination.小米笔试1012;

import java.util.ArrayList;
import java.util.Scanner;

/*
5 3
1 2 1
3 2 0
5 4 0

2 1 3 4 5
3 2 1 4 5
3 2 1 5 4

*/

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[][] ints = new int[q][3];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 3; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(i);
        }
        for (int i = 0; i < q; i++) {
            int qu = ints[i][0];
            int mu = ints[i][1];
            int op = ints[i][2];
            //从集合中删除获取的数字
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == qu) {
                    list.remove(j);
                    break;
                }
            }
            //拿到集合中取的数字的下标
            int index = getNumsIndex(list, mu);
            if (op == 0) {
                //插到前面
                list.add(index, qu);
            } else {
                list.add(index + 1, qu);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static int getNumsIndex(ArrayList<Integer> list, int mu) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == mu) {
                return i;
            }
        }
        return -1;
    }


}