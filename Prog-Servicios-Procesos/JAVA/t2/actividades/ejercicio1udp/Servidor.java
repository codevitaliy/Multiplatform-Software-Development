package t2.actividades.ejercicio1udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

  private static final int MAX_LENGTH = 66666;

  public static void main(String[] args) {

    int port = Integer.parseInt(args[0]);

    try {
      DatagramSocket ds = new DatagramSocket(port, InetAddress.getByName("0.0.0.0"));
      byte[] buffer = new byte[MAX_LENGTH];

      DatagramPacket packet = new DatagramPacket(buffer, MAX_LENGTH);

      ds.receive(packet);

      String msg = new String(packet.getData(), 0, packet.getLength());

      System.out.println(msg);

    } catch (SocketException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
