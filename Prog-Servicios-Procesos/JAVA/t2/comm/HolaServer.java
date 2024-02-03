package t2.comm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HolaServer {
  public static final String MENSAJE_FIN = "adios";

  public static void main(String[] args) {

    ServerSocket server;
    /*
     * Es una clase en Java que proporciona un socket del lado del servidor,
     * lo cual es esencial para aceptar conexiones de clientes en una aplicación de
     * red.
     */

    int port = Integer.parseInt(args[0]);

    String msg = args[1] + "\n";

    try {

      // Crear un ServerSocket en el puerto especificado
      server = new ServerSocket(port);

      System.out.println("Escuchando al puerto: " + port);

      // Bucle infinito para esperar conexiones continuamente
      while (true) {

        /*
         * bloqueo para aceptar peticiones,el programa se quedará aquí hasta que reciba
         * una conexión de un cliente.
         * Cuando se establece una conexión, accept() devuelve un nuevo objeto Socket
         * (connCliente) que representa la conexión con ese cliente específico.
         */

        Socket connCliente = server.accept();

        System.out.println("Comienzo thread");

        new Thread(() -> {
          atenderPeticion(connCliente, msg);
        }).start();

        System.out.println("Escucho otro cliente");

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void atenderPeticion(Socket connCliente, String msg) {

    try {

      System.out.println("Se conecto un cliente: " + connCliente.getInetAddress());

      // Genero los dos Streams de entrada/salida

      DataOutputStream outTCP = new DataOutputStream(connCliente.getOutputStream());

      DataInputStream inTCP = new DataInputStream(connCliente.getInputStream());

      // escribir bienvenida

      outTCP.writeUTF(msg);
      outTCP.flush();

      // Leer el mensaje que nos manda y escribirlo por pantalla

      String msgDeCliente;

      do {
        msgDeCliente = inTCP.readUTF();
        outTCP.writeUTF(msgDeCliente.toUpperCase());

      } while (!msgDeCliente.equalsIgnoreCase(MENSAJE_FIN));

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
