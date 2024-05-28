package Implementacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion {
    private String NombreLista;
    private List<Cancion> Canciones = new ArrayList<>();
    //private int uso;

    public ListaReproduccion(String NombreLista) {
        this.NombreLista = NombreLista;
    }
    /*public void incrementarUso() {
        uso++;
    }*/


    public String getNombreLista() {
        return NombreLista;
    }

    public void setNombreLista(String NombreLista) {
        this.NombreLista = NombreLista;
    }

    public List<Cancion> getCanciones() {
        return Canciones;
    }

    public void setCanciones(List<Cancion> Canciones) {
        this.Canciones = Canciones;
    }

    public void addCancion(String NombreCancion) {
        Canciones.add(FabricaCanciones.CrearItem(NombreCancion));
    }
    /*public static ListaReproduccion getLeastUsedPlaylist() {
        ListaReproduccion leastUsedPlaylist = null;
        int minUso = Integer.MAX_VALUE;
        for (ListaReproduccion playlist : Listas) {
            if (playlist.getUso() < minUso) {
                minUso = playlist.getUso();
                leastUsedPlaylist = playlist;
            }
        }
        return leastUsedPlaylist;
    }*/

    public void saveToDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO playlists (NombreLista) VALUES (?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, NombreLista);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int playlistId = generatedKeys.getInt(1);
                    saveCancionesToDatabase(playlistId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveCancionesToDatabase(int playlistId) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO canciones (NombreCancion, PlaylistId) VALUES (?, ?)")) {
            for (Cancion playItem : Canciones) {
                stmt.setString(1, playItem.getNombreCancion());
                stmt.setInt(2, playlistId);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ListaReproduccion getFromDatabase(String NombreLista) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM playlists WHERE NombreLista = ?")) {
            stmt.setString(1, NombreLista);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int playlistId = rs.getInt("id");
                    ListaReproduccion playlist = new ListaReproduccion(NombreLista);
                    playlist.loadCancionesFromDatabase(playlistId);
                    return playlist;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void loadCancionesFromDatabase(int playlistId) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM canciones WHERE PlaylistId = ?")) {
            stmt.setInt(1, playlistId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String NombreCancion = rs.getString("NombreCancion");
                    addCancion(NombreCancion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printPlaylist() {
        System.out.println("Lista de reproducción: " + NombreLista);
        for (Cancion playItem : Canciones) {
            System.out.println("- " + playItem.getNombreCancion());
        }
    }
    /*public void removeFromDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM playlists WHERE NombreLista = ?")) {
            stmt.setString(1, NombreLista);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
