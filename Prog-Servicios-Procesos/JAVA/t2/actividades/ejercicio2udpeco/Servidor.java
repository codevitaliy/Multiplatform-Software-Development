package t2.actividades.ejercicio2udpeco;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class Servidor {

  private static final int MAX_LENGTH = 55555;  

  public static void main(String[] args) {
  
    int port = Integer.parseInt(args[0]);

    try {

      //para que el servidor se mantenga activo 
     while (true) {
      
      //el socket vale tanto para recibir como para enviar el mismo
      DatagramSocket ds = new DatagramSocket(port, InetAddress.getByName("0.0.0.0"));
      byte[] buffer = new byte[MAX_LENGTH];

      //datagrampacket para recibir los datos de cliente
      DatagramPacket receivePacket = new DatagramPacket(buffer, MAX_LENGTH);

      ds.receive(receivePacket);

      String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());

      //datagrampacket para enviar los datos al cliente de vuelta 
      DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getLength(),receivePacket.getAddress(),receivePacket.getPort());

      ds.send(sendPacket);

      ds.close();

     }
    }catch (SocketException e) {
      e.printStackTrace();
    }catch (UnknownHostException e) {
      e.printStackTrace();
    }catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
}
