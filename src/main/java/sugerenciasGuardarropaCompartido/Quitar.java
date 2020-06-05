package sugerenciasGuardarropaCompartido;

import guardarropa.GuardarropaCompartido;
import prenda.Prenda;

public class Quitar implements TipoDeSugerencia {

    @Override
    public void modificarGuardarropa(GuardarropaCompartido guardarropa, Prenda prenda) {
        guardarropa.sacarPrenda(prenda);
    }

    @Override
    public void deshacerModificacion(GuardarropaCompartido guardarropa, Prenda prenda) {
        guardarropa.guardarPrenda(prenda);
    }
}
