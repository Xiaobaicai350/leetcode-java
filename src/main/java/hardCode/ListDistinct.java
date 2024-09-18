package hardCode;

import entity.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListDistinct {
    //这种会改变顺序
    public static void main1(String[] args) {
        List<Person> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add(new Person(1, "张三"));
        listWithDuplicates.add(new Person(2, "李四"));
        listWithDuplicates.add(new Person(1, "王五")); // 与第一个对象的id相同，视为重复

        Set<Person> set = new HashSet<>(listWithDuplicates);
        List<Person> listWithoutDuplicates = new ArrayList<>(set);

        // 打印去重后的结果
        for (Person person : listWithoutDuplicates) {
            System.out.println(person.getId() + ": " + person.getName());
        }
    }

    //这种不会改变顺序
    public static void main(String[] args) {
        List<Person> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add(new Person(1, "张三"));
        listWithDuplicates.add(new Person(2, "李四"));
        listWithDuplicates.add(new Person(1, "王五")); // 与第一个对象的id相同，视为重复

        List<Person> listWithoutDuplicates = new ArrayList<>();
        for (Person person : listWithDuplicates) {
            if (!listWithoutDuplicates.contains(person)) {
                listWithoutDuplicates.add(person);
            }
        }

        // 打印去重后的结果
        for (Person person : listWithoutDuplicates) {
            System.out.println(person.getId() + ": " + person.getName());
        }
    }

}
