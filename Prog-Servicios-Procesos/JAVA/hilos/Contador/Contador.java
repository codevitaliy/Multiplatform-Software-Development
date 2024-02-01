package hilos.Contador;

public class Contador {

  private int c = 0;

  public Contador(int num){
    this.c = num;
  }

  public  synchronized void incrementa() {
    c++;
  }

  public synchronized void decrementa() {
    c--;
  }

  public int getValor(){
    return c;
  }
}
