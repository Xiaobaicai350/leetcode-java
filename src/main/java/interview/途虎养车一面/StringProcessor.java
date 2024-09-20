package interview.途虎养车一面;

import java.util.LinkedHashSet;
import java.util.Set;

public class StringProcessor {

    public static void main(String[] args) {
        String input = "a123b123中文字符c456d456";
        String result = processString(input);
        System.out.println(result); // 输出应该是 "123456abcd"
    }

    public static String processString(String input) {
        // 使用LinkedHashSet来保持插入顺序，同时去除重复的数字
        Set<Character> uniqueDigits = new LinkedHashSet<>();//存储数字
        StringBuilder letters = new StringBuilder();//存储英文字母

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                uniqueDigits.add(ch);
            } else if (Character.isLetter(ch)) {
                // 只添加字母字符
                letters.append(ch);
            }
            // 中文字符和其他非字母数字字符将被忽略
        }

        // 将数字和字母拼接起来
        StringBuilder result = new StringBuilder();
        for (char digit : uniqueDigits) {
            result.append(digit);
        }
        result.append(letters);

        return result.toString();
    }
}
