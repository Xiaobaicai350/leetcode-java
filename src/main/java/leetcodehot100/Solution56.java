package leetcodehot100;

import java.util.*;

/*
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */

/**
 * 核心思想是用下一个的左边界判断目前的最大右边界，判断是否重叠
 */
class Solution56 {
    public int[][] merge(int[][] intervals) {
        //自定义结果集
        ArrayList<int[]> res = new ArrayList<>();
        //自定义排序器，按照左边排序，排序的对象是一维数组
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 初始化左边界
        int left = intervals[0][0];
        // 初始化右边界
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果下一个的左边界大于最大右边界，说明没有重叠
            if (intervals[i][0] > right) {
                // 加入区间 并且更新left和右边界
                res.add(new int[] { left, right });
                //更新左边界和右边界
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                // 否则就是重叠的情况了
                // 更新最大右边界
                right = Math.max(right, intervals[i][1]);
            }
        }
        // 最后一个要手动加入到集合中
        res.add(new int[] { left, right });
        //集合转换成数组
        return (int[][]) res.toArray();
    }
}