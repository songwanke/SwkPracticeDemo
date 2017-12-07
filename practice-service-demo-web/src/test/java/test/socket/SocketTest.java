package test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author songwanke
 * @date 2017/12/7
 */
public class SocketTest {
    public static void main(String[] args) {

        try {

            Socket chatSocket = new Socket("127.0.0.1", 5000);

            InputStreamReader inputStreamReader = new InputStreamReader(chatSocket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String s = reader.readLine();
            System.out.println("****"+s);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
