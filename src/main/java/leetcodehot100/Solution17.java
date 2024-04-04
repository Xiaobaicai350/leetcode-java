package leetcodehot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    List<String> combinations = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        //特殊情况特殊处理
        if (digits.equals("")) {
            return combinations;
        }
        backtrack(digits, 0, "");
        return combinations;
    }

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
}

