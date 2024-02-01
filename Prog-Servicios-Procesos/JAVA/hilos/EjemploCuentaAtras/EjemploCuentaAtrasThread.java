package hilos.EjemploCuentaAtras;

public class EjemploCuentaAtrasThread extends Thread {
  private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount;
    
    public EjemploCuentaAtrasThread() {}
    
    public EjemploCuentaAtrasThread(int countDown) {
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


        EjemploCuentaAtrasThread launch = new EjemploCuentaAtrasThread();
        launch.start();

        EjemploCuentaAtrasThread lauch2 = new EjemploCuentaAtrasThread();
        lauch2.start();

        EjemploCuentaAtrasThread launch3 = new EjemploCuentaAtrasThread();
        launch3.start();

        System.out.println("Comienza la cuenta atrás!");


        
    } 
}
