package Projects.u1.EntrenamientoJava.EjecturarComandoNSegundos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MonitorMemoria {
  public static void main(String[] args) {
    ProcessBuilder builder = new ProcessBuilder("free", "-h");
        while(true){
            try{
                Process process = builder.start();
                InputStream stream = process.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String line;
                while((line = reader.readLine()) != null){
                    System.out.println(line);
                }
                System.out.println("------------------------------");
                Thread.sleep(5000);
            } catch (IOException | InterruptedException e) {}
        }
  }
}
