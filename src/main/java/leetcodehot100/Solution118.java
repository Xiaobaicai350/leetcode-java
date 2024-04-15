package leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/*
1
11
121
1331
*/

/**
 * 杨辉三角
 * 只需要记住两个：
 * 1.首尾都是1
 * 2.其他位置的值=该位置的上一个位置的值+该位置的上一个位置的左边的位置的值
 */
class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                //当遇见首尾就赋值为1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {//其他位置由该位置的上一个位置和上一个位置前一个位置计算出来
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}