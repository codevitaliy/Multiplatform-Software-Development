package t2.actividades.ejercicio3udpcadenareversa;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.UnknownHostException;

public class Servidor {
  private static final int MAX_LENGTH = 66666;
  public static void main(String[] args) {
    int port = 4444;

    try {

        DatagramSocket ds = new DatagramSocket(port, InetAddress.getByName("0.0.0.0"));
        byte[] buffer = new byte[MAX_LENGTH];

      while(true){

        DatagramPacket packet = new DatagramPacket(buffer, MAX_LENGTH);

        ds.receive(packet);

        String msg = new String(packet.getData(), 0, packet.getLength());
        System.out.println(msg);

        String reversedString = "";

        for (int i = msg.length() - 1; i >= 0; i--) {
          char letter = msg.charAt(i);
          reversedString = reversedString + letter;
        }

        System.out.println(reversedString);


      }
    } catch (SocketException e) {
      e.printStackTrace();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e){
      e.printStackTrace();
    }
  }
}
