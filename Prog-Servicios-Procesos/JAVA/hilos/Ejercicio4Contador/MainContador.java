package hilos.Ejercicio4Contador;

/* 04 Contador

Crea una clase Counter con un método sincronizado increment que incremente una variable count. 
Crea dos hilos que incrementen el contador y observa el resultado. 

Modifica la clase Counter anterior 
para usar un bloque sincronizado en lugar de un método sincronizado.
Modificación 04a

Modifica el ejercicio para poder incrementar y decrementar, crea 5 hilos que incrementen 1000 veces y 
5 que decrementen 1000 veces. Muestra el resultado de hacer esta operación con sincronización y sin sincornización. */


public class MainContador {

  public static final int N_VECES = 1000;
  public static int contador = 0;
  public static void main(String[] args) {

    /* PRIMERA PARTE DEL EJERCICIO
    Contador contador1 = new Contador();
    Contador contador2 = new Contador();

    Thread tContador1 = new Thread(contador1);
    Thread tContador2 = new Thread(contador2);

    tContador1.start();
    tContador2.start();
 */

    Incrementar incrementar = new Incrementar();
    Decrementar decrementar = new Decrementar();

    Thread t1 = new Thread(incrementar);
    Thread t2 = new Thread(incrementar);
    Thread t3 = new Thread(incrementar);
    Thread t4 = new Thread(incrementar);
    Thread t5 = new Thread(incrementar);

    Thread t6 = new Thread(decrementar);
    Thread t7 = new Thread(decrementar);
    Thread t8= new Thread(decrementar);
    Thread t9 = new Thread(decrementar);
    Thread t10 = new Thread(decrementar);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();
    t8.start();
    t9.start();
    t10.start();

    try {
      t1.join();
      t2.join();
      t3.join();
      t4.join();
      t5.join();
      t6.join();
      t7.join();
      t8.join();
      t9.join();
      t10.join();
  } catch (InterruptedException e) {
      e.printStackTrace();
  }

  System.out.println(contador);




  }
}
