package t2.actividades.ejercicio3udpcadenareversa;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {
  public static void main(String[] args) {
   
    String msg = args[0];
    int port = 4444;
    String ip = "127.0.0.1";

    try {
      
      DatagramSocket ds = new DatagramSocket();
      byte[] buffer = msg.getBytes();

      DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), port);

      ds.send(packet); 

      ds.close();

    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (SocketException e){
      e.printStackTrace();
    } catch (IOException e){
      e.printStackTrace();
    }
    
  }
}
