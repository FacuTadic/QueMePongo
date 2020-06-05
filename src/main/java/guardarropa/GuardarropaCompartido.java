package guardarropa;

import prenda.Prenda;
import sugerenciasGuardarropaCompartido.SugerenciaCompartida;
import usuario.Usuario;

import java.util.List;

public class GuardarropaCompartido extends Guardarropa {

    EstadosDeGuardarropa estado = EstadosDeGuardarropa.COMPARTIDO;
    List<Usuario> usuariosCompartidos;
    List<SugerenciaCompartida> sugerenciasDeGuardarropa;

    public GuardarropaCompartido(List<Usuario> usuarios){
        super();
        this.usuariosCompartidos = usuarios;
    }

    public void agregarSugerencia(SugerenciaCompartida sugerencia){
        sugerenciasDeGuardarropa.add(sugerencia);
    }

    void quitarSugerencia(SugerenciaCompartida sugerencia){
        sugerenciasDeGuardarropa.remove(sugerencia);
    }

    List<SugerenciaCompartida> verSugerenciasDeGuardarropa(){
        return sugerenciasDeGuardarropa;
    }

    void aceptarSugerencia(SugerenciaCompartida sugerencia){
        sugerencia.aceptarSugerencia();
    }

    void rechazarSugerencia(SugerenciaCompartida sugerencia){
        sugerencia.rechazarSugerencia();
    }

    void deshacerCambiosAceptados(){
        sugerenciasDeGuardarropa.stream().forEach(sugerenciaCompartida -> sugerenciaCompartida.deshacerSugerencia(this));
    }

}
