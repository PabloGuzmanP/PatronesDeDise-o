package singletonHilos;

public class Modificador extends Thread{
    private SingletonHilos singleton;

    public Modificador(SingletonHilos singleton) {
        this.singleton = singleton;
    }

    @Override
    public void run() {
        // Modificar los atributos del Singleton
        singleton.modifyAttributes("Texto_Modificado", "Texto_ModificadoX2");
    }
}
