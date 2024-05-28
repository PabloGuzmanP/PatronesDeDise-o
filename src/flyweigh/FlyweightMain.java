package flyweigh;

import Implementacion.FabricaCanciones;
import Implementacion.ListaReproduccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlyweightMain {
    private static final String[] NombreCanciones = new String[1000];
    private static final String[] NombresListas = new String[20];
    private static final List<ListaReproduccion> Listas = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Proceso de creación de listas de reproducción iniciado...");
        FabricaCanciones.HabilitarFlyweight = true;
        InicializarArreglos();
        CrearListaDinamica();
        System.out.println("Total Listas: " + Listas.size());
        ImprimirListas();
    }

    private static void CrearListaDinamica() {
        Random random = new Random();
        int p = 0;
        for (int c = 0; c < NombresListas.length; c++) {
            ListaReproduccion playList = ListaReproduccion.getFromDatabase(NombresListas[c]);
            if (playList == null) {
                playList = new ListaReproduccion(NombresListas[c]);
                for (int i = 0; i < 10; i++) {
                    int song = random.nextInt(NombreCanciones.length);
                    playList.addCancion(NombreCanciones[song]);
                }
                playList.saveToDatabase(); // Guardar la lista de reproducción en la base de datos
                Listas.add(playList);
                if (c != 0 && (c + 1) % (NombresListas.length / 10) == 0) {
                    p += 10;
                    System.out.println("Finalizado " + p + "%");
                    System.out.println("Listas Creadas: " + Listas.size());
                }
            }
        }
    }

    private static void InicializarArreglos() {
        for (int c = 0; c < NombreCanciones.length; c++) {
            NombreCanciones[c] = "Canción " + (c + 1);
        }

        for (int c = 0; c < NombresListas.length; c++) {
            NombresListas[c] = "Lista " + (c + 1);
        }
    }

    private static void ImprimirListas() {
        for (ListaReproduccion playlist : Listas) {
            playlist.printPlaylist();
            System.out.println("-----------");
        }
    }
}
