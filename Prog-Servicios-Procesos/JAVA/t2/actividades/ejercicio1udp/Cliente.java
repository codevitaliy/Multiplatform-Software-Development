package t2.actividades.ejercicio1udp;

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
    byte buffer[] = msg.getBytes();
    
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), port);

    ds.send(packet);
    ds.close();


  } catch (UnknownHostException e) {
     e.printStackTrace();
  } catch (SocketException e){
    e.printStackTrace();
  } catch (IOException e) {
    e.printStackTrace();
  }




  }
}
