package af.familiaws;

import abstractfactory.bases.IServiciosBasesGenericos;
import af.familiaWeb.ImplementacionWebRest;
import servicios.IServicioWeb;
import servicios.IServiciosArticulos;
import servicios.IServiciosEmpleados;


public class ImplementacionFabricaWS implements IServiciosBasesGenericos {
    @Override
    public IServiciosEmpleados getEmpleados() {
        return new ImplementacionWSEmpleados();
    }

    @Override
    public IServiciosArticulos getArticulos() {
        return new ImplementacionWSArticulos();
    }

}
