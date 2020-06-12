package notificador;

import provedoresDeClima.AdministradorDeProveedoresDeClima;
import tipoDeNotificacion.TipoDeNotificacion;

import java.time.LocalDate;
import java.util.List;

public class Notificador {
    List<TipoDeNotificacion> notificacionesRequeridas;
    AdministradorDeProveedoresDeClima proveedoresDeClima = new AdministradorDeProveedoresDeClima();

    public void agregarNotificacion(TipoDeNotificacion notificacion){
        notificacionesRequeridas.add(notificacion);
    }

    public void quitarNotificacion(TipoDeNotificacion notificacion){
        notificacionesRequeridas.remove(notificacion);
    }

    public void generarNotificacionA(String ciudad){
        notificacionesRequeridas.forEach(notificacion -> notificacion.generarAvisoDe(proveedoresDeClima.getProveedorUtilizado().obtenerAlertaDeCiudad(ciudad, LocalDate.now())));
    }



}
