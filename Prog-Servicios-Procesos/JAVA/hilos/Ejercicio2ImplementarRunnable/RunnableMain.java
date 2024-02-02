package hilos.Ejercicio2ImplementarRunnable;

/* Crea una clase que implemente la interfaz Runnable y sobrescriba el método run para 
imprimir los números del 1 al 10. Luego, instancia y ejecuta el hilo en la clase principal.
Modifica el programa anterior para que cree un array de N Threads y los espere. A cada 
thread le dará un nombre (Método setName) y escribirá la tabla de un número.
    NOTA: La salida estará desordenada.
Ejecuta el comando en la terminal, y vuelca su salida a un fichero. Utiliza las redirecciones de 
linux y el comando sort para verificar que has escrito todas las tablas. */

/* codevitaliy@codevitaliy-VirtualBox:~/PSP2324/ut02/Threads$ java Ejercicio2.Ejercicio2 3 > salida.txt
codevitaliy@codevitaliy-VirtualBox:~/PSP2324/ut02/Threads$ sort salida.txt */

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
