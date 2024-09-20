package writtenExamination.五八同城0920;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param firstList  int整型二维数组
     * @param secondList int整型二维数组
     * @return int整型二维数组
     */
    //[[0,3],[5,9],[11,13]],[[2,6],[8,10]]
    //[[2,3],[5,6],[8,9]]
    public int[][] findIntersection1(int[][] firstList, int[][] secondList) {
        // write code here
        if (firstList == null || secondList == null) {
            return null;
        }
        int firstLength = firstList.length;
        int secondLength = secondList.length;
        if (firstLength == 0 || secondLength == 0) {
            return null;
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < firstLength; i++) {
            list.add(firstList[i]);
        }
        for (int i = 0; i < secondLength; i++) {
            list.add(secondList[i]);
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            int[] temp = list.get(i);
            if (temp[0] <= end) {
                //如果在范围中
                end = Math.min(end, temp[1]);

                result.add(new ArrayList<>(Arrays.asList(temp[0], end)));
            }
                start = temp[0];
                end = temp[1];
        }
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i]= new int[]{result.get(i).get(0), result.get(i).get(1)};
        }
        return res;
    }
    public int[][] findIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || secondList == null || firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(firstList, (a, b) -> a[0] - b[0]);
        Arrays.sort(secondList, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);

            if (low <= high) {
                result.add(new int[]{low, high});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intersection = new Solution1().findIntersection(new int[][]{{0, 3}, {5, 9}, {11, 13}}, new int[][]{{2, 6}, {8, 10}});
        System.out.println();
    }
}