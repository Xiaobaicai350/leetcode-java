package leetcodehot100;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 因为存在中括号中也有中括号的情况，所以要用栈进行处理。
 */
class Solution394 {
    int index = 0;

    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();

        while (index < s.length()) {
            char cur = s.charAt(index);
            if (Character.isDigit(cur)) {
                // 如果当前的字符是数字，就解析出来一个数字并进栈
                String digits = getDigits(s);
                stack.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 如果当前字符为字母或者左括号，直接进栈
                stack.addLast(String.valueOf(s.charAt(index)));
                index++;
            } else {
                // 如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，
                // 此时取出栈顶的数字（此时栈顶一定是数字，想想为什么？）因为这道题的代码总是正确的（正确就意味着一定是数字）
                // 就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
                index++;
                LinkedList<String> sub = new LinkedList<>();
                //一直出栈，直到出到左括号。说明字母才出完。
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }
                //由于是在栈里面进行存储的，所以顺序就是反着的。需要进行翻转。
                Collections.reverse(sub);
                // 左括号出栈
                stack.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stack.removeLast());
                StringBuilder stringBuilder = new StringBuilder();
                String o = getString(sub);
                // 构造字符串
                while (repTime > 0) {
                    stringBuilder.append(o);
                    repTime--;
                }
                // 将构造好的字符串入栈
                stack.addLast(stringBuilder.toString());
            }
        }

        return getString(stack);
    }

    /**
     * 这个方法会根据传入的index为下标，查找出来第一个数字，如果13[a] 就会解析出来13
     *
     * @param s
     * @return
     */
    public String getDigits(String s) {
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(index))) {
            ret.append(s.charAt(index++));
        }
        return ret.toString();
    }

    /**
     * 这个方法通过传入一个集合
     * 比如集合内容是[a,b],会返回ab字符串。
     */
    public String getString(LinkedList<String> v) {
        StringBuilder ret = new StringBuilder();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
