# Threads

## Ejemplos

Creación de un Hilo:

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Hilo ejecutándose");
    }
}
public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
```

Implementación de la interfaz Runnable:

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Hilo ejecutándose");
    }
}
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
```


Nombre del Hilo:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }
}
```

Prioridad del Hilo:

```java
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t.getPriority());
    }
}
```


Dormir un Hilo (Sleep):

```java
public class Main {
    public static void main(String[] args) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

Unir Hilos (Join):

```java
class MyThread extends Thread {
    public void run() {
        for(int i=0; i<5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
```

Sincronización de Métodos:

```java
class Counter {
    synchronized void increment() {
        int count = 0;
        count++;
        System.out.println(count);
    }
}
```

Sincronización de Bloques:

```java
class Counter {
    void increment() {
        synchronized (this) {
            int count = 0;
            count++;
            System.out.println(count);
        }
    }
}
```

Comunicación entre Hilos:

```java
class Printer {
    private static final double DELAY = 100;
    boolean flag = false;

    private void imprimir(String msg) {
        for(int i = 0 ; i<msg.length(); i++){
            System.out.print(msg.charAt(i));
            Thread.sleep(Math.random()*DELAY);
        }
    }

    synchronized void imprime(String msg) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        imprimir(msg);
        flag = true;
        notify();
    }
}
```

Ideas de enunciado

Niño juegan en el paruqe y tienen que recargar los globos de agua en la fuente. Cada niño escribe un símbolo, al entrar en la fuente se escribe ENTRA(sim)-RECARGA-SALE(sim)
Nunca debe haber más de un niño recargando en la fuente.


Dos equipos tirando de la cuerda. 

Comunicación entre Hilos:

Crea dos hilos que se comuniquen entre sí usando los métodos wait y notify, de tal manera que uno imprima los números impares y el otro imprima los números pares del 1 al 10.

Manejo de Excepciones de Hilos:

Crea un hilo que lance una excepción RuntimeException. Captura y maneja la excepción usando un UncaughtExceptionHandler.
