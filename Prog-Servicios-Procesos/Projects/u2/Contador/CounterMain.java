package Projects.u2.Contador;

public class CounterMain {
  public static void main(String[] args) {

    Counter counter = new Counter();

    // Crear e iniciar hilos que incrementan
    for (int i = 0; i < 5; i++) {
      new Thread(() -> counter.increment()).start();
    }

    // Crear e iniciar hilos que disminuyer
    for (int i = 0; i < 5; i++) {
      new Thread(() -> counter.decrement()).start();
    }

    // Esperar a que todos los hilos terminen
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(counter.getContador());

  }
}
