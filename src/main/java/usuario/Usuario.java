package usuario;

import guardarropa.*;
import notificador.Notificador;
import notificador.TipoDeNotificacion;
import prenda.Prenda;
import prenda.categoria.Categoria;
import sugerenciasGuardarropaCompartido.SugerenciaCompartida;
import sugerenciasGuardarropaCompartido.TipoDeSugerencia;

import java.util.List;

public class Usuario {
    Guardarropa guardarropaUsuario = new GuardarropaPersonal(EstadosDeGuardarropa.PERSONAL,Categorias.DEFAULT);
    Notificador notificador = new Notificador();
    List<Guardarropa> guardarropasVinculados;


    List<Prenda> generarSugerenciaEn(String ciudad){
       return guardarropaUsuario.generarSugerencia(ciudad);
    }

    void crearGuarropasDeCategoria(Categorias categoriaDelNuevoGuardarropa){
        Guardarropa guardarropaCategoria = new GuardarropaPersonal(EstadosDeGuardarropa.PERSONAL, categoriaDelNuevoGuardarropa);
        guardarropaUsuario.agregarGuardarropaDeCategoria(guardarropaCategoria);
    }

    void crearGuardarropaCompartidoCon(List<Usuario> usuarios){
        GuardarropaCompartido guardarropa = new GuardarropaCompartido(usuarios);
        usuarios.stream().forEach(usuario -> usuario.agregarGuardarropaCompartido(guardarropa));
        guardarropasVinculados.add(guardarropa);
    }

    void agregarGuardarropaCompartido(Guardarropa guardarropaCompartido){
        guardarropasVinculados.add(guardarropaCompartido);
    }

    void generarSugerenciaEnGuardarropaCopartido(GuardarropaCompartido guardarropaCompartido,TipoDeSugerencia tipo, Prenda prenda ){
        guardarropaCompartido.agregarSugerencia(generarSugerencia(tipo,prenda));
    }

    SugerenciaCompartida generarSugerencia(TipoDeSugerencia tipo, Prenda prenda){
        return new SugerenciaCompartida(tipo,prenda);
    }


    void agregarMedioDeNotificacion(TipoDeNotificacion notificacion){
        notificador.agregarNotificacion(notificacion);
    }

    void quitarMedioDeNotificacion(TipoDeNotificacion notificacion){
        notificador.quitarNotificacion(notificacion);
    }



}
