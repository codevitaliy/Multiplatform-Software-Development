package hilos.ImplementarRunnable;

public class RunnableMain {
  public static void main(String[] args) {
    
    MetodoRunnable runnable = new MetodoRunnable();

    Thread t = new Thread(runnable);

    t.start();
  
  }
}
