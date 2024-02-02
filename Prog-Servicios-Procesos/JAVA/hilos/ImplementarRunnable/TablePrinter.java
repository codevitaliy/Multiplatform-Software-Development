//package hilos.ImplementarRunnable;

public class TablePrinter implements Runnable {

  private int number;

  public TablePrinter(int number) {
      this.number = number;
  }

  @Override
  public void run() {
      Thread.currentThread().setName("Thread-" + number);

      for (int i = 1; i <= 10; i++) {
          System.out.println(Thread.currentThread().getName() + ": " + number + " * " + i + " = " + (number * i));
      }
  }
}