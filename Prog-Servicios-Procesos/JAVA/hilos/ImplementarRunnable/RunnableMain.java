//package hilos.ImplementarRunnable;

public class RunnableMain {
  public static void main(String[] args) {

    final int N = 5; // Número de hilos

    Thread[] threads = new Thread[N];

    for (int i = 1; i <= N; i++) {
      TablePrinter tablePrinter = new TablePrinter(i);
      threads[i - 1] = new Thread(tablePrinter);
      threads[i - 1].start();
    }

    // Esperar a todos los hilos
    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        System.out.println(e.getMessage() + " Error waiting for thread");
      }
    }

    System.out.println("Todos los hilos han terminado.");
  }
}
