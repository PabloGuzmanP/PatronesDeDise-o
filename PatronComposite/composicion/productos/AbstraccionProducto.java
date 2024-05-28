package composicion.productos;


public abstract class AbstraccionProducto{
    protected String nombre;
    protected double precio;
    protected double tasa;
    protected double cantidad;
    protected double precioU;

    public AbstraccionProducto(String nombre, double precio, double tasa, double cantidad) {
        super();
        this.nombre = nombre;
        this.precio = precio;
        this.tasa = tasa;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        double precioCanti = this.precio * this.cantidad * (1+this.tasa);
        return precioCanti;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTasa() {
        double impuesto;
        impuesto = this.precio*this.tasa /100.0;
        return impuesto;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double precioUni(){
        precioU = this.precio;
        return precioU;
    }
    
}