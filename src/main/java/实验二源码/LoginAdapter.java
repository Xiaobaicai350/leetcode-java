package 实验二;

// 适配器类
class LoginAdapter implements NewLoginSystem {
    private OldLoginSystem oldLoginSystem;

    public LoginAdapter(OldLoginSystem oldLoginSystem) {
        this.oldLoginSystem = oldLoginSystem;
    }

    @Override
    public boolean login(String email, String phoneNumber) {
        // 将新的登录参数转换为旧的登录参数
        String username = email.split("@")[0];
        String password = phoneNumber.substring(phoneNumber.length() - 4);

        // 使用旧的登录系统进行登录
        return oldLoginSystem.login(username, password);
    }
}