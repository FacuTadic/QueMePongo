package sugerenciasGuardarropaCompartido;

import guardarropa.GuardarropaCompartido;
import prenda.Prenda;

public class Agregar implements TipoDeSugerencia {

    @Override
    public void modificarGuardarropa(GuardarropaCompartido guardarropa, Prenda prenda) {
        guardarropa.guardarPrenda(prenda);
    }

    @Override
    public void deshacerModificacion(GuardarropaCompartido guardarropa, Prenda prenda) {
        guardarropa.sacarPrenda(prenda);
    }
}
