package prenda.categoria;

import org.apache.commons.lang3.EnumUtils;
import prenda.tipodeprenda.TipoDeCategoria;
import prenda.tipodeprenda.TipoDePrendaParteSuperior;

public class CategoriaParteSuperior extends Categoria {

    TipoDeCategoria categoria = TipoDeCategoria.PARTE_SUPERIOR;

    @Override
    public TipoDeCategoria getCategoria() {
        return categoria;
    }

    @Override
    public Boolean esValido(String tipoDePrenda) {
        return EnumUtils.isValidEnum(TipoDePrendaParteSuperior.class, tipoDePrenda);
    }
}
