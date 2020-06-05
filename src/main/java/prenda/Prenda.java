package prenda;

import material.Material;
import material.Trama;
import prenda.categoria.Categoria;
import prenda.tipodeprenda.TipoDeCategoria;

public class Prenda {
    String tipodePrenda;
    Categoria categoriaPrenda;
    Trama trama;
    Material material;
    String color;
    String colorSecundario;
    Integer temperaturaTopeAdecuada;

    public Prenda(String tipoDePrendaACargar, Categoria categoriaCargar, Material materialCargado, String colorCargado, String colorSec, Integer temperaturaSeleccionada) {
        this.tipodePrenda = tipoDePrendaACargar;
        this.categoriaPrenda = categoriaCargar;
        this.material = materialCargado;
        this.color = colorCargado;
        this.colorSecundario = colorSec;
        this.temperaturaTopeAdecuada = temperaturaSeleccionada;
    }

    public Prenda(String tipoDePrendaACargar, Categoria categoriaCargar, Material materialCargado, String colorCargado, Integer temperaturaSeleccionada) {
        this.tipodePrenda = tipoDePrendaACargar;
        this.categoriaPrenda = categoriaCargar;
        this.material = materialCargado;
        this.color = colorCargado;
        this.temperaturaTopeAdecuada = temperaturaSeleccionada;
    }

    public TipoDeCategoria getCategoria() {
        return categoriaPrenda.getCategoria();
    }

    public boolean aptoParaTemperatura(Double temperatura) {
        return temperaturaTopeAdecuada<= temperatura;
    }
}