package composicion.productos;
public class ConfiguracionSimpleProducto extends AbstraccionProducto{
    protected String marca;
     
     public ConfiguracionSimpleProducto(String nombre, double precio, double tasa, int cantidad, String marca) {
        super(nombre, precio, tasa, cantidad);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
