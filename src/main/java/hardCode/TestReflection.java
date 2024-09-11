package hardCode;

import entity.User;

import java.lang.reflect.Constructor;

public class TestReflection {

    public static void main(String[] args) {
        //下面是三种方法获得User的Class对象
        //第一、通过Class.forName方式
        Class clazz1 = null;
        try {
            clazz1 = Class.forName("entity.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //第二、通过对象实例方法获取对象
        Class<User> clazz2 = User.class;
        //第三、通过Object类的getClass方法
        User user = new User();
        Class<? extends User> clazz3 = user.getClass();

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        //--------------------------下面获取通过Class获取User对象---------------
        //第一种方法，通过Class对象获取User
        User user1 = null;
        try {
            user1 = (User) clazz1.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        user1.setName("胥天昊");
        user1.setAge(21);
        System.out.println("user1:" + user1);
        //第二种方法，通过反射获取类构造器，然后通过构造器创建对象
        User user2 = null;
        try {
            // 获取构造函数
            Constructor<User> constructor = clazz2.getConstructor(String.class, Integer.class);
            // 通过构造器对象的newInstance方法进行对象的初始化
            user2 = (User) constructor.newInstance("昊昊", 29);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("user2:" + user2);
    }
}