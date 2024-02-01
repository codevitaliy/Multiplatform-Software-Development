package hilos.EjemploCuentaAtras;

public class EjemploCuentaAtrasRunnable implements Runnable {

    private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount;
    
    public EjemploCuentaAtrasRunnable() {}
    
    public EjemploCuentaAtrasRunnable(int countDown) {
        this.countDown = countDown;
    }
    
    @Override
    public void run() {
        while (countDown > 0) {
            System.out.println("#" + id + " (" + countDown + ")" );
            countDown--;
        }
        System.out.println("Lanzamiento (" + id + ")");
    }
    
    public static void main(String[] args) {


        EjemploCuentaAtrasRunnable launch = new EjemploCuentaAtrasRunnable();
        launch.run();

        EjemploCuentaAtrasRunnable lauch2 = new EjemploCuentaAtrasRunnable();
        lauch2.run();

        EjemploCuentaAtrasRunnable launch3 = new EjemploCuentaAtrasRunnable();
        launch3.run();

        System.out.println("Comienza la cuenta atrás!");


        
    } 
  
}
