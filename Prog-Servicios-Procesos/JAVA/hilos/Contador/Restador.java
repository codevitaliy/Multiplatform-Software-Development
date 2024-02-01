package hilos.Contador;

public class Restador implements Runnable {

  Contador c;
  String name;

  public Restador(String name, Contador c) {
    this.name = name;
    this.c = c;
  }

  public void run(){
    Thread.currentThread().setName(this.name);
    for (int i = 0; i < 300; i++) {
      try {
        c.decrementa();
        System.out.println(Thread.currentThread().getName() + " " + c.getValor());
        Thread.sleep(150);
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
  }
}
