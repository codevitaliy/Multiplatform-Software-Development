package t2.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultiThread {
  public static void main(String[] args) {
    ServerSocket server;
    try {
      server = new ServerSocket(1234);
      
      while(true){
        //espera cliente
        Socket socket = server.accept();
        System.out.println("Servido multithread comienza el trabajo");

        new Thread(()->{

          try {
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String serverResponse = in.readLine();
            
            for(int i = 0; i < 32000; i++) {
              for(int j = 0; j < 1000; j++){
                out.writeUTF(i + serverResponse.toUpperCase());
              }
            }

            in.close();
            out.close();
            socket.close();

          } catch (Exception e) {
            e.printStackTrace();
          }
        }).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
