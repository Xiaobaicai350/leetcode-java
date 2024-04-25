package 实验三;

// 展示板类，实现观察者接口
class DisplayBoard implements Observer {
    private String state;

    @Override
    public void update(String state) {
        this.state = state;
        display();
    }

    public void display() {
        System.out.println("展示板: " + state);
    }
}