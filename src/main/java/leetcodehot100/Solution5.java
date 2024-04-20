package leetcodehot100;

class Solution5 {

    public String longestPalindrome(String s) {
        String longestPalindrome=s.substring(0,1);
        for (int len = 2; len <= s.length(); len++) {
            for (int start = 0; start < s.length() - len + 1; start++) {
                int end = start + len ;
                String string = s.substring(start, end);
                if (isPalindrome(string)){
                    //如果是回文字符串
                    //记录最长的值
                    if(string.length()>longestPalindrome.length()){
                        longestPalindrome=string;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    public boolean isPalindrome(String str) {
        // 删除字符串中的所有非字母数字字符，并将字符串转换为小写
        str = str.replaceAll("[^\\w]", "").toLowerCase();
        // 使用StringBuilder来反转字符串
        StringBuilder reversedStr = new StringBuilder(str).reverse();

        // 比较原字符串和反转后的字符串是否相等
        return str.equals(reversedStr.toString());
    }


}

