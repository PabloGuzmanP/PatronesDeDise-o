package fintech_a;

public class FintechARecepcionCredito {
    public void sendCreditForValidate(final FintechACreditos request, final IntFintechARecepcionCredito listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("La Fintech A ha recibido su solicitud, dentro de poco recibirá una respuesta");
                FintechAResultadoAprobacion response = new FintechAResultadoAprobacion();
                if (request.getCredito() <= 1500) {
                    response.setAprobado("Y");
                } else {
                    response.setAprobado("N");
                }
                try {
                    Thread.sleep(1000 * 30);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                listener.NotificacionResultado(response);
            }
        }).start();
    }
}
