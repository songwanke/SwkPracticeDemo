package test.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author songwanke
 * @date 2017/12/7
 */
public class ServerSocketTest {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while(true){
                Socket socket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.println("aaa");
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
