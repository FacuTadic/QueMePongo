package usuario;

import guardarropa.*;
import prenda.Prenda;
import prenda.categoria.Categoria;
import sugerenciasGuardarropaCompartido.SugerenciaCompartida;
import sugerenciasGuardarropaCompartido.TipoDeSugerencia;

import java.util.List;

public class Usuario {
    Guardarropa guardarropaUsuario = new GuardarropaPersonal(EstadosDeGuardarropa.PERSONAL,Categorias.DEFAULT);
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

}
