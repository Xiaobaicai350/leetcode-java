package hardCode;

import entity.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;



public class ComparatorUserDemo {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Tom", 25));
        users.add(new User("Alice", 22));
        users.add(new User("Bob", 22));

        // 用法 1: 匿名内部类实现 Comparator
        Comparator<User> ageComparator = new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getAge().compareTo(u2.getAge());
            }
        };
        List<User> usersByAge = new ArrayList<>(users);
        usersByAge.sort(ageComparator);
        System.out.println("按年龄排序:");
        for (User user : usersByAge) {
            System.out.println(user);
        }

        // 用法 2: Lambda 表达式实现 Comparator
        Comparator<User> nameComparator = (u1, u2) -> u1.getName().compareTo(u2.getName());
        List<User> usersByName = new ArrayList<>(users);
        usersByName.sort(nameComparator);
        System.out.println("\n按姓名排序:");
        for (User user : usersByName) {
            System.out.println(user);
        }

        // 用法 3: 方法引用实现 Comparator
        Comparator<User> ageComparatorByMethodRef = Comparator.comparing(User::getAge);
        List<User> usersByAgeMethodRef = new ArrayList<>(users);
        usersByAgeMethodRef.sort(ageComparatorByMethodRef);
        System.out.println("\n按年龄排序（方法引用）:");
        for (User user : usersByAgeMethodRef) {
            System.out.println(user);
        }

        // 用法 4: 链式比较
        Comparator<User> multiComparator = Comparator.comparing(User::getAge).thenComparing(User::getName);
        List<User> usersByMulti = new ArrayList<>(users);
        usersByMulti.sort(multiComparator);
        System.out.println("\n先按年龄排序，年龄相同按姓名排序:");
        for (User user : usersByMulti) {
            System.out.println(user);
        }

        // 用法 5: 逆序排序
        Comparator<User> reverseAgeComparator = ageComparator.reversed();
        List<User> usersByReverseAge = new ArrayList<>(users);
        usersByReverseAge.sort(reverseAgeComparator);
        System.out.println("\n按年龄逆序排序:");
        for (User user : usersByReverseAge) {
            System.out.println(user);
        }

        // 用法 6: 在 TreeSet 中使用 Comparator
        TreeSet<User> userTreeSet = new TreeSet<>(ageComparator);
        userTreeSet.addAll(users);
        System.out.println("\nTreeSet 按年龄排序:");
        for (User user : userTreeSet) {
            System.out.println(user);
        }
    }
}
