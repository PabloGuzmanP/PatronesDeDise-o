package Implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class FabricaCanciones {
    public static boolean HabilitarFlyweight = true;
    private static final Map<String, Cancion> PLAY_CANCION = new HashMap<>();
    private static long Secuencia = 0L;

    public static Cancion CrearItem(String NombreTema) {
        if (HabilitarFlyweight && PLAY_CANCION.containsKey(NombreTema)) {
            return PLAY_CANCION.get(NombreTema);
        } else {
            Cancion playItem = getFromDatabase(NombreTema);
            if (playItem == null) {
                playItem = new Cancion(++Secuencia, NombreTema);
                saveToDatabase(playItem);
            }
            PLAY_CANCION.put(NombreTema, playItem);
            return playItem;
        }
    }

    private static Cancion getFromDatabase(String NombreTema) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM canciones WHERE NombreCancion = ?")) {
            stmt.setString(1, NombreTema);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    long id = rs.getLong("id");
                    return new Cancion(id, NombreTema);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void saveToDatabase(Cancion playItem) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO canciones (id, NombreCancion) VALUES (?, ?)")) {
            stmt.setLong(1, playItem.getId());
            stmt.setString(2, playItem.getNombreCancion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

