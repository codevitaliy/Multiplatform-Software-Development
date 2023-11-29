package Projects.u2.Carrera;

public class Carrera {

    private static final int TOTAL_CARRERA = 100;
    private static final int NUM_CORREDORES = 5;
    private static final int START_DORSAL = 1000;
    private static Object salida = new Object(); // Objeto para notificar la salida
    private static int corredoresTerminados = 0; // Contador de corredores que han terminado

    public static void main(String[] args) {

        Thread[] arrayCorredores = new Thread[NUM_CORREDORES];

        for (int i = 0; i < NUM_CORREDORES; i++) {
            arrayCorredores[i] = new Thread(new Corredor(TOTAL_CARRERA, START_DORSAL + i));
        }

        System.out.println("La carrera va a comenzar!!!");

        synchronized (salida) {
            for (int i = 0; i < NUM_CORREDORES; i++) {
                arrayCorredores[i].start();
            }

            // Esperar a que todos los corredores notifiquen la salida
            try {
                salida.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Esperar a que todos los corredores terminen
        for (int i = 0; i < NUM_CORREDORES; i++) {
            try {
                arrayCorredores[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La carrera ha terminado");
    }

    // Método para que los corredores notifiquen cuando llegan a la meta
    public static synchronized void corredorTerminado() {
        corredoresTerminados++;
        if (corredoresTerminados == NUM_CORREDORES) {
            synchronized (salida) {
                salida.notify(); // Notificar al thread principal que todos los corredores han salido
            }
        }
    }
}