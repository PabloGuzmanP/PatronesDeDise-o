package transferencia.datos;

public class Programa {
    private String nomPrograma;
    private String numSemetres;

    public Programa() {
    }

    public Programa(String nomPrograma, String numSemetres) {
        this.nomPrograma = nomPrograma;
        this.numSemetres = numSemetres;
    }

    public String getNomPrograma() {
        return nomPrograma;
    }

    public void setNomPrograma(String nomPrograma) {
        this.nomPrograma = nomPrograma;
    }

    public String getNumSemetres() {
        return numSemetres;
    }

    public void setNumSemetres(String numSemetres) {
        this.numSemetres = numSemetres;
    }

    @Override
    public String toString(){
        return "Progama{" + "Nombre_Programa = " + nomPrograma + ", Numero_Semestre = " + numSemetres + '}';
    }
}
