package t2.actividades.ejercicio4ChatUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Servidor {

  static final int MAX_LENGTH = 66666;

  public static void main(String[] args) {

    try {

      int port = Integer.parseInt(args[0]);
      DatagramSocket socket = new DatagramSocket(port);
      byte[] bufferSentData = new byte[MAX_LENGTH];
      byte[] bufferReceivedData = new byte[MAX_LENGTH];
      InetAddress address;
      Scanner sc = new Scanner(System.in);

      while (true) {

        //RECIBIR EL PACKET

        DatagramPacket receivedPacket = new DatagramPacket(bufferReceivedData, bufferReceivedData.length);
        socket.receive(receivedPacket);
        address = receivedPacket.getAddress();

        String msgReceived = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
        System.out.println("IP: " + address + "Mensaje: " + msgReceived);

        //ENVIAR EL PACKET

        System.out.println("Escribe un mensaje al cliente ahora:");
        String msgSent = sc.nextLine();
        bufferSentData = msgSent.getBytes();
        port = receivedPacket.getPort();
        DatagramPacket sentPacket = new DatagramPacket(bufferSentData, bufferSentData.length, address, port);
        socket.send(sentPacket);
      }
    } catch (SocketException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
