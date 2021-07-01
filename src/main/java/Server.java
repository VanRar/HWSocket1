import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int SERVER_PORT = 9999;

    public static void main(String[] args) throws IOException {

        //запускаем сервер на определённом порту, по хорошему это всё вызывать в try или оборачивать, но брал из задания, во втором реализую немного по другому
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Сервер запущен");//выводим сообщение в консоль сервера
        Socket clientSocket = serverSocket.accept();//ждем подключения

        //после подключения мы сможем отправлять и принимать  сообщения:

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //выведем сообщение
        System.out.println("Соединение установленно");
        out.println("Вы подключены, назовите себя");//всё таки с этим покрасивее будет
        //примем строку от клиента:
        String name = in.readLine();
        //выведем её клиенту и номер его порта
        out.println(String.format("Привет %s, номер твоего порта %d", name, clientSocket.getPort()));
        System.out.println("Присланное сообщение: " + name);//выведем полученное сообщение в консоль сервера

        clientSocket.close();
        in.close();
        out.close();

    }
}