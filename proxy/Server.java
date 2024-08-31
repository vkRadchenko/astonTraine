package astonTraine.proxy;

public class Server {
    public Server() {
        System.out.println("Подключение к серверу");
    }

    public void putFile(String file){
        System.out.println("Добавляем файл");
    }
    public void takeFile(String fileName){
        System.out.println("Забираем файл");
    }

}
