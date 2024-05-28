package transferencia.datos;

public class Telefonos {
    private String numeroTelefono;
    private String extension;
    private String tipo;

    public Telefonos() {
    }

    public Telefonos(String numeroTelefono, String extension, String tipo) {
        this.numeroTelefono = numeroTelefono;
        this.extension = extension;
        this.tipo = tipo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Telefono{" + "Numero_Telefono=" + numeroTelefono + ", Extensión=" + extension + ", Tipo=" + tipo + '}';
    }
}
