package hardCode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        //创建 LinkedHashMap 时，使用了构造函数 new LinkedHashMap<>(16, 0.75f, true)，
        // 这里的第三个参数 true 表明 LinkedHashMap 会按照访问顺序（access-order）来维护元素，
        // 而非插入顺序（insertion-order）。这就意味着，每次访问（比如调用 get 方法）一个元素时，该元素会被移动到链表的尾部
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        System.out.println("试验验证"+"开始时顺序：");
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("试验验证"+ "key:" + key + ",value:" + value);
        }
        System.out.println("试验验证"+ "通过get方法，导致key为name1对应的Entry到表尾");
        linkedHashMap.get("name1");
        Set<Map.Entry<String, String>> set2 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("试验验证"+ "key:" + key + ",value:" + value);
        }
    }
}
