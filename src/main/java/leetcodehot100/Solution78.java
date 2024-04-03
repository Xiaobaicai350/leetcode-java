package leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题可以抽象出一颗树，向一边走就是不要这个值，向另一边走就是要这个值
 */
class Solution78 {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        //从下标为0开始
        recur(0, nums, new ArrayList<>());
        return res;
    }

    /**
     *
     * @param i 目前到达了树的第几层
     * @param nums
     * @param chosen
     */
    private void recur(int i, int[] nums, List<Integer> chosen) {
        //如果到达树的末尾了，就可以开始返回了
        if (i == nums.length) {
            //拷贝临时的结果数组
            List<Integer> tmp = new ArrayList<>(chosen);
            res.add(tmp);
        } else {
            //选这个的逻辑，把这个树加入到临时的结果数组中
            chosen.add(nums[i]);
            recur(i + 1, nums, chosen);
            //不选这个的逻辑
            chosen.remove(chosen.size() - 1);
            recur(i + 1, nums, chosen);
        }
    }
}