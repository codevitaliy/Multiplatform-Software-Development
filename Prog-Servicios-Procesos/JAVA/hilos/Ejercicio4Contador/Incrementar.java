package hilos.Ejercicio4Contador;

public class Incrementar implements Runnable {

  public Incrementar() {};

  public int incrementar() {
    synchronized (this) {
      return MainContador.contador++;
    }
  }

  @Override
  public void run() {

    for (int i = 0; i < MainContador.N_VECES; i++) {
      incrementar();
    }
   /*  try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.getMessage();
    } */
  }
}
