package hilos.Contador;

public class Sumador extends Thread {

  Contador c;

  public Sumador(String name, Contador num) {
    super(name);
    this.c = num;
  }

  public void run(){

    for (int i = 0; i < 300; i++) {
      try {
        c.incrementa();
        System.out.println(Thread.currentThread().getName() + " " + c.getValor());
        Thread.sleep(150);
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
  }
}
