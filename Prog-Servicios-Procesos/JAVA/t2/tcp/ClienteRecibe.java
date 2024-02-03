package t2.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteRecibe {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("127.0.0.1", 1234);
      try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                System.out.println(in.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
            socket.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
