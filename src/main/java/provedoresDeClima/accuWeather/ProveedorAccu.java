package provedoresDeClima.accuWeather;

import alerta.Alerta;
import prenda.exception.UnidadDeTemperaturaDesconocidaException;
import provedoresDeClima.ProveedorDeClima;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProveedorAccu implements ProveedorDeClima {

    private AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI();

    Double comisionDeServicio= 0.05;
    Integer cantidadDeLlamadas = 0;
    Double gastoAcumulado = 0.0;


    //Modificar para temperatura
    public Integer obtenerTemperaturaDeCiudad(String ciudad) {
        List<Map<String, Object>> temperatura = accuWeatherAPI.getWeather(ciudad);
        HashMap<String, Object> condicionesClimaticas = (HashMap<String, Object>) temperatura.get(0).get("Temperatura");
        Integer valor = (Integer) condicionesClimaticas.get("Value");
        Character unidad = (Character) condicionesClimaticas.get("Unit");
        cantidadDeLlamadas++;
        calcularGastosDeServicio(cantidadDeLlamadas);
        return temperaturaACelsius(valor, unidad);
    }

    public Alerta obtenerAlertaDeCiudad(String ciudad, LocalDate fecha){
        AccuWeatherAPI apiClima = new AccuWeatherAPI();
        Map<String, Object> alertas = apiClima.getAlertas(ciudad);
        return alertas.get("CurrentAlerts"); //Devuelve un objeto como [“STORM”, “HAIL”, ...]

    }



    @Override
    public Double getComisionDeServicio() {
        return comisionDeServicio;
    }

    private Integer temperaturaACelsius(Integer valor, Character unidad) {
        switch (unidad) {
            case 'F':
                return deFarenheitaCelcius(valor);
            case 'C':
                return valor;
            default:
                throw new UnidadDeTemperaturaDesconocidaException("No se reconoce la unidad de temperatura");
        }
    }

    private Integer deFarenheitaCelcius(Integer temperatura) {
        return (temperatura - 32) * (5 / 9);
    }

    void calcularGastosDeServicio(Integer cantidadDeLlamadas){
        if(cantidadDeLlamadas>=10){
            gastoAcumulado += comisionDeServicio;
            cantidadDeLlamadas = 0;
        }
    }





}
