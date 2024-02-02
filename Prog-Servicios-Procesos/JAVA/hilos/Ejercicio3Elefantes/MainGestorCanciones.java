package hilos.Ejercicio3Elefantes;

/*Un elefante se balanceaba sobre la tela de una araña
Como veía que resistía, fue a llamar otro elefante
Dos elefantes se balanceaban sobre la tela de una araña
Como veían que resistía, fueron a llamar otro elefante

Basándote en esa canción, crea un Thread que reciba el tipo de animal, la acción y el número máximo. 
Cada vez que escriba una estrofa, el thread generará un número aleatorio entre 100000 y 300000 y verificará si es primo.

Crea un programa principal que gestion 3 canciones infantiles de forma concurrente con distintas prioridades (setPriority) */

public class MainGestorCanciones {
  public static void main(String[] args) {
    
    Animal elefente = new Animal("Elefante", "balancesaba", 3);
    Animal mapache = new Animal("Mapache", "regocijaba", 3);
    Animal cervatillo = new Animal("Cervatillo", "reventaba", 3);
    
    Thread threadAnimal1 = new Thread(elefente);
    Thread threadAnimal2 = new Thread(mapache);
    Thread threadAnimal3 = new Thread(cervatillo);

    threadAnimal1.setPriority(Thread.MAX_PRIORITY);
    threadAnimal2.setPriority(Thread.NORM_PRIORITY);
    threadAnimal3.setPriority(Thread.MIN_PRIORITY);

    threadAnimal1.start();
    threadAnimal2.start();
    threadAnimal3.start();
  }
}
