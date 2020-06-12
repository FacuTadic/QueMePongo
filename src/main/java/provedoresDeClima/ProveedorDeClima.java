package provedoresDeClima;

import java.util.Date;

public interface ProveedorDeClima {
    public Integer obtenerTemperaturaDeCiudad(String ciudad);

    public Alerta obtenerAlertaDeCiudad(String ciudad, Date fecha);

    Double getComisionDeServicio();
}
