package singletonHilos;

import patronsingleton.ParametrizacionSingleton;
import utilidades.UtilidadesAcceso;

import java.util.Properties;

public class SingletonHilos {
    private static SingletonHilos instance = null;

    private static final String CONFIGURATION_PROP = "propiedades/ConfiguracionPropiedades.properties";
    private static final String NOMBRE_APLICACION_PROP = "nombreAplicacion";
    private static final String NUMERO_VERSION_PROP = "numeroVersion";

    private String nombreAplicacion;
    private String numeroVersion;
    private String hilo1;
    private String hilo2;

    private SingletonHilos() {
        Properties prop = UtilidadesAcceso.loadProperty(CONFIGURATION_PROP);
        this.nombreAplicacion = prop.getProperty(NOMBRE_APLICACION_PROP);
        this.numeroVersion = prop.getProperty(NUMERO_VERSION_PROP);
        // Inicialización de los atributos
        hilo1 = "Ejemplo1";
        hilo2 = "Ejemplo2";
    }

    public static SingletonHilos getInstance() {
        if (instance == null) {
            instance = new SingletonHilos();
        }
        return instance;
    }
    public synchronized void modifyAttributes(String texto1, String texto2) {
        hilo1 = texto1;
        hilo2 = texto2;
    }

    public String getHilo1() {
        return hilo1;
    }

    public String getHilo2() {
        return hilo2;
    }
}
