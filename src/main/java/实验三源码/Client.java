package 实验三;


// 客户端代码
public class Client {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        DisplayBoard displayBoard1 = new DisplayBoard();
        DisplayBoard displayBoard2 = new DisplayBoard();

        weatherStation.registerObserver(displayBoard1);
        weatherStation.registerObserver(displayBoard2);

        weatherStation.setState("晴天");
        weatherStation.setState("雨天");
    }
}
