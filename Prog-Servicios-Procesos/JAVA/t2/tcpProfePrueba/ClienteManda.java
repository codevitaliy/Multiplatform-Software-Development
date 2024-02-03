package t2.tcpProfePrueba;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteManda {
  public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 1234);
			DataOutputStream  out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Hola mundo de los sockets!!!\n");
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
