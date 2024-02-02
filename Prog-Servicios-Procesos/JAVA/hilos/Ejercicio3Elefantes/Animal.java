package hilos.Ejercicio3Elefantes;

import java.util.Random;

public class Animal implements Runnable {
  String nombre;
  String accion;
  int numMax;
  public static final int NUM_MAX = 300000;
  public static final int NUM_MIN = 100000;

  public Animal(String nombre, String accion, int numMax) {
    this.nombre = nombre;
    this.accion = accion;
    this.numMax = 5;
  }

  public String getNombre() {
    return nombre;
  }

  public String getAccion() {
    return accion;
  }

  @Override
  public void run() {

    for (int i = 1; i < this.numMax + 1; i++) {

      String song = i + " Un " + getNombre() + " se " + getAccion() + " sobre la tela de una spider, \n" +
          "Y como veia que no se caia, fue a llamar a otro " + getNombre() + "\n";

      System.out.println(song);

      int numeroAleatorio = numeroAleatorio(NUM_MIN, NUM_MAX);

      if (esPrimo(numeroAleatorio)) {
        System.out.println(numeroAleatorio + " es primo");
      } else {
        System.out.println(numeroAleatorio + " no es primo");
      }

      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.getMessage();
      }
    }

  }

  public int numeroAleatorio(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;

  }

  public boolean esPrimo(int numero) {
    for (int i = 2; i <= Math.sqrt(numero); i++) {
      if (numero % i == 0) {
        return false;
      }
    }

    return true;
  }
}
