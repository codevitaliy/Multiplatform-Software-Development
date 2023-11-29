package Projects.u2.Contador;

public class Counter {

  static int count;
  static final int MAX_COUNT = 1000;

  // Metodo sincronizado
  public synchronized void increment() {
    for (int i = 0; i < 1000; i++) {
      count++;
    }
  }

  // Bloque sincronizado
  /*
   * public void increment() {
   * synchronized(this) {
   * this.count++;
   * }
   * }
   */

  public synchronized void decrement() {
    for (int i = 0; i < 1000; i++) {
      count--;
    }
  }

  public int getContador() {
    return count;
  }

}
