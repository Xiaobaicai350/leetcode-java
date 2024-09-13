package writtenExamination.途虎养车0912;

import java.util.ArrayList;

public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型 服务总数
     * @param points int整型一维数组 服务对应积分
     * @param dependencies int整型二维数组 服务依赖
     * @param k int整型 可买服务数量
     * @return int整型
     */
    //   6,[8, 3, 7, 5, 6, 2],[[1, 0], [2, 1], [3, 1], [4, 2]],3
    public int maxPoints (int n, int[] points, int[][] dependencies, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            list.add(i);
        }
        // write code here
        for (int i = 0; i <dependencies.length ; i++) {
            list.remove(dependencies[i][0]);
        }
        int res=0;
        //现在list中都是根下标
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < k; j++) {
                Integer integer = list.get(i);
                ArrayList<Integer> list1 = new ArrayList<>();
                for (int l = 0; l < dependencies.length; l++) {
                    if(integer.equals(dependencies[l][1])){
                        list1.add(l);
                    }
                }
                int max=0;
                for (int l = 0; l < list1.size(); l++) {
                    if(list1.get(l)>max){
                        max=list1.get(l);
                    }
                }
            }
        }
        return 0;
    }
}
