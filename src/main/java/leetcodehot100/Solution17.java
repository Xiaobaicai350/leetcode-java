package leetcodehot100;

import java.util.*;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

示例 2：
输入：digits = ""
输出：[]

示例 3：
输入：digits = "2"
输出：["a","b","c"]
 */
class Solution17 {
    Map<Character, String> map = new HashMap<>();

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    //结果集
    List<String> res = new ArrayList<>();

    //入口，返回所有它能表示的字母组合
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        back(digits, 0, "");
        return res;
    }

    private void back(String digits, int index, String curCombine) {
        if (curCombine.length() == digits.length()) {
            res.add(curCombine);
        } else {
            char c = digits.charAt(index);
            String s = map.get(c);
            for (int i = 0; i < s.length(); i++) {
                char singleC = s.charAt(i);
                //不能这样写，因为string是个引用，不能改变curCombie的值
//                curCombine = curCombine + singleC;
//                back(digits, index + 1, );
                back(digits, index + 1, curCombine + singleC);
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = new Solution17().letterCombinations("23");
        System.out.println(res.toString());
    }
}

