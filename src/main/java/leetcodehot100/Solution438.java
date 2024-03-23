package leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//    暴力解法
//    public List<Integer> findAnagrams(String s, String p) {
//        ArrayList<Integer> res = new ArrayList<>();
//        char[] charsS=s.toCharArray();
//        char[] charsP=p.toCharArray();
//        Arrays.sort(charsP);
//        for (int i=0;i<=charsS.length-charsP.length;i++){
//            char[] chars = Arrays.copyOfRange(charsS, i, i + charsP.length);
//            Arrays.sort(chars);
//            if(Arrays.equals(chars,charsP)){
//                res.add(i);
//            }
//        }
//        return res;
//    }
/**
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 */
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            // 如果s的长度比p还低，直接返回空集合就行
            return res;
        }
        // 用一个数组记录p中的每一个字符出现了多少次
        int[] counts = new int[26];
        for (int i = 0; i < p.length(); i++) {
            counts[p.charAt(i) - 'a']++;
        }
        // 初始化当前数组，用于记录当前窗口内的字符都出现了几次
        int[] curCounts = new int[26];
        for (int i = 0; i < p.length() - 1; i++) {
            curCounts[s.charAt(i) - 'a']++;
        }
        // 开始对滑动窗口进行遍历
        for (int left = 0, right = p.length() - 1; right < s.length(); right++, left++) {
            // 现在的位置是窗口准备向右扩张一位
            // 向右扩张一位，然后将对应数组++
            curCounts[s.charAt(right) - 'a']++;
            // 现在的窗口长度和p的长度一样，可以直接比较数组，如果数组内的元素值一样，说明是同位素
            if (Arrays.equals(curCounts, counts)) {
                res.add(left);
            }
            // 将窗口向左缩小一位，为了下一次的扩张
            curCounts[s.charAt(left) - 'a']--;
        }
        return res;
    }
}
