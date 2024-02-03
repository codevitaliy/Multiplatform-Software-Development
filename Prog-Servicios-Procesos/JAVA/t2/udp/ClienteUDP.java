package t2.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteUDP {
  public static void main(String[] args) {

    try {
      DatagramSocket ds = new DatagramSocket();
      byte buffer[] = "Hola mundo\n".getBytes();
      String ip = "127.0.0.1";
      // ds.setBroadCast(true)

      DatagramPacket p = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), 1234);

      ds.send(p);
      ds.close();

    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (SocketException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
