package t2.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    ServerSocket server;
    System.out.println("Servido multithread comienza el trabajo");
    try {
      server = new ServerSocket(1234);
      while (true) {
        //espera cliente
        Socket socket = server.accept(); 
        
        

        //DataInputStream in = new DataInputStream(socket.getInputStream());

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader in = new BufferedReader(inputStreamReader);


        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        //depracated if used with DataInputStream, InputStreamReader newer 
        String serverResponse = in.readLine();

        for (int i = 0; i < 32000; i++) {
          for (int j = 0; j <  1000; j++) {
            out.writeUTF(i + serverResponse.toUpperCase());
          }
        }
        
        in.close();
        out.close();
        socket.close();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
