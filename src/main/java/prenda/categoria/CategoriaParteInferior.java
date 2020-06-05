package prenda.categoria;

import org.apache.commons.lang3.EnumUtils;
import prenda.tipodeprenda.TipoDeCategoria;
import prenda.tipodeprenda.TipoDePrendaParteInferior;

public class CategoriaParteInferior implements Categoria {

    TipoDeCategoria categoria = TipoDeCategoria.PARTE_INFERIOR;

    @Override
    public TipoDeCategoria getCategoria() {
        return categoria;
    }

    @Override
    public Boolean esValido(String tipoDePrenda) {
        return EnumUtils.isValidEnum(TipoDePrendaParteInferior.class, tipoDePrenda);
    }

}
