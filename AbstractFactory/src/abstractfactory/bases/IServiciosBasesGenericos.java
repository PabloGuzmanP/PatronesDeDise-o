package abstractfactory.bases;

import servicios.IServicioWeb;
import servicios.IServiciosArticulos;
import servicios.IServiciosEmpleados;


public interface IServiciosBasesGenericos {
    public IServiciosEmpleados getEmpleados();
    public IServiciosArticulos getArticulos();
}
