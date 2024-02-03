package t2.comm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class HolaSocket {
  public static void main(String[] args) {

    String ip = args[0];
    int port = Integer.parseInt(args[1]);
    String msg = args[2];

    try {
      Socket conn = new Socket(ip, port);
      System.out.println("Conectado al servidor");
      DataOutputStream outTCP = new DataOutputStream(conn.getOutputStream());
      DataInputStream inTCP = new DataInputStream(conn.getInputStream());

      // leo mensaje

      System.out.println(inTCP.readUTF());

      // mando mensaje

      outTCP.writeUTF(msg);
      System.out.println("Escribo mensaje en el socket");

      inTCP.close();
      outTCP.close();
      conn.close();

    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
