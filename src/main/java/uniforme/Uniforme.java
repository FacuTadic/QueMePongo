package uniforme;

import prenda.categoria.CategoriaCalzado;
import prenda.categoria.CategoriaParteInferior;
import prenda.categoria.CategoriaParteSuperior;

public class Uniforme {
    CategoriaParteSuperior prendaSuperior;
    CategoriaParteInferior prendaInferior;
    CategoriaCalzado prendaCalzado;

    Uniforme(CategoriaParteSuperior prendaSuperiorACargar, CategoriaParteInferior prendaInferiorACargar, CategoriaCalzado prendaCalzadoACargar) {
        this.prendaSuperior = prendaSuperiorACargar;
        this.prendaInferior = prendaInferiorACargar;
        this.prendaCalzado = prendaCalzadoACargar;
    }


}
