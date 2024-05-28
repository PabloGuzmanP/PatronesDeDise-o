package patronsingleton;

import singletonHilos.Modificador;
import singletonHilos.SingletonHilos;

public class PatronSingletonMain {
    public static void main(String[] args) throws InterruptedException {
        //Configuración de Propiedades para el Modulo No->1
        ParametrizacionSingleton singletonA = ParametrizacionSingleton.getInstance();
        //Configuración de Propiedades para el Modulo No->1
        ParametrizacionSingleton singletonB = ParametrizacionSingleton.getInstance();
        System.out.println(singletonA);
        System.out.println(singletonB);
        System.out.println("Igual referencia ==> " + (singletonA == singletonB));
        singletonA.setNombreAplicacion("Patron Creacional Singleton");
        singletonB.setNumeroVersion("2.0x");
        System.out.println("SingletonA ==> " + singletonA);
        System.out.println("SingletonB ==> " + singletonB);
        singletonA = null;
        singletonB = null;
        singletonA = ParametrizacionSingleton.getInstance();
        System.out.println("singletonA ==> " + singletonA);
        //-------------PARTE B-------------------------------------------------------
        SingletonHilos singleton = SingletonHilos.getInstance();

        Modificador hilo1 = new Modificador(singleton);
        Modificador hilo2 = new Modificador(singleton);
        Modificador hilo3 = new Modificador(singleton);

        hilo1.start();
        hilo3.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("attribute1 = " + singleton.getHilo1());
        System.out.println("attribute2 = " + singleton.getHilo2());
    }
}
