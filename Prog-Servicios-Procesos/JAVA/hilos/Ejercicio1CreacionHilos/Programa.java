package hilos.Ejercicio1CreacionHilos;


/* Hilos:

    Crea una clase que extienda de Thread y sobrescriba el método run para imprimir "Hola Mundo" en la consola. Luego, instancia y ejecuta el hilo en la clase principal.
    Crea un versión de forma que implementes Runnable.
    Crea una versión con un Lambda.

Haz un método princpial que arranque los 3 threads. */

public class Programa {
  public static void main(String[] args) {

    //THIS IS THE THREAD THAT EXTENDS FROM THREAD
    
    MyThreadExtends threadExtends = new MyThreadExtends();

    threadExtends.start();

    // THIS IS THE THREAD THAT IMPLEMENTS RUNNABLE

    MyThreadRunnable threadRunnable = new MyThreadRunnable();
    
    Thread thread = new Thread(threadRunnable);

    thread.start();

    // THIS IS THE THREAD RUNNABLE WITH A LAMBDA

    Thread thread2 = new Thread(() ->{
      System.out.println("Hello from lambda");
    });

    thread2.start();

  }

}
