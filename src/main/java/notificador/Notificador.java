package notificador;

import java.util.List;

public class Notificador {
    List<TipoDeNotificacion> notificacionesRequeridas;

    public void agregarNotificacion(TipoDeNotificacion notificacion){
        notificacionesRequeridas.add(notificacion);
    }

    public void quitarNotificacion(TipoDeNotificacion notificacion){
        notificacionesRequeridas.remove(notificacion);
    }

    public void generarNotificacionA(){
        notificacionesRequeridas.forEach(notificacion -> notificacion.generarAviso());
    }


}
