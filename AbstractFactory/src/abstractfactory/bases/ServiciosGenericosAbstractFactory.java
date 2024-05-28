package abstractfactory.bases;

import java.util.Properties;
import utilidades.UtilidadesAcceso;

public class ServiciosGenericosAbstractFactory {
    public ServiciosGenericosAbstractFactory() {}

    public static IServiciosBasesGenericos createServiceFactory() {
        Properties props = UtilidadesAcceso.loadProperty(
                "propiedades/AbsFactoryPropiedades.properties");
        String factoryClass =
                props.getProperty("servicioImplementado");
        try {
            return (IServiciosBasesGenericos)
                    Class.forName(factoryClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static IServiciosGenericosWeb createServiceFactoryF() {
        Properties props = UtilidadesAcceso.loadProperty(
                "propiedades/AbsFactoryPropiedades.properties");
        String factoryClassF =
                props.getProperty("servicioImplementadoWeb");
        try {
            return (IServiciosGenericosWeb)
                    Class.forName(factoryClassF).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
