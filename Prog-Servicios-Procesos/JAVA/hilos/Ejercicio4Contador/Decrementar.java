package hilos.Ejercicio4Contador;

public class Decrementar implements Runnable {
  
  public int decrementar() {
    synchronized(this){
      return MainContador.contador--;
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < MainContador.N_VECES; i++) {
      decrementar();
    }
    
  }

}
