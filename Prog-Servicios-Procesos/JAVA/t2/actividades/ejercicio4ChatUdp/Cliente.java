package t2.actividades.ejercicio4ChatUdp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

  public static void main(String[] args) {

    try {

      int port = Integer.parseInt(args[0]);

      String ip = args[1];

      DatagramSocket ds = new DatagramSocket();

      Scanner sc = new Scanner(System.in);

      InetAddress address;

      byte[] bufferReceivedData = new byte[Servidor.MAX_LENGTH];
      byte[] bufferSentData = new byte[Servidor.MAX_LENGTH];

      while (true) {

        // ENVIAR EL PACKET

        String msgSent = sc.nextLine();

        bufferSentData = msgSent.getBytes();

        DatagramPacket sentPacket = new DatagramPacket(bufferSentData, bufferSentData.length,
            InetAddress.getByName(ip), port);
        ds.send(sentPacket);

        // RECIBIR EL PACKET

        DatagramPacket receivedPacket = new DatagramPacket(bufferReceivedData, Servidor.MAX_LENGTH);

        ds.receive(receivedPacket);

        address = receivedPacket.getAddress();

        String msgReceived = new String(receivedPacket.getData(), 0, receivedPacket.getLength());

        System.out.println("Ip: " + address + "Msg: " + msgReceived);

        // sc.close();

      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
