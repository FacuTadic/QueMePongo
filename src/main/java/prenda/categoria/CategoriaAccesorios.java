package prenda.categoria;

import java.util.Enumeration;

import org.apache.commons.lang3.EnumUtils;
import prenda.tipodeprenda.TipoDeCategoria;
import prenda.tipodeprenda.TipoDePrendaAccesorio;

public class CategoriaAccesorios implements Categoria {

    TipoDeCategoria categoria = TipoDeCategoria.ACCESORIO;

    @Override
    public TipoDeCategoria getCategoria() {
        return categoria;
    }

    @Override
    public Boolean esValido(String tipoDePrenda) {
        return EnumUtils.isValidEnum(TipoDePrendaAccesorio.class, tipoDePrenda);
    }
}
