package implementacion;

import fintech_c.*;

public class AdaptadorFintechC implements InterfaceFintechAdaptador, IntFintechCRecepcionCredito{
    private FintechCResultadoAprobacion FCresponse;

    @Override
    public FintechCreditoRespuesta EnvioSolicitudCredito(FintechSolicitudCredito request) {
        FintechCCreditos FCrequest = new FintechCCreditos();
        FCrequest.setValorCredito((float) request.getValor());
        FCrequest.setNombre(request.getCliente());
        FCrequest.setEdad(request.getEdad());

        FintechCRecepcionCredito sender = new FintechCRecepcionCredito();
        sender.sendCreditForValidate(FCrequest, this);

        do {
            try {
                Thread.sleep(10000);
                System.out.println("Fintech_C solicitud en espera....");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while ( FCresponse == null);

        FintechCreditoRespuesta response = new FintechCreditoRespuesta();
        response.setAprobacion(FCresponse.getAprobado() == "Y" ? true : false);
        return response;
    }

    @Override
    public void NotificacionResultado (FintechCResultadoAprobacion resultado) {
        this.FCresponse = resultado;
    }
}
