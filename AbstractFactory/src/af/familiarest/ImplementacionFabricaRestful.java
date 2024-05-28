package af.familiarest;

import af.familiaWeb.ImplementacionWebRest;
import servicios.IServicioWeb;
import servicios.IServiciosArticulos;
import servicios.IServiciosEmpleados;
import abstractfactory.bases.IServiciosBasesGenericos;

public class ImplementacionFabricaRestful implements IServiciosBasesGenericos{
    @Override
    public IServiciosEmpleados getEmpleados() {
        return new ImplementacionRestEmpleados();
    }

    @Override
    public IServiciosArticulos getArticulos() {
        return new ImplementacionRestArticulos();
    }

}
