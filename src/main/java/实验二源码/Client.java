package 实验二;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        OldLoginSystem oldLoginSystem = new OldLoginSystemImpl();
        NewLoginSystem newLoginSystem = new LoginAdapter(oldLoginSystem);

        boolean result = newLoginSystem.login("example@example.com", "1234567890");
        System.out.println("登录成功: " + result);
    }
}
