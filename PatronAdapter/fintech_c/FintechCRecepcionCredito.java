package fintech_c;

public class FintechCRecepcionCredito {
    public void sendCreditForValidate(final FintechCCreditos request, final IntFintechCRecepcionCredito listener){
        new Thread( new Runnable(){
            @Override
            public void run(){
                System.out.println("La Fintech C ha recibido su solicitud, dentro de poco recibirá una respuesta");
                FintechCResultadoAprobacion response = new FintechCResultadoAprobacion();
                if (request.getValorCredito() <= 300){
                    response.setAprobado("Y");
                } else {
                    response.setAprobado("N");
                }
                try {
                    Thread.sleep(1000 * 50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                listener.NotificacionResultado(response);
            }
        }).start();
    } 
}
