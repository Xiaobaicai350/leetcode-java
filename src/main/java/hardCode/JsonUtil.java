package hardCode;

import com.google.gson.Gson;

//通用的JSON转对象的方法
public class JsonUtil {
    private static final Gson gson = new Gson();


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
        Person person = gson.fromJson(jsonString, Person.class);
        System.out.println(person); // 输出: Person{name='John', age=30}

        // 对象转JSON
        String json = gson.toJson(person);
        System.out.println(json); // 输出: {"name":"John","age":30}
    }
}
