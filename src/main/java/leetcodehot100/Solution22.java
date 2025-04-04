package leetcodehot100;


import java.util.ArrayList;
import java.util.List;

/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]

示例 2：
输入：n = 1
输出：["()"]
 */
// https://www.bilibili.com/video/BV16K411R7nm/?spm_id_from=333.337.search-card.all.click&vd_source=2259e5459a8cfd21bcf92bc46bf3beda
//根据思路进行构建一颗二叉树，左边是加左括号，右边是加右括号。
class Solution22 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backBuild("", 0, 0, n);
        return result;
    }

    //递归的时候需要满足两个条件才能进入递归
    //1、只有l<n的时候才能加左括号
    //2、只有l>r的时候才能加右括号
    //除此之外递归的都是非法的结果
    private void backBuild(String cur, int l, int r, int n) {
        if (cur.length() == 2 * n) {
            result.add(cur);
        }
        // 当左括号数量小于 n 时，可以添加左括号
        if (l < n) {
            backBuild(cur + "(", l + 1, r, n);
        }
        // 当右括号数量小于左括号数量时，可以添加右括号
        if (r < l) {
            backBuild(cur + ")", l, r + 1, n);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Solution22().generateParenthesis(3);
        System.out.println(strings);
    }
}
