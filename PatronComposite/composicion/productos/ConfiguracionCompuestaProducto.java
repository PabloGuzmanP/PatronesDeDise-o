package composicion.productos;
import java.util.ArrayList;
import java.util.List;

public class ConfiguracionCompuestaProducto extends AbstraccionProducto{
    private List<AbstraccionProducto> productos = new ArrayList<AbstraccionProducto>();

    public ConfiguracionCompuestaProducto(String nombre) {
        super(nombre, 0, 0, 0);
    }

    @Override
    public double getPrecio() {
        double preciolocal = 0d;
        for (AbstraccionProducto child : productos) {
            preciolocal += child.getPrecio();
        }
        return preciolocal;
    }

    @Override
    public void setPrecio(double precio) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getTasa() {
        double tasalocal = 0d;
        for (AbstraccionProducto child : productos) {
            tasalocal += child.getTasa();
        }
        return tasalocal;
    }

    @Override
    public void setTasa(double tasa) {
        throw new UnsupportedOperationException();
    }
    

    public void AgregarProducto(AbstraccionProducto producto) {
        this.productos.add(producto);
    }
    
    public boolean RemoverProductos(AbstraccionProducto producto) {
        return this.productos.remove(producto);
    }
}
