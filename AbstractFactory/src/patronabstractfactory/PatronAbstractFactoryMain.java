package patronabstractfactory;

import abstractfactory.bases.IServiciosBasesGenericos;
import abstractfactory.bases.IServiciosGenericosWeb;
import abstractfactory.bases.ServiciosGenericosAbstractFactory;
import java.util.Arrays;

import servicios.IServicioWeb;
import servicios.IServiciosArticulos;
import servicios.IServiciosEmpleados;


public class PatronAbstractFactoryMain {
    public static void main(String[] args) throws Exception {

        IServiciosBasesGenericos factory =
                ServiciosGenericosAbstractFactory.createServiceFactory();
        IServiciosEmpleados employeeService = factory.getEmpleados();
        IServiciosArticulos productService = factory.getArticulos();

        IServiciosGenericosWeb factoryF =
                ServiciosGenericosAbstractFactory.createServiceFactoryF();
        IServicioWeb webService = factoryF.getServicioWeb();

        System.out.println("Servicio Empleados class > "
                + employeeService.getClass().getCanonicalName());
        System.out.println("Servicio Articulos class  > "
                + productService.getClass().getCanonicalName());
        System.out.println("Servicio Web class  > "
                + webService.getClass().getCanonicalName());

        System.out.println("getEmployee > "
                + Arrays.toString(employeeService.getEmpleados()));
        System.out.println("getProduct  > "
                + Arrays.toString(productService.getArticulos()));
        System.out.println("getWebService  > "
                + Arrays.toString(webService.getResponse().toCharArray()));
    }
}
