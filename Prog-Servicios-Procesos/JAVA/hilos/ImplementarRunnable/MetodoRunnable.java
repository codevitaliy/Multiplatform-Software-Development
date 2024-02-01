package hilos.ImplementarRunnable;

public class MetodoRunnable implements Runnable {

  public static final int NUM_MAX = 10;

  public void run(){

    Thread[] arrayThreads = new Thread[NUM_MAX];

    for (int i = 1; i < NUM_MAX + 1; i++) {
      arrayThreads[i] = new Thread();
      arrayThreads[i].setName("Hilo " + i);
      arrayThreads[i].start();

      for (int j = 1; j < NUM_MAX + 1; j++) {
        System.out.println("i * j = " + i*j);
      }
    }

    //esperar a todos los hilos

    for(Thread thread : arrayThreads){
      try {
        thread.join();
      } catch (Exception e) {
        System.out.println(e.getMessage() + " Error wait");
      }
    }
  }
}
