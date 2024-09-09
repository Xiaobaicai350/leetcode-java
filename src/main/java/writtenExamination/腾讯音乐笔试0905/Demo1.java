package writtenExamination.腾讯音乐笔试0905;

import java.util.ArrayList;

public class Demo1 {
    class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param a int整型ArrayList
         * @return int整型ArrayList
         */
        public ArrayList<Integer> newArray(ArrayList<Integer> a) {
            // write code here
            for (int i = 0; i < a.size(); i++) {
                String string = a.get(i).toString();
                int res = delete2(string);
                if (res == -1) {
                    a.remove(i);
                } else {
                    a.set(i, res);
                }
            }
            return a;
        }

        //如果是22这种，就返回-1，其他的就进行拼接
        //121
        //12
        public int delete2(String string) {
            String[] strings = string.split("2");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                builder.append(strings[i]);
            }
            String res = builder.toString();
            if (res.equals("")) {
                return -1;
            } else {
                return string2int(res);
            }
        }

        public int string2int(String string) {
            int res = 0;
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                res = res * 10 + (chars[i] - '0');
            }
            return res;
        }
    }


    class Solution2 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param a int整型ArrayList
         * @return int整型ArrayList
         */
        public ArrayList<Integer> newArray(ArrayList<Integer> a) {
            ArrayList<Integer> res = new ArrayList<>();
            // write code here
            for (int i = 0; i < a.size(); i++) {
                String string = a.get(i).toString();
                String newStr = string.replace("2", "");
                if (newStr.equals("")) {
                } else {
                    res.add(string2int(newStr));
                }
            }
            return res;
        }

        public int string2int(String string) {
            int res = 0;
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                res = res * 10 + (chars[i] - '0');
            }
            return res;
        }
    }
}