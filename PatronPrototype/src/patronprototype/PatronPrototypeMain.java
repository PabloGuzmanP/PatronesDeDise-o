package patronprototype;

import implementacion.CatalogoProductos;
import implementacion.FabricaPrototype;
import implementacion.ListaPrecios;

public class PatronPrototypeMain {
    public static void main(String[] args) {


        //Creación de la Lista Inicial de Precios

        ListaPrecios listadoEstandar = new ListaPrecios("Lista Estándar de Precios");
        for(int c = 1; c<=5; c++){
            CatalogoProductos item = new CatalogoProductos("Producto " + c, c*2);
            listadoEstandar.addCatalogoItem(item);
        }

        //Segunda lista para clientes mayoristas.
        //Se obtiene del listado estándar con un 10% de descuento.

        FabricaPrototype.addPrototype(listadoEstandar.getListado(), listadoEstandar);

        ListaPrecios listadoPorMayor = (ListaPrecios)
                FabricaPrototype.getPrototype("Lista Estándar de Precios");
        listadoPorMayor.setListado("Listado de Precios al Por Mayor");

        for(CatalogoProductos item : listadoPorMayor.getProductos()){
            item.setPrecioProducto(item.getPrecioProducto()*0.90);
        }
        FabricaPrototype.addPrototype(listadoPorMayor.getListado(), listadoPorMayor);

        //Tercera lista de precios para clientes Especiales.
        //Se obtiene de la listado Mayorista menos un 10%.
        ListaPrecios listadoClientesEspeciales = (ListaPrecios)
                FabricaPrototype.getPrototype("Listado de Precios al Por Mayor");
        listadoClientesEspeciales.setListado("Listado de Precios Clientes Especiales");

        for(CatalogoProductos item : listadoClientesEspeciales.getProductos()){
            item.setPrecioProducto(item.getPrecioProducto()*0.90);
        }

        //Cuarta lista de precios para clientes minoristas.
        //Se obtiene del listado estándar con un 19% de descuento.

        FabricaPrototype.addPrototype(listadoEstandar.getListado(), listadoEstandar);

        ListaPrecios listadoPorMenor = (ListaPrecios)
                FabricaPrototype.getPrototype("Lista Estándar de Precios");
        listadoPorMenor.setListado("Listado de Precios al Por Menor");

        for(CatalogoProductos item : listadoPorMenor.getProductos()){
            item.setPrecioProducto(item.getPrecioProducto()*0.81);
        }
        FabricaPrototype.addPrototype(listadoPorMenor.getListado(), listadoPorMenor);

        //Quint lista de precios para clientes de tiendas.
        //Se obtiene del listado estándar con un 5% de descuento.

        FabricaPrototype.addPrototype(listadoEstandar.getListado(), listadoEstandar);

        ListaPrecios listadoTienda = (ListaPrecios)
                FabricaPrototype.getPrototype("Lista Estándar de Precios");
        listadoPorMenor.setListado("Listado de Precios para las tiendas");

        for(CatalogoProductos item : listadoTienda.getProductos()){
            item.setPrecioProducto(item.getPrecioProducto()*0.95);
        }
        FabricaPrototype.addPrototype(listadoTienda.getListado(), listadoTienda);

        //Imprimimos las diferentes listas.
        System.out.println(listadoEstandar);
        System.out.println(listadoPorMayor);
        System.out.println(listadoClientesEspeciales);
        System.out.println(listadoPorMenor);
        System.out.println(listadoTienda);


    }
}
