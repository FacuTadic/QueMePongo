package sugerenciasGuardarropaCompartido;

import guardarropa.Guardarropa;
import guardarropa.GuardarropaCompartido;
import prenda.Prenda;

public class SugerenciaCompartida {
    TipoDeSugerencia sugerencia;
    Prenda prenda;
    Boolean feedbackDeSugerencia;

    public SugerenciaCompartida(TipoDeSugerencia tipo, Prenda prenda) {
        this.sugerencia = tipo;
        this.prenda = prenda;
    }

    public void realizarSugerencia(GuardarropaCompartido guardarropa){
        sugerencia.modificarGuardarropa(guardarropa, prenda);
    }

    public void aceptarSugerencia(){
        feedbackDeSugerencia = true;
    }

    public void rechazarSugerencia(){
        feedbackDeSugerencia = false;
    }

    public void deshacerSugerencia(GuardarropaCompartido guardarropa){
        sugerencia.deshacerModificacion(guardarropa, prenda);
    }

}
