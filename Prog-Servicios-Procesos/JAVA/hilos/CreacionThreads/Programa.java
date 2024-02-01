package hilos.CreacionThreads;

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
