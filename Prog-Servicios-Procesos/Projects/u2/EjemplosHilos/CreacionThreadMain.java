package Projects.u2.EjemplosHilos;

public class CreacionThreadMain {
  public static void main(String[] args) {
    Thread t = new Thread(new CreacionThread());
    t.start();

    // nombre de thread: System.out.println(Thread.currentThread().getName());

    // Prioridad thread: t.setPriority(Thread.MAX_PRIORITY);

    // System.out.println(t.getPriority());

    // Dormir un hilo:
    /* try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } */

    


  }
}
