package af.familiarest;

import servicios.IServiciosArticulos;
public class ImplementacionRestArticulos implements IServiciosArticulos{
    private static final String[] ARTICULOS = new String[]{"Disco Duro", "Teclados", "Mouse"};

    @Override
    public String[] getArticulos() {
        System.out.println("Tipo de Servicio: Restful");
        return ARTICULOS;
    }
}
