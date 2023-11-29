package Projects.u2.CreacionDeHilo;

public class CreacionThreadMain {

  public static void iniciarThreads() {
    Thread t1 = new Thread(new CreacionThreadRunnable());
    Thread t2 = new Thread(new CreacionThreadExtends());
    Thread t3 = new Thread(() -> System.out.println("Hola mundo lambda"));

    t1.start();
    t2.start();
    t3.start();
  }
  public static void main(String[] args) {
    iniciarThreads();
   
  }
}
