package sugerenciasGuardarropaCompartido;

import guardarropa.GuardarropaCompartido;
import prenda.Prenda;

public interface TipoDeSugerencia {

    void modificarGuardarropa(GuardarropaCompartido guardarropa, Prenda prenda);

    void deshacerModificacion(GuardarropaCompartido guardarropa, Prenda prenda);

}
