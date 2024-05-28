package af.familiaWeb;

import abstractfactory.bases.IServiciosGenericosWeb;
import servicios.IServicioWeb;

public class ImplementacionFabricaRest implements IServiciosGenericosWeb {
    @Override
    public IServicioWeb getServicioWeb() { return new ImplementacionWebRest();}
}
