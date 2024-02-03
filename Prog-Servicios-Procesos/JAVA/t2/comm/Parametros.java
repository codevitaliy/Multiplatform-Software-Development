package t2.comm;

public class Parametros {

  public static void main(String[] args) {
    System.out.println("Listado de parametros");
    for(String s: args) {
      System.out.println(String.format("\tParametros: %s", s));
    }
  }
}
