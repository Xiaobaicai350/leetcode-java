package writtenExamination.腾讯云智笔试1022;

import java.util.*;

/*
2
4 2
1 2 2 3
5 3
1 1 1 1 1
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int ai = in.nextInt();
                list.add(ai);
            }
            for (int j = 0; j < n; j++) {
                Integer ai = list.get(j);
                if (map.containsKey(ai)) {
                    map.put(ai, map.get(ai) + 1);
                } else {
                    map.put(ai, 1);
                }
            }

            while (list.size() >= k) {
                for (int j = 0; j < k; j++) {
                    boolean flag=false;
                    //遍历map，并且优先删除value!=1的key，删除包括list和map
                    for (Integer key : map.keySet()) {
                        Integer val = map.get(key);
                        if (val > 1) {
                            deleteKeyList(list, key);
                            map.put(key, map.get(key) - 1);
                            flag=true;
                            break;
                        }
                    }
                    if(!flag){
                        Integer key = list.get(list.size() - 1);
                        list.remove(list.size()-1);
                        map.remove(key);
                    }
                }
            }
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < list.size(); j++) {
                set.add(list.get(j));
            }
            if (set.size() == list.size()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }

    private static void deleteKeyList(ArrayList<Integer> list, Integer key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(key)) {
                list.remove(i);
                break;
            }
        }
    }
}