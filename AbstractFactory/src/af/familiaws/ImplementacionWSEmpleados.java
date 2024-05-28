package af.familiaws;

import servicios.IServiciosEmpleados;

public class ImplementacionWSEmpleados implements IServiciosEmpleados{
    private static final String[] EMPLEADOS = new String[]{"Juan Guillermo", "David", "Luis Fernando"};

    @Override
    public String[] getEmpleados() {
        System.out.println("Tipo de Servicio: WebServices");
        return EMPLEADOS;
    }
}
