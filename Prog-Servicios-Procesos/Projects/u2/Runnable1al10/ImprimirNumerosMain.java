package Projects.u2.Runnable1al10;

public class ImprimirNumerosMain {

 public static void main(String[] args) {
        int N = 5; // Número de hilos
        Thread[] threads = new Thread[N];

        for (int i = 0; i < N; i++) {
            threads[i] = new Thread(new ImprimirNumeros(i + 1));
            threads[i].setName("Hilo-" + (i + 1));
        }

        System.out.println("Iniciando hilos...");

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Todos los hilos han terminado.");
    }
}
