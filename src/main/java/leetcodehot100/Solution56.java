package leetcodehot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution56 {
    public int[][] merge(int[][] intervals) {
        // 新建结果集
        List<int[]> res = new LinkedList<>();
        // 按照左边界排序，这里需要注意自定义排序方法
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
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
        // 集合转换成数组
        return res.toArray(new int[res.size()][]);
    }
}