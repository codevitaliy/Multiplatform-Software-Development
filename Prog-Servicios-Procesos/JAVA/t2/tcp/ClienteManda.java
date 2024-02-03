package t2.tcp;

import java.io.DataOutputStream;
import java.net.Socket;

public class ClienteManda {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1234);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("Hola mundo de los sockets");
            out.flush();

            // Add a delay (e.g., 5 seconds) before closing the socket
            Thread.sleep(5000);

            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
