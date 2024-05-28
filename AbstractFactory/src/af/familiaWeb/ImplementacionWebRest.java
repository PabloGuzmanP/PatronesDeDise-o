package af.familiaWeb;

import servicios.IServicioWeb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImplementacionWebRest implements IServicioWeb {
    @Override
    public String getResponse() throws Exception{
        System.out.println("Servicio Web Rest");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://fcc-weather-api.glitch.me/api/current?lat=4.60971&lon=-74.08175"))
                .GET()
                .build();
        try {
            HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
            return respuesta.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
