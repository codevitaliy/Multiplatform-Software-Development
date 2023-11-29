package Projects.u2.Runnable1al10;

public class ImprimirNumeros implements Runnable {

  private final int numero;
  
  public ImprimirNumeros(int numero) {
    this.numero = numero;
}

@Override
public void run() {
    System.out.println(Thread.currentThread().getName() + ": Tabla de multiplicar del " + numero);
    for (int i = 1; i <= 10; i++) {
        System.out.println(Thread.currentThread().getName() + ": " + numero + " x " + i + " = " + (numero * i));
    }
}

}
