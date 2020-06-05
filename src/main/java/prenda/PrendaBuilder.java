package prenda;

import material.Material;
import material.Trama;
import prenda.categoria.Categoria;
import prenda.exception.CreacionDePrendaException;
import prenda.exception.ValidacionDeCaracteresException;

import java.util.Objects;

public class PrendaBuilder {
    String tipodePrenda;
    Categoria categoriaPrenda;
    Trama trama = Trama.LISA;
    Material material;
    String colorPrincipal;
    String colorSecundario;
    Integer temperaturaSeleccionada;

    public PrendaBuilder(Categoria categoria) {
        romperSiEsNulo(categoria, "La categoria no puede ser nula");
        this.categoriaPrenda = categoria;
    }

    public void especificarTipo(String tipodePrenda) {
        romperSiEsNulo(tipodePrenda, "El tipo no puede ser nulo");
        validarTipoConCategoria(tipodePrenda, categoriaPrenda);
        this.tipodePrenda = tipodePrenda;
    }

    public void especificarTrama(Trama trama) {
        this.trama = trama;
    }

    public void especificarMaterial(Material material) {
        romperSiEsNulo(material, "El material no puede ser nulo");
        this.material = material;
    }

    public void especificarColorPrincipal(String colorPrincipal) {
        romperSiEsNulo(colorPrincipal, "El color principal no puede ser nulo");
        verificarExistenciaDeCaracteres(colorPrincipal);
        this.colorPrincipal = colorPrincipal;
    }

    public void especificarColorSecundario(String colorSecundario) {
        romperSiEsNulo(colorPrincipal, "El color principal no puede ser nulo");
        verificarExistenciaDeCaracteres(colorSecundario);
        this.colorSecundario = colorSecundario;
    }

    public Prenda crearPrenda() {
        verificarSiHayAtributosNulos();
        if (existeColorSecundario()) {
            return new Prenda(this.tipodePrenda, this.categoriaPrenda, this.material,
                    this.colorPrincipal, this.colorSecundario, this.temperaturaSeleccionada);
        } else {
            return new Prenda(this.tipodePrenda, this.categoriaPrenda, this.material,
                    this.colorPrincipal,this.temperaturaSeleccionada);
        }
    }


    private Boolean existeColorSecundario() {
        return Objects.isNull(this.colorSecundario) || colorSecundario.isEmpty();
    }


    private void verificarExistenciaDeCaracteres(String color) {
        if (color.isEmpty()) {
            throw new ValidacionDeCaracteresException("El color no puede ser una cadena vacia");
        }
    }

    private void verificarSiHayAtributosNulos() {
        romperSiEsNulo(tipodePrenda, "El tipo de prenda no puede ser nulo");
        romperSiEsNulo(material, "El material no puede ser nulo");
        romperSiEsNulo(colorPrincipal, "El color principal no puede ser nulo");
    }

    void validarTipoConCategoria(String tipoDePrendaACargar, Categoria categoria) {
        if (!categoria.esValido(tipoDePrendaACargar)) {
            throw new CreacionDePrendaException("El tipo de prenda elegido no es compatible con la categoria cargada");
        }

    }

    private void romperSiEsNulo(Object object, String message) {
        if (Objects.isNull(object))
            throw new CreacionDePrendaException(message);
    }


}
