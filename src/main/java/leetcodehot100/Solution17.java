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
    Map<Character, String> phoneMap = new HashMap<>();

    {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    //结果集
    List<String> combinations = new ArrayList<>();

    //入口，返回所有它能表示的字母组合
    public List<String> letterCombinations(String digits) {
        //特殊情况特殊处理
        if (digits.equals("")) {
            return combinations;
        }
        backtrack(digits, 0, "");
        return combinations;
    }


    /**
     * @param digits      输入的数字
     * @param index       数字的下标
     * @param combination 组合
     */
    private void backtrack(String digits, int index, String combination) {
        if (index == digits.length()) {
            combinations.add(combination);
        } else {
            //得到当前位置上的数字
            char digit = digits.charAt(index);
            //通过数字得到对应的字母
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                backtrack(digits, index + 1, combination + letters.charAt(i));
            }
        }
    }


    // 非递归方法
    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<>();
        // 特殊情况特殊处理
        if (digits.isEmpty()) {
            return combinations;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        for (int i = 0; i < digits.length(); i++) {//遍历输入的数字
            char digit = digits.charAt(i);//得到当前位置上的数字
            String letters = phoneMap.get(digit);//通过数字得到对应的字母
            int size = queue.size();//得到队列的大小
            for (int j = 0; j < size; j++) {//遍历队列
                String current = queue.poll();//得到当前的字符串
                for (char letter : letters.toCharArray()) {
                    queue.offer(current + letter);//将当前的字符串加上字母，然后加入队列
                }
            }
        }

        while (!queue.isEmpty()) {
            combinations.add(queue.poll());
        }

        return combinations;
    }
}

