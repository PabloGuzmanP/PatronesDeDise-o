package composicion.ordenes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import composicion.productos.AbstraccionProducto;

public class OrdenVenta {
    private long CodigoOrden;
    private String Cliente;
    private List<AbstraccionProducto> productos = new ArrayList<AbstraccionProducto>();

    public OrdenVenta(long CodigoOrden, String Cliente) {
        super();
        this.CodigoOrden = CodigoOrden;
        this.Cliente = Cliente;
    }

    public double getPrecio() {
        double preciolocal = 0d;
        for (AbstraccionProducto child : productos) {
            preciolocal += child.getPrecio();
        }
        return preciolocal;
    }

    public double getTasa() {
        double tasalocal = 0d;
        for (AbstraccionProducto child : productos) {
            tasalocal += child.getTasa();
        }
        return tasalocal;
    }

    public double getPrecioUni(){
        double precioUnilocal = 0d;
        for (AbstraccionProducto child : productos) {
            precioUnilocal += child.precioUni();
        }
        return precioUnilocal;
    }

    public double getCantidad(){
        double cantidadlocal = 0d;
        for (AbstraccionProducto child : productos) {
            cantidadlocal += child.getCantidad();
        }
        return cantidadlocal;
    }

    public double getTotal() {
        double total;
        total = getPrecio()+getTasa();
        return total;
    }

    public void AgregarProducto(AbstraccionProducto producto) {
        productos.add(producto);
    }

    public void ImprimirOrdenVenta() {

        NumberFormat formater = new DecimalFormat("###,##0.00");
        System.out.println("\\\n============================================="
                + "\nCodigo_Orden: " + CodigoOrden + "\nCliente: " + Cliente
                + "\nProductos:\n");
        for (AbstraccionProducto prod : productos) {
            System.out.println(prod.getNombre() + "\t\t\t$ "
                    + formater.format(prod.getPrecio()));
            
        }
        System.out.println("\nCantidad: " + getCantidad());
        System.out.println("Precio: " + getPrecioUni());
        System.out.println("Tasa: " + getTasa());
        System.out.println("Precio+Cantidad: " + getPrecio());
        System.out.println("\nTotal: " + formater.format(getTotal()) 
                + "\n=============================================");
    }

    public long getCodigoOrden() {
        return CodigoOrden;
    }

    public void setCodigoOrden(long CodigoOrden) {
        this.CodigoOrden = CodigoOrden;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public List<AbstraccionProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<AbstraccionProducto> productos) {
        this.productos = productos;
    }
}
