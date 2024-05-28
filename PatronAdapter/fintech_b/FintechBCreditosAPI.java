package fintech_b;

public class FintechBCreditosAPI {
    public FintechBRespuestaCredito sendCreditRequest(FintechBSolicitudCredito request){
        FintechBRespuestaCredito response =new FintechBRespuestaCredito();
        if(request.getValorSolicitado()<= 5000){
            response.setResultadoAprobacion(true);
        }else{
            response.setResultadoAprobacion(false);
        }
        return response;
    }
}
