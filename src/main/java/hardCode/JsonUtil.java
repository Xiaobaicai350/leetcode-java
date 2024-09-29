package hardCode;

import com.google.gson.Gson;

//通用的JSON转对象的方法
public class JsonUtil {
    private static final Gson gson = new Gson();

    //将JSON字符串转换为指定类型的对象。
    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    //将对象转换为JSON字符串。
    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static void main(String[] args) {
        // 示例对象
        class Person {
            String name;
            int age;

            @Override
            public String toString() {
                return "Person{name='" + name + "', age=" + age + "}";
            }
        }

        // JSON字符串
        String jsonString = "{\"name\":\"John\", \"age\":30}";

        // JSON转对象
        Person person = fromJson(jsonString, Person.class);
        System.out.println(person); // 输出: Person{name='John', age=30}

        // 对象转JSON
        String json = toJson(person);
        System.out.println(json); // 输出: {"name":"John","age":30}
    }
}
