package prenda.categoria;

import org.apache.commons.lang3.EnumUtils;
import prenda.tipodeprenda.TipoDeCategoria;
import prenda.tipodeprenda.TipoDePrendaCalzado;

public class CategoriaCalzado implements Categoria {

    TipoDeCategoria categoria = TipoDeCategoria.CALZADO;

    @Override
    public TipoDeCategoria getCategoria() {
        return categoria;
    }

    @Override
    public Boolean esValido(String tipoDePrenda) {
        return EnumUtils.isValidEnum(TipoDePrendaCalzado.class, tipoDePrenda);
    }

}
