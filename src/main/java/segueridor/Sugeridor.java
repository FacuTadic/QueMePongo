package segueridor;

import prenda.Prenda;
import provedoresDeClima.AdministradorDeProveedoresDeClima;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Sugeridor {

    AdministradorDeProveedoresDeClima proveedoresDeClima = new AdministradorDeProveedoresDeClima();


    public List<Prenda> sugerirPrendaPorTemperatura(List<Prenda> prendas,String ciudad){
        Double temperatura = proveedoresDeClima.getProveedorUtilizado().obtenerTemperaturaDeCiudad(ciudad);
        return prendas.stream().filter(prenda -> prenda.aptoParaTemperatura(temperatura)).collect(Collectors.toList());
    }

    public List<Prenda> sugerenciaDiaria(List<Prenda> prendas,String ciudad){
        return prendas.forEach(prenda -> prenda.aptoParaAlerta(alertaDeCiudad(ciudad)));
    }

    public  List<Clima> alertaDeCiudad(String ciudad){
        return proveedoresDeClima.getProveedorUtilizado().obtenerAlertaDeCiudad(ciudad, LocalDate.now());
    }





}
