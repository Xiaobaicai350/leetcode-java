package leetcodehot100;


import java.util.ArrayList;
import java.util.List;

// https://www.bilibili.com/video/BV16K411R7nm/?spm_id_from=333.337.search-card.all.click&vd_source=2259e5459a8cfd21bcf92bc46bf3beda
//根据思路进行构建一颗二叉树，左边是加左括号，右边是加右括号。
class Solution22 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        recursive("", 0, 0, n);
        return result;
    }

    // str代表当前递归树的结果path
    // l代表当前的左括号的数量
    // r代表当前的右括号的数量
    // n代表题目给的括号的对数
    private void recursive(String str, int l, int r, int n) {
        //当 左括号数量 等于 右括号数量等于 题目给的括号的对数 的时候，就是要收获结果了
        if (l == n && r == n) {
            result.add(str);
        }
        //先让二叉树向左走，就是先加左括号，再加右括号
        if (l < n) {
            recursive(str + "(", l + 1, r, n);
        }
        //并且如果r>l的时候就不能进去了，因为这时候以及不是一个有效的组合了
        //也就是说需要进行剪枝了
        if (r < l) {
            recursive(str + ")", l, r + 1, n);
        }
        //这个递归的退出的时候其实就是这个方法里面没有语句的时候
    }
}
