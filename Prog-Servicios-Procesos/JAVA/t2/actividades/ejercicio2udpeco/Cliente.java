package t2.actividades.ejercicio2udpeco;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {
  public static void main(String[] args) {
    
    String ip = args[0];
    int port = Integer.parseInt(args[1]);
    String msg = args[2];

    try {

      
      DatagramSocket ds = new DatagramSocket();
      byte[] buffer = msg.getBytes();

      //datagrampacket para enviar los datos al servidor 
      DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), port);
      ds.send(sendPacket);

      //datagrampacket para recivir los datos del servidor de vuelta haciendo el echo
      DatagramPacket receivedPacket = new DatagramPacket(buffer, sendPacket.getLength());

      ds.receive(receivedPacket);

      String receivedMsg = new String(receivedPacket.getData(), 0, receivedPacket.getLength());

      System.out.println(receivedMsg);

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
