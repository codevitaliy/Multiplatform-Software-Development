package Projects.u1.EntrenamientoJava.TarCompresor;

import java.io.IOException;

public class Compresor {
  public static void main(String[] args) {

    ProcessBuilder builder;
    for (int i = 0; i < args.length; i++) {
      builder = new ProcessBuilder("tar", "cvzf", "comprimido" + (i+1) + ".tar.gz", args[i]);
      try {
        Process process = builder.start();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
