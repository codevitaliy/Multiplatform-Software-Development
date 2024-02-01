package hilos.Contador;

public class ClaseMain {

  public static void main(String[] args) throws InterruptedException {
    Contador c = new Contador(100);

    Sumador s1 = new Sumador("Sumador1", c);

    Restador r1 = new Restador("Restador1", c);

    Thread h1 = new Thread(r1);

    s1.start();

    h1.start();

    s1.join();
    h1.join();

    System.out.println("El valor final de c es: " + c.getValor());
  }
}
