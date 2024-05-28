package patronadapter;

import implementacion.AdaptadorFintechA;
import implementacion.AdaptadorFintechB;
import implementacion.AdaptadorFintechC;
import implementacion.FintechCreditoRespuesta;
import implementacion.FintechSolicitudCredito;
import implementacion.InterfaceFintechAdaptador;

public class PatronAdapterMain {
    public static void main(String[] args) {

        FintechSolicitudCredito request = new FintechSolicitudCredito();
        request.setCliente("Cristiano Ronaldo");
        request.setValor(1000);

        InterfaceFintechAdaptador FinancieraB = new AdaptadorFintechB();
        FintechCreditoRespuesta FBresponse = FinancieraB.EnvioSolicitudCredito(request);
        System.out.println("Resultado aprobación Financiera <<B>>: > " + FBresponse.isAprobacion() + "\n");

        if (FBresponse.isAprobacion()) {
            System.out.println("Felicitaciones!!!!!, la Financiera <<B>> aprobó su solicitud de crédito." + "\n");
        } else {
            System.out.println("Lo sentimos, la Financiera <<B>> no aprobó su crédito");
        }

        InterfaceFintechAdaptador FinancieraA = new AdaptadorFintechA();
        FintechCreditoRespuesta FAresponse = FinancieraA.EnvioSolicitudCredito(request);
        System.out.println("Resultado aprobación Financiera <<A>>: > " + FAresponse.isAprobacion() + "\n");

        if (FAresponse.isAprobacion()) {
            System.out.println("Felicitaciones!!!!!, la Financiera <<A>> aprobó su solicitud de crédito." + "\n");
        } else {
            System.out.println("Lo sentimos, la Financiera <<A>> no aprobó su crédito");
        }

        InterfaceFintechAdaptador FinancieraC = new AdaptadorFintechC();
        FintechCreditoRespuesta FCresponse = FinancieraC.EnvioSolicitudCredito(request);
        System.out.println("Resultado aprobación Financiera <<C>>: > " + FCresponse.isAprobacion() + "\n");

        if (FCresponse.isAprobacion()) {
            System.out.println("Felicitaciones!!!!!, la Financiera <<C>> aprobó su solicitud de crédito.");
        } else {
            System.out.println("Lo sentimos, la Financiera <<C>> no aprobó su crédito");
        }
    }
}
