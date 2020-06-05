package prenda.categoria;

import prenda.tipodeprenda.TipoDeCategoria;

public abstract class Categoria {

    TipoDeCategoria categoria;

    public TipoDeCategoria getCategoria(){
        return categoria;
    }

    public abstract Boolean esValido(String tipoDePrenda);
}
