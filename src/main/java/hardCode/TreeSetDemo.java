package hardCode;

import entity.User;

import java.util.Comparator;
import java.util.TreeSet;

/*
TreeSet 是 Java 中的一个有序集合，它实现了 SortedSet 接口
内部使用红黑树（一种自平衡的二叉搜索树）来存储元素，因此元素会按照自然顺序或者指定的比较器顺序进行排序。
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        // 创建一个 TreeSet 对象，用于存储整数
        TreeSet<Integer> numbers = new TreeSet<>();

        // 向 TreeSet 中添加元素
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(5);
        numbers.add(4);

        // 输出 TreeSet 中的元素，元素会按照自然顺序排序
        //TreeSet 中的元素: [1, 2, 3, 4, 5]
        System.out.println("TreeSet 中的元素: " + numbers);

        // 检查 TreeSet 是否包含某个元素
        boolean containsTwo = numbers.contains(2);
        //TreeSet 中是否包含 2: true
        System.out.println("TreeSet 中是否包含 2: " + containsTwo);

        // 获取 TreeSet 中的第一个元素
        Integer first = numbers.first();
        //TreeSet 中的第一个元素: 1
        System.out.println("TreeSet 中的第一个元素: " + first);

        // 获取 TreeSet 中的最后一个元素
        Integer last = numbers.last();
        //TreeSet 中的最后一个元素: 5
        System.out.println("TreeSet 中的最后一个元素: " + last);

        // 移除 TreeSet 中的一个元素
        numbers.remove(3);
        //移除 3 后 TreeSet 中的元素: [1, 2, 4, 5]
        System.out.println("移除 3 后 TreeSet 中的元素: " + numbers);

        // 遍历 TreeSet 中的元素
        System.out.println("遍历 TreeSet 中的元素:");
        for (Integer number : numbers) {
            System.out.println(number);
        }

//------------------------------------------------------------------------------------------------------------------------------------------------------------
        // 自定义比较器，按照 age 升序排序
        Comparator<User> comparing = Comparator.comparing(User::getAge);
        TreeSet<User> users = new TreeSet<>(comparing);
        users.add(new User("Alice", 25));
        users.add(new User("Bob", 20));
        users.add(new User("Charlie", 30));

        for (User user : users) {
            System.out.println(user);
        }
        /*
        User{name='Bob', age=20}
        User{name='Alice', age=25}
        User{name='Charlie', age=30}
         */
    }
}
