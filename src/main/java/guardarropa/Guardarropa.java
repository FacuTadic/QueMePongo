package guardarropa;

import prenda.Prenda;
import prenda.tipodeprenda.TipoDeCategoria;
import segueridor.Sugeridor;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Guardarropa {
    EstadosDeGuardarropa estado;
    Categorias categoria;
    List<Prenda> guardarropa;
    Sugeridor sugeridor = new Sugeridor();
    List<Guardarropa> guardarropaDeCategoria;

    public void guardarPrenda(Prenda prenda) {
        guardarropa.add(prenda);
    }

    void sacarPrenda(Prenda prenda) {
        guardarropa.remove(prenda);
    }

    List<Prenda> getPrendas(){ return guardarropa; }

    public List<Prenda> getPrendasSuperiores() {
        return guardarropa.stream().filter(prenda -> prenda.getCategoria() == TipoDeCategoria.PARTE_SUPERIOR).collect(Collectors.toList());
    }

    public List<Prenda> getPrendasInferiores() {
        return guardarropa.stream().filter(prenda -> prenda.getCategoria() == TipoDeCategoria.PARTE_INFERIOR).collect(Collectors.toList());
    }

    public List<Prenda> getCalzados() {
        return guardarropa.stream().filter(prenda -> prenda.getCategoria() == TipoDeCategoria.CALZADO).collect(Collectors.toList());
    }

    public List<Prenda> getAccesorios() {
        return guardarropa.stream().filter(prenda -> prenda.getCategoria() == TipoDeCategoria.ACCESORIO).collect(Collectors.toList());
    }


    public List<Prenda> generarSugerencia(String ciudad) {
        return sugeridor.sugerirPrendaPorTemperatura(guardarropa, ciudad);
    }

    public void agregarGuardarropaDeCategoria(Guardarropa guardarropaCategoria){
        guardarropaDeCategoria.add(guardarropaCategoria);
    }
}
